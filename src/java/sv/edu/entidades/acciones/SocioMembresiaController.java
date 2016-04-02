package sv.edu.entidades.acciones;

import sv.edu.entidades.SocioMembresia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "socioMembresiaController")
@ViewScoped
public class SocioMembresiaController extends AbstractController<SocioMembresia> {

    @Inject
    private SocioController idPersonaController;
    @Inject
    private MembresiaController idMembresiaController;

    public SocioMembresiaController() {
        // Inform the Abstract parent controller of the concrete SocioMembresia?cap_first Entity
        super(SocioMembresia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPersonaController.setSelected(null);
        idMembresiaController.setSelected(null);
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
     * Sets the "selected" attribute of the Membresia controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMembresia(ActionEvent event) {
        if (this.getSelected() != null && idMembresiaController.getSelected() == null) {
            idMembresiaController.setSelected(this.getSelected().getIdMembresia());
        }
    }
}
