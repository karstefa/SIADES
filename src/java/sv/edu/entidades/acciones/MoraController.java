package sv.edu.entidades.acciones;

import sv.edu.entidades.Mora;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "moraController")
@ViewScoped
public class MoraController extends AbstractController<Mora> {

    @Inject
    private TipoMoraController idTipoMoraController;
    @Inject
    private MoraPagoController moraPagoListController;

    public MoraController() {
        // Inform the Abstract parent controller of the concrete Mora?cap_first Entity
        super(Mora.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoMoraController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoMora controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoMora(ActionEvent event) {
        if (this.getSelected() != null && idTipoMoraController.getSelected() == null) {
            idTipoMoraController.setSelected(this.getSelected().getIdTipoMora());
        }
    }

    /**
     * Sets the "items" attribute with a collection of MoraPago entities that
     * are retrieved from Mora?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for MoraPago page
     */
    public String navigateMoraPagoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MoraPago_items", this.getSelected().getMoraPagoList());
        }
        return "/moraPago/index";
    }

}
