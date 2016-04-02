package sv.edu.entidades.acciones;

import sv.edu.entidades.Empleado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "empleadoController")
@ViewScoped
public class EmpleadoController extends AbstractController<Empleado> {

    @Inject
    private DocumentoEmpleadoController documentoEmpleadoListController;
    @Inject
    private ContactoEmpleadoController contactoEmpleadoListController;
    @Inject
    private DireccionEmpleadoController direccionEmpleadoListController;
    @Inject
    private EstadoEmpleadoController idEstadoEmpleadoController;
    @Inject
    private CargoController idCargoController;
    @Inject
    private TipoEmpleadoController idTipoEmpleadoController;
    @Inject
    private UsuarioEmpleadoRolController usuarioEmpleadoRolListController;

    public EmpleadoController() {
        // Inform the Abstract parent controller of the concrete Empleado?cap_first Entity
        super(Empleado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEstadoEmpleadoController.setSelected(null);
        idCargoController.setSelected(null);
        idTipoEmpleadoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DocumentoEmpleado
     * entities that are retrieved from Empleado?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DocumentoEmpleado page
     */
    public String navigateDocumentoEmpleadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DocumentoEmpleado_items", this.getSelected().getDocumentoEmpleadoList());
        }
        return "/documentoEmpleado/index";
    }

    /**
     * Sets the "items" attribute with a collection of ContactoEmpleado entities
     * that are retrieved from Empleado?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ContactoEmpleado page
     */
    public String navigateContactoEmpleadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ContactoEmpleado_items", this.getSelected().getContactoEmpleadoList());
        }
        return "/contactoEmpleado/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionEmpleado
     * entities that are retrieved from Empleado?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DireccionEmpleado page
     */
    public String navigateDireccionEmpleadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionEmpleado_items", this.getSelected().getDireccionEmpleadoList());
        }
        return "/direccionEmpleado/index";
    }

    /**
     * Sets the "selected" attribute of the EstadoEmpleado controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEstadoEmpleado(ActionEvent event) {
        if (this.getSelected() != null && idEstadoEmpleadoController.getSelected() == null) {
            idEstadoEmpleadoController.setSelected(this.getSelected().getIdEstadoEmpleado());
        }
    }

    /**
     * Sets the "selected" attribute of the Cargo controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCargo(ActionEvent event) {
        if (this.getSelected() != null && idCargoController.getSelected() == null) {
            idCargoController.setSelected(this.getSelected().getIdCargo());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoEmpleado controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoEmpleado(ActionEvent event) {
        if (this.getSelected() != null && idTipoEmpleadoController.getSelected() == null) {
            idTipoEmpleadoController.setSelected(this.getSelected().getIdTipoEmpleado());
        }
    }

    /**
     * Sets the "items" attribute with a collection of UsuarioEmpleadoRol
     * entities that are retrieved from Empleado?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for UsuarioEmpleadoRol page
     */
    public String navigateUsuarioEmpleadoRolList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UsuarioEmpleadoRol_items", this.getSelected().getUsuarioEmpleadoRolList());
        }
        return "/usuarioEmpleadoRol/index";
    }

}
