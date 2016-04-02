package sv.edu.entidades.acciones;

import sv.edu.entidades.Departamento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> {

    @Inject
    private PaisController idPaisController;
    @Inject
    private MunicipioController municipioListController;

    public DepartamentoController() {
        // Inform the Abstract parent controller of the concrete Departamento?cap_first Entity
        super(Departamento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPaisController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Pais controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPais(ActionEvent event) {
        if (this.getSelected() != null && idPaisController.getSelected() == null) {
            idPaisController.setSelected(this.getSelected().getIdPais());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Municipio entities that
     * are retrieved from Departamento?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Municipio page
     */
    public String navigateMunicipioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Municipio_items", this.getSelected().getMunicipioList());
        }
        return "/municipio/index";
    }

}
