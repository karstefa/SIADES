package sv.edu.entidades.acciones;

import sv.edu.entidades.DonacionMembresia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "donacionMembresiaController")
@ViewScoped
public class DonacionMembresiaController extends AbstractController<DonacionMembresia> {

    @Inject
    private DonacionController idDonacionController;
    @Inject
    private MembresiaController idMembresiaController;

    public DonacionMembresiaController() {
        // Inform the Abstract parent controller of the concrete DonacionMembresia?cap_first Entity
        super(DonacionMembresia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDonacionController.setSelected(null);
        idMembresiaController.setSelected(null);
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
