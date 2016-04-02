package sv.edu.entidades.acciones;

import sv.edu.entidades.EstadoSocio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "estadoSocioController")
@ViewScoped
public class EstadoSocioController extends AbstractController<EstadoSocio> {

    @Inject
    private SocioController socioListController;

    public EstadoSocioController() {
        // Inform the Abstract parent controller of the concrete EstadoSocio?cap_first Entity
        super(EstadoSocio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Socio entities that are
     * retrieved from EstadoSocio?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Socio page
     */
    public String navigateSocioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Socio_items", this.getSelected().getSocioList());
        }
        return "/socio/index";
    }

}
