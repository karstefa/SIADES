package sv.edu.entidades.acciones;

import sv.edu.entidades.Cargo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cargoController")
@ViewScoped
public class CargoController extends AbstractController<Cargo> {

    @Inject
    private CargoController cargoListController;
    @Inject
    private CargoController parentidcargoController;
    @Inject
    private EmpleadoController empleadoListController;

    public CargoController() {
        // Inform the Abstract parent controller of the concrete Cargo?cap_first Entity
        super(Cargo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        parentidcargoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Cargo entities that are
     * retrieved from Cargo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cargo page
     */
    public String navigateCargoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cargo_items", this.getSelected().getCargoList());
        }
        return "/cargo/index";
    }

    /**
     * Sets the "selected" attribute of the Cargo controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareParentidcargo(ActionEvent event) {
        if (this.getSelected() != null && parentidcargoController.getSelected() == null) {
            parentidcargoController.setSelected(this.getSelected().getParentidcargo());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Empleado entities that
     * are retrieved from Cargo?cap_first and returns the navigation outcome.
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
