package sv.edu.entidades.acciones;

import sv.edu.entidades.Constancia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "constanciaController")
@ViewScoped
public class ConstanciaController extends AbstractController<Constancia> {

    @Inject
    private TipoConstanciaController idTipoConstanciaController;
    @Inject
    private PagoController idPagoController;

    public ConstanciaController() {
        // Inform the Abstract parent controller of the concrete Constancia?cap_first Entity
        super(Constancia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoConstanciaController.setSelected(null);
        idPagoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoConstancia controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoConstancia(ActionEvent event) {
        if (this.getSelected() != null && idTipoConstanciaController.getSelected() == null) {
            idTipoConstanciaController.setSelected(this.getSelected().getIdTipoConstancia());
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
