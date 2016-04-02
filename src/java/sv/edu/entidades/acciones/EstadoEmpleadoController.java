package sv.edu.entidades.acciones;

import sv.edu.entidades.EstadoEmpleado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "estadoEmpleadoController")
@ViewScoped
public class EstadoEmpleadoController extends AbstractController<EstadoEmpleado> {

    @Inject
    private EmpleadoController empleadoListController;

    public EstadoEmpleadoController() {
        // Inform the Abstract parent controller of the concrete EstadoEmpleado?cap_first Entity
        super(EstadoEmpleado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Empleado entities that
     * are retrieved from EstadoEmpleado?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Empleado page
     */
    public String navigateEmpleadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empleado_items", this.getSelected().getEmpleadoList());
        }
        return "/empleado/index";
    }

}
