package sv.edu.entidades.acciones;

import sv.edu.entidades.Direccion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "direccionController")
@ViewScoped
public class DireccionController extends AbstractController<Direccion> {

    @Inject
    private MunicipioController idMunicipioController;
    @Inject
    private DireccionPersonaController direccionPersonaListController;
    @Inject
    private DireccionEmpleadoController direccionEmpleadoListController;

    public DireccionController() {
        // Inform the Abstract parent controller of the concrete Direccion?cap_first Entity
        super(Direccion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMunicipioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Municipio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMunicipio(ActionEvent event) {
        if (this.getSelected() != null && idMunicipioController.getSelected() == null) {
            idMunicipioController.setSelected(this.getSelected().getIdMunicipio());
        }
    }

    /**
     * Sets the "items" attribute with a collection of DireccionPersona entities
     * that are retrieved from Direccion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DireccionPersona page
     */
    public String navigateDireccionPersonaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionPersona_items", this.getSelected().getDireccionPersonaList());
        }
        return "/direccionPersona/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionEmpleado
     * entities that are retrieved from Direccion?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionEmpleado page
     */
    public String navigateDireccionEmpleadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionEmpleado_items", this.getSelected().getDireccionEmpleadoList());
        }
        return "/direccionEmpleado/index";
    }

}
