package sv.edu.entidades.acciones;

import sv.edu.entidades.Rol;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "rolController")
@ViewScoped
public class RolController extends AbstractController<Rol> {

    @Inject
    private PermisoController idPermisoController;
    @Inject
    private UsuarioSocioRolController usuarioSocioRolListController;
    @Inject
    private UsuarioEmpleadoRolController usuarioEmpleadoRolListController;

    public RolController() {
        // Inform the Abstract parent controller of the concrete Rol?cap_first Entity
        super(Rol.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPermisoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Permiso controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPermiso(ActionEvent event) {
        if (this.getSelected() != null && idPermisoController.getSelected() == null) {
            idPermisoController.setSelected(this.getSelected().getIdPermiso());
        }
    }

    /**
     * Sets the "items" attribute with a collection of UsuarioSocioRol entities
     * that are retrieved from Rol?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for UsuarioSocioRol page
     */
    public String navigateUsuarioSocioRolList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UsuarioSocioRol_items", this.getSelected().getUsuarioSocioRolList());
        }
        return "/usuarioSocioRol/index";
    }

    /**
     * Sets the "items" attribute with a collection of UsuarioEmpleadoRol
     * entities that are retrieved from Rol?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for UsuarioEmpleadoRol page
     */
    public String navigateUsuarioEmpleadoRolList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UsuarioEmpleadoRol_items", this.getSelected().getUsuarioEmpleadoRolList());
        }
        return "/usuarioEmpleadoRol/index";
    }

}
