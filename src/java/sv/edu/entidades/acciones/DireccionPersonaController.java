package sv.edu.entidades.acciones;

import sv.edu.entidades.DireccionPersona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "direccionPersonaController")
@ViewScoped
public class DireccionPersonaController extends AbstractController<DireccionPersona> {

    @Inject
    private SocioController idPersonaController;
    @Inject
    private DireccionController idDireccionController;

    public DireccionPersonaController() {
        // Inform the Abstract parent controller of the concrete DireccionPersona?cap_first Entity
        super(DireccionPersona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPersonaController.setSelected(null);
        idDireccionController.setSelected(null);
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
     * Sets the "selected" attribute of the Direccion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDireccion(ActionEvent event) {
        if (this.getSelected() != null && idDireccionController.getSelected() == null) {
            idDireccionController.setSelected(this.getSelected().getIdDireccion());
        }
    }
}
