package sv.edu.entidades.acciones;

import sv.edu.entidades.MoraPago;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "moraPagoController")
@ViewScoped
public class MoraPagoController extends AbstractController<MoraPago> {

    @Inject
    private MoraController idMoraController;
    @Inject
    private PagoController idPagoController;

    public MoraPagoController() {
        // Inform the Abstract parent controller of the concrete MoraPago?cap_first Entity
        super(MoraPago.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMoraController.setSelected(null);
        idPagoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Mora controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMora(ActionEvent event) {
        if (this.getSelected() != null && idMoraController.getSelected() == null) {
            idMoraController.setSelected(this.getSelected().getIdMora());
        }
    }

    /**
     * Sets the "selected" attribute of the Pago controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPago(ActionEvent event) {
        if (this.getSelected() != null && idPagoController.getSelected() == null) {
            idPagoController.setSelected(this.getSelected().getIdPago());
        }
    }
}
