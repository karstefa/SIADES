package sv.edu.entidades.acciones;

import sv.edu.entidades.ContactoEmpleado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "contactoEmpleadoController")
@ViewScoped
public class ContactoEmpleadoController extends AbstractController<ContactoEmpleado> {

    @Inject
    private EmpleadoController idEmpleadoController;
    @Inject
    private ContactoController idContactoController;

    public ContactoEmpleadoController() {
        // Inform the Abstract parent controller of the concrete ContactoEmpleado?cap_first Entity
        super(ContactoEmpleado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEmpleadoController.setSelected(null);
        idContactoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Empleado controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmpleado(ActionEvent event) {
        if (this.getSelected() != null && idEmpleadoController.getSelected() == null) {
            idEmpleadoController.setSelected(this.getSelected().getIdEmpleado());
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
