package sv.edu.entidades.acciones;

import sv.edu.entidades.Membresia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "membresiaController")
@ViewScoped
public class MembresiaController extends AbstractController<Membresia> {

    @Inject
    private PagoMembresiaController pagoMembresiaListController;
    @Inject
    private SocioMembresiaController socioMembresiaListController;
    @Inject
    private DonacionMembresiaController donacionMembresiaListController;
    @Inject
    private TipoMembresiaController idTipoMembresiaController;

    public MembresiaController() {
        // Inform the Abstract parent controller of the concrete Membresia?cap_first Entity
        super(Membresia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoMembresiaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PagoMembresia entities
     * that are retrieved from Membresia?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of SocioMembresia entities
     * that are retrieved from Membresia?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SocioMembresia page
     */
    public String navigateSocioMembresiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SocioMembresia_items", this.getSelected().getSocioMembresiaList());
        }
        return "/socioMembresia/index";
    }

    /**
     * Sets the "items" attribute with a collection of DonacionMembresia
     * entities that are retrieved from Membresia?cap_first and returns the
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
     * Sets the "selected" attribute of the TipoMembresia controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoMembresia(ActionEvent event) {
        if (this.getSelected() != null && idTipoMembresiaController.getSelected() == null) {
            idTipoMembresiaController.setSelected(this.getSelected().getIdTipoMembresia());
        }
    }
}
