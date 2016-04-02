package sv.edu.entidades.acciones;

import sv.edu.entidades.TipoMora;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoMoraController")
@ViewScoped
public class TipoMoraController extends AbstractController<TipoMora> {

    @Inject
    private MoraController moraListController;

    public TipoMoraController() {
        // Inform the Abstract parent controller of the concrete TipoMora?cap_first Entity
        super(TipoMora.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Mora entities that are
     * retrieved from TipoMora?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Mora page
     */
    public String navigateMoraList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Mora_items", this.getSelected().getMoraList());
        }
        return "/mora/index";
    }

}
