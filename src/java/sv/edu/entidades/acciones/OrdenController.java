package sv.edu.entidades.acciones;

import sv.edu.entidades.Orden;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ordenController")
@ViewScoped
public class OrdenController extends AbstractController<Orden> {

    @Inject
    private OrdenDetalleController ordenDetalleListController;
    @Inject
    private ProyectoController idProyectoController;

    public OrdenController() {
        // Inform the Abstract parent controller of the concrete Orden?cap_first Entity
        super(Orden.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idProyectoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of OrdenDetalle entities
     * that are retrieved from Orden?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenDetalle page
     */
    public String navigateOrdenDetalleList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenDetalle_items", this.getSelected().getOrdenDetalleList());
        }
        return "/ordenDetalle/index";
    }

    /**
     * Sets the "selected" attribute of the Proyecto controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdProyecto(ActionEvent event) {
        if (this.getSelected() != null && idProyectoController.getSelected() == null) {
            idProyectoController.setSelected(this.getSelected().getIdProyecto());
        }
    }
}
