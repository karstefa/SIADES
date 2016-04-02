package sv.edu.entidades.acciones;

import sv.edu.entidades.ProyectoSocio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "proyectoSocioController")
@ViewScoped
public class ProyectoSocioController extends AbstractController<ProyectoSocio> {

    @Inject
    private ProyectoController idProyectoController;
    @Inject
    private SocioController idPersonaController;

    public ProyectoSocioController() {
        // Inform the Abstract parent controller of the concrete ProyectoSocio?cap_first Entity
        super(ProyectoSocio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idProyectoController.setSelected(null);
        idPersonaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Proyecto controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdProyecto(ActionEvent event) {
        if (this.getSelected() != null && idProyectoController.getSelected() == null) {
            idProyectoController.setSelected(this.getSelected().getIdProyecto());
        }
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
}
