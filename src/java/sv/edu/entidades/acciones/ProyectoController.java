package sv.edu.entidades.acciones;

import sv.edu.entidades.Proyecto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "proyectoController")
@ViewScoped
public class ProyectoController extends AbstractController<Proyecto> {

    @Inject
    private NecesidadProyectoController necesidadProyectoListController;
    @Inject
    private TipoProyectoController idTipoProyectoController;
    @Inject
    private OrdenController ordenListController;
    @Inject
    private ProyectoSocioController proyectoSocioListController;

    public ProyectoController() {
        // Inform the Abstract parent controller of the concrete Proyecto?cap_first Entity
        super(Proyecto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoProyectoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of NecesidadProyecto
     * entities that are retrieved from Proyecto?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NecesidadProyecto page
     */
    public String navigateNecesidadProyectoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NecesidadProyecto_items", this.getSelected().getNecesidadProyectoList());
        }
        return "/necesidadProyecto/index";
    }

    /**
     * Sets the "selected" attribute of the TipoProyecto controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoProyecto(ActionEvent event) {
        if (this.getSelected() != null && idTipoProyectoController.getSelected() == null) {
            idTipoProyectoController.setSelected(this.getSelected().getIdTipoProyecto());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Orden entities that are
     * retrieved from Proyecto?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Orden page
     */
    public String navigateOrdenList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Orden_items", this.getSelected().getOrdenList());
        }
        return "/orden/index";
    }

    /**
     * Sets the "items" attribute with a collection of ProyectoSocio entities
     * that are retrieved from Proyecto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ProyectoSocio page
     */
    public String navigateProyectoSocioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ProyectoSocio_items", this.getSelected().getProyectoSocioList());
        }
        return "/proyectoSocio/index";
    }

}
