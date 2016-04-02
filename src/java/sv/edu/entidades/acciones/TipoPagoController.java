package sv.edu.entidades.acciones;

import sv.edu.entidades.TipoPago;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoPagoController")
@ViewScoped
public class TipoPagoController extends AbstractController<TipoPago> {

    @Inject
    private PagoController pagoListController;

    public TipoPagoController() {
        // Inform the Abstract parent controller of the concrete TipoPago?cap_first Entity
        super(TipoPago.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Pago entities that are
     * retrieved from TipoPago?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Pago page
     */
    public String navigatePagoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Pago_items", this.getSelected().getPagoList());
        }
        return "/pago/index";
    }

}
