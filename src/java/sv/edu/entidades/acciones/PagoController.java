package sv.edu.entidades.acciones;

import sv.edu.entidades.Pago;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pagoController")
@ViewScoped
public class PagoController extends AbstractController<Pago> {

    @Inject
    private TipoPagoController idTipoPagoController;
    @Inject
    private PagoMembresiaController pagoMembresiaListController;
    @Inject
    private MoraPagoController moraPagoListController;
    @Inject
    private ConstanciaController constanciaListController;

    public PagoController() {
        // Inform the Abstract parent controller of the concrete Pago?cap_first Entity
        super(Pago.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoPagoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoPago controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoPago(ActionEvent event) {
        if (this.getSelected() != null && idTipoPagoController.getSelected() == null) {
            idTipoPagoController.setSelected(this.getSelected().getIdTipoPago());
        }
    }

    /**
     * Sets the "items" attribute with a collection of PagoMembresia entities
     * that are retrieved from Pago?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PagoMembresia page
     */
    public String navigatePagoMembresiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PagoMembresia_items", this.getSelected().getPagoMembresiaList());
        }
        return "/pagoMembresia/index";
    }

    /**
     * Sets the "items" attribute with a collection of MoraPago entities that
     * are retrieved from Pago?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for MoraPago page
     */
    public String navigateMoraPagoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MoraPago_items", this.getSelected().getMoraPagoList());
        }
        return "/moraPago/index";
    }

    /**
     * Sets the "items" attribute with a collection of Constancia entities that
     * are retrieved from Pago?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Constancia page
     */
    public String navigateConstanciaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Constancia_items", this.getSelected().getConstanciaList());
        }
        return "/constancia/index";
    }

}
