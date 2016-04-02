package sv.edu.entidades.acciones;

import sv.edu.entidades.DetalleProductoDonante;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalleProductoDonanteController")
@ViewScoped
public class DetalleProductoDonanteController extends AbstractController<DetalleProductoDonante> {

    @Inject
    private ProductoDonanteController idDetalleProductoController;

    public DetalleProductoDonanteController() {
        // Inform the Abstract parent controller of the concrete DetalleProductoDonante?cap_first Entity
        super(DetalleProductoDonante.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDetalleProductoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ProductoDonante controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDetalleProducto(ActionEvent event) {
        if (this.getSelected() != null && idDetalleProductoController.getSelected() == null) {
            idDetalleProductoController.setSelected(this.getSelected().getIdDetalleProducto());
        }
    }
}
