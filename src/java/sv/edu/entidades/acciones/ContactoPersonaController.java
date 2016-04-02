package sv.edu.entidades.acciones;

import sv.edu.entidades.ContactoPersona;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "contactoPersonaController")
@ViewScoped
public class ContactoPersonaController extends AbstractController<ContactoPersona> {

    @Inject
    private SocioController idPersonaController;
    @Inject
    private ContactoController idContactoController;

    public ContactoPersonaController() {
        // Inform the Abstract parent controller of the concrete ContactoPersona?cap_first Entity
        super(ContactoPersona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPersonaController.setSelected(null);
        idContactoController.setSelected(null);
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
     * Sets the "selected" attribute of the Contacto controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdContacto(ActionEvent event) {
        if (this.getSelected() != null && idContactoController.getSelected() == null) {
            idContactoController.setSelected(this.getSelected().getIdContacto());
        }
    }
}
