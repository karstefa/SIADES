package sv.edu.entidades.acciones;

import sv.edu.entidades.Municipio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "municipioController")
@ViewScoped
public class MunicipioController extends AbstractController<Municipio> {

    @Inject
    private DireccionController direccionListController;
    @Inject
    private DepartamentoController idDepartamentoController;

    public MunicipioController() {
        // Inform the Abstract parent controller of the concrete Municipio?cap_first Entity
        super(Municipio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDepartamentoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Direccion entities that
     * are retrieved from Municipio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Direccion page
     */
    public String navigateDireccionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Direccion_items", this.getSelected().getDireccionList());
        }
        return "/direccion/index";
    }

    /**
     * Sets the "selected" attribute of the Departamento controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDepartamento(ActionEvent event) {
        if (this.getSelected() != null && idDepartamentoController.getSelected() == null) {
            idDepartamentoController.setSelected(this.getSelected().getIdDepartamento());
        }
    }
}
