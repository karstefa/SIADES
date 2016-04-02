package sv.edu.entidades.acciones;

import sv.edu.entidades.TipoPermiso;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoPermisoController")
@ViewScoped
public class TipoPermisoController extends AbstractController<TipoPermiso> {

    @Inject
    private PermisoController permisoListController;

    public TipoPermisoController() {
        // Inform the Abstract parent controller of the concrete TipoPermiso?cap_first Entity
        super(TipoPermiso.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Permiso entities that are
     * retrieved from TipoPermiso?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Permiso page
     */
    public String navigatePermisoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Permiso_items", this.getSelected().getPermisoList());
        }
        return "/permiso/index";
    }

}
