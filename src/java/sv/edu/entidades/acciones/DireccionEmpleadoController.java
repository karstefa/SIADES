package sv.edu.entidades.acciones;

import sv.edu.entidades.DireccionEmpleado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "direccionEmpleadoController")
@ViewScoped
public class DireccionEmpleadoController extends AbstractController<DireccionEmpleado> {

    @Inject
    private EmpleadoController idEmpleadoController;
    @Inject
    private DireccionController idDireccionController;

    public DireccionEmpleadoController() {
        // Inform the Abstract parent controller of the concrete DireccionEmpleado?cap_first Entity
        super(DireccionEmpleado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEmpleadoController.setSelected(null);
        idDireccionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Empleado controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmpleado(ActionEvent event) {
        if (this.getSelected() != null && idEmpleadoController.getSelected() == null) {
            idEmpleadoController.setSelected(this.getSelected().getIdEmpleado());
        }
    }

    /**
     * Sets the "selected" attribute of the Direccion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDireccion(ActionEvent event) {
        if (this.getSelected() != null && idDireccionController.getSelected() == null) {
            idDireccionController.setSelected(this.getSelected().getIdDireccion());
        }
    }
}
