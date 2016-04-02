package sv.edu.entidades.acciones;

import sv.edu.entidades.OrdenDetalle;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ordenDetalleController")
@ViewScoped
public class OrdenDetalleController extends AbstractController<OrdenDetalle> {

    @Inject
    private DonacionController idDonacionController;
    @Inject
    private OrdenController idOrdenController;

    public OrdenDetalleController() {
        // Inform the Abstract parent controller of the concrete OrdenDetalle?cap_first Entity
        super(OrdenDetalle.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDonacionController.setSelected(null);
        idOrdenController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Donacion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDonacion(ActionEvent event) {
        if (this.getSelected() != null && idDonacionController.getSelected() == null) {
            idDonacionController.setSelected(this.getSelected().getIdDonacion());
        }
    }

    /**
     * Sets the "selected" attribute of the Orden controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdOrden(ActionEvent event) {
        if (this.getSelected() != null && idOrdenController.getSelected() == null) {
            idOrdenController.setSelected(this.getSelected().getIdOrden());
        }
    }
}
