package sv.edu.entidades.acciones;

import sv.edu.entidades.PagoMembresia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "pagoMembresiaController")
@ViewScoped
public class PagoMembresiaController extends AbstractController<PagoMembresia> {

    @Inject
    private PagoController idPagoController;
    @Inject
    private MembresiaController idMembresiaController;

    public PagoMembresiaController() {
        // Inform the Abstract parent controller of the concrete PagoMembresia?cap_first Entity
        super(PagoMembresia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPagoController.setSelected(null);
        idMembresiaController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Membresia controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMembresia(ActionEvent event) {
        if (this.getSelected() != null && idMembresiaController.getSelected() == null) {
            idMembresiaController.setSelected(this.getSelected().getIdMembresia());
        }
    }
}
