package sv.edu.entidades.acciones;

import sv.edu.entidades.Estudio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "estudioController")
@ViewScoped
public class EstudioController extends AbstractController<Estudio> {

    @Inject
    private SocioController idPersonaController;
    @Inject
    private TituloController tituloListController;

    public EstudioController() {
        // Inform the Abstract parent controller of the concrete Estudio?cap_first Entity
        super(Estudio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPersonaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Socio controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPersona(ActionEvent event) {
        if (this.getSelected() != null && idPersonaController.getSelected() == null) {
            idPersonaController.setSelected(this.getSelected().getIdPersona());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Titulo entities that are
     * retrieved from Estudio?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Titulo page
     */
    public String navigateTituloList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Titulo_items", this.getSelected().getTituloList());
        }
        return "/titulo/index";
    }

}
