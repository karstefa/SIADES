package sv.edu.entidades.acciones;

import sv.edu.entidades.TipoProyecto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoProyectoController")
@ViewScoped
public class TipoProyectoController extends AbstractController<TipoProyecto> {

    @Inject
    private ProyectoController proyectoListController;

    public TipoProyectoController() {
        // Inform the Abstract parent controller of the concrete TipoProyecto?cap_first Entity
        super(TipoProyecto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Proyecto entities that
     * are retrieved from TipoProyecto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Proyecto page
     */
    public String navigateProyectoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Proyecto_items", this.getSelected().getProyectoList());
        }
        return "/proyecto/index";
    }

}
