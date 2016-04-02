package sv.edu.entidades.acciones;

import sv.edu.entidades.ProductoDonante;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "productoDonanteController")
@ViewScoped
public class ProductoDonanteController extends AbstractController<ProductoDonante> {

    @Inject
    private DonanteController idDonanteController;
    @Inject
    private DonacionController idDonacionController;
    @Inject
    private DetalleProductoDonanteController detalleProductoDonanteListController;

    public ProductoDonanteController() {
        // Inform the Abstract parent controller of the concrete ProductoDonante?cap_first Entity
        super(ProductoDonante.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDonanteController.setSelected(null);
        idDonacionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Donante controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDonante(ActionEvent event) {
        if (this.getSelected() != null && idDonanteController.getSelected() == null) {
            idDonanteController.setSelected(this.getSelected().getIdDonante());
        }
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
     * Sets the "items" attribute with a collection of DetalleProductoDonante
     * entities that are retrieved from ProductoDonante?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for DetalleProductoDonante page
     */
    public String navigateDetalleProductoDonanteList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalleProductoDonante_items", this.getSelected().getDetalleProductoDonanteList());
        }
        return "/detalleProductoDonante/index";
    }

}
