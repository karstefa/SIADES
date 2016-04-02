package sv.edu.entidades.acciones;

import sv.edu.entidades.UsuarioEmpleadoRol;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioEmpleadoRolController")
@ViewScoped
public class UsuarioEmpleadoRolController extends AbstractController<UsuarioEmpleadoRol> {

    @Inject
    private AutorizacionUsuarioEmpleadoController autorizacionUsuarioEmpleadoListController;
    @Inject
    private EmpleadoController idEmpleadoController;
    @Inject
    private RolController idRolController;

    public UsuarioEmpleadoRolController() {
        // Inform the Abstract parent controller of the concrete UsuarioEmpleadoRol?cap_first Entity
        super(UsuarioEmpleadoRol.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEmpleadoController.setSelected(null);
        idRolController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of
     * AutorizacionUsuarioEmpleado entities that are retrieved from
     * UsuarioEmpleadoRol?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AutorizacionUsuarioEmpleado page
     */
    public String navigateAutorizacionUsuarioEmpleadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AutorizacionUsuarioEmpleado_items", this.getSelected().getAutorizacionUsuarioEmpleadoList());
        }
        return "/autorizacionUsuarioEmpleado/index";
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
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRol(ActionEvent event) {
        if (this.getSelected() != null && idRolController.getSelected() == null) {
            idRolController.setSelected(this.getSelected().getIdRol());
        }
    }
}
