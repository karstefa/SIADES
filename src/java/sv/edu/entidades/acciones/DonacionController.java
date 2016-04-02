package sv.edu.entidades.acciones;

import sv.edu.entidades.Donacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "donacionController")
@ViewScoped
public class DonacionController extends AbstractController<Donacion> {

    @Inject
    private ExistenciaProductoController existenciaProductoListController;
    @Inject
    private TipoDonacionController idTipoDonacionController;
    @Inject
    private OrdenDetalleController ordenDetalleListController;
    @Inject
    private DonacionMembresiaController donacionMembresiaListController;
    @Inject
    private ProductoDonanteController productoDonanteListController;

    public DonacionController() {
        // Inform the Abstract parent controller of the concrete Donacion?cap_first Entity
        super(Donacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoDonacionController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ExistenciaProducto
     * entities that are retrieved from Donacion?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for ExistenciaProducto page
     */
    public String navigateExistenciaProductoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ExistenciaProducto_items", this.getSelected().getExistenciaProductoList());
        }
        return "/existenciaProducto/index";
    }

    /**
     * Sets the "selected" attribute of the TipoDonacion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoDonacion(ActionEvent event) {
        if (this.getSelected() != null && idTipoDonacionController.getSelected() == null) {
            idTipoDonacionController.setSelected(this.getSelected().getIdTipoDonacion());
        }
    }

    /**
     * Sets the "items" attribute with a collection of OrdenDetalle entities
     * that are retrieved from Donacion?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of DonacionMembresia
     * entities that are retrieved from Donacion?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DonacionMembresia page
     */
    public String navigateDonacionMembresiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DonacionMembresia_items", this.getSelected().getDonacionMembresiaList());
        }
        return "/donacionMembresia/index";
    }

    /**
     * Sets the "items" attribute with a collection of ProductoDonante entities
     * that are retrieved from Donacion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ProductoDonante page
     */
    public String navigateProductoDonanteList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ProductoDonante_items", this.getSelected().getProductoDonanteList());
        }
        return "/productoDonante/index";
    }

}
