package sv.edu.entidades.acciones;

import sv.edu.entidades.Necesidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "necesidadController")
@ViewScoped
public class NecesidadController extends AbstractController<Necesidad> {

    @Inject
    private NecesidadProyectoController necesidadProyectoListController;

    public NecesidadController() {
        // Inform the Abstract parent controller of the concrete Necesidad?cap_first Entity
        super(Necesidad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of NecesidadProyecto
     * entities that are retrieved from Necesidad?cap_first and returns the
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

}
