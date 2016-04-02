package sv.edu.entidades.acciones;

import sv.edu.entidades.Permiso;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "permisoController")
@ViewScoped
public class PermisoController extends AbstractController<Permiso> {

    @Inject
    private TipoPermisoController idTipoPermisoController;
    @Inject
    private RolController rolListController;

    public PermisoController() {
        // Inform the Abstract parent controller of the concrete Permiso?cap_first Entity
        super(Permiso.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoPermisoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoPermiso controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoPermiso(ActionEvent event) {
        if (this.getSelected() != null && idTipoPermisoController.getSelected() == null) {
            idTipoPermisoController.setSelected(this.getSelected().getIdTipoPermiso());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Rol entities that are
     * retrieved from Permiso?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Rol page
     */
    public String navigateRolList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rol_items", this.getSelected().getRolList());
        }
        return "/rol/index";
    }

}
