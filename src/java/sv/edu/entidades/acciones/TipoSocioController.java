package sv.edu.entidades.acciones;

import sv.edu.entidades.TipoSocio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoSocioController")
@ViewScoped
public class TipoSocioController extends AbstractController<TipoSocio> {

    @Inject
    private SocioController socioListController;

    public TipoSocioController() {
        // Inform the Abstract parent controller of the concrete TipoSocio?cap_first Entity
        super(TipoSocio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Socio entities that are
     * retrieved from TipoSocio?cap_first and returns the navigation outcome.
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
