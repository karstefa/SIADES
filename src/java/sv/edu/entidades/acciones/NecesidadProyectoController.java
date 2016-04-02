package sv.edu.entidades.acciones;

import sv.edu.entidades.NecesidadProyecto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "necesidadProyectoController")
@ViewScoped
public class NecesidadProyectoController extends AbstractController<NecesidadProyecto> {

    @Inject
    private NecesidadController idNecesidadController;
    @Inject
    private ProyectoController idProyectoController;

    public NecesidadProyectoController() {
        // Inform the Abstract parent controller of the concrete NecesidadProyecto?cap_first Entity
        super(NecesidadProyecto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idNecesidadController.setSelected(null);
        idProyectoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Necesidad controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdNecesidad(ActionEvent event) {
        if (this.getSelected() != null && idNecesidadController.getSelected() == null) {
            idNecesidadController.setSelected(this.getSelected().getIdNecesidad());
        }
    }

    /**
     * Sets the "selected" attribute of the Proyecto controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdProyecto(ActionEvent event) {
        if (this.getSelected() != null && idProyectoController.getSelected() == null) {
            idProyectoController.setSelected(this.getSelected().getIdProyecto());
        }
    }
}
