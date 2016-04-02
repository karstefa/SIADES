package sv.edu.entidades.acciones;

import sv.edu.entidades.AutorizacionUsuarioEmpleado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "autorizacionUsuarioEmpleadoController")
@ViewScoped
public class AutorizacionUsuarioEmpleadoController extends AbstractController<AutorizacionUsuarioEmpleado> {

    @Inject
    private UsuarioEmpleadoRolController idUsuarioController;

    public AutorizacionUsuarioEmpleadoController() {
        // Inform the Abstract parent controller of the concrete AutorizacionUsuarioEmpleado?cap_first Entity
        super(AutorizacionUsuarioEmpleado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idUsuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the UsuarioEmpleadoRol controller in
     * order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUsuario(ActionEvent event) {
        if (this.getSelected() != null && idUsuarioController.getSelected() == null) {
            idUsuarioController.setSelected(this.getSelected().getIdUsuario());
        }
    }
}
