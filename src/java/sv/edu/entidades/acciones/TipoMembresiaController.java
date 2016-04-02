package sv.edu.entidades.acciones;

import sv.edu.entidades.TipoMembresia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoMembresiaController")
@ViewScoped
public class TipoMembresiaController extends AbstractController<TipoMembresia> {

    @Inject
    private MembresiaController membresiaListController;

    public TipoMembresiaController() {
        // Inform the Abstract parent controller of the concrete TipoMembresia?cap_first Entity
        super(TipoMembresia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Membresia entities that
     * are retrieved from TipoMembresia?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Membresia page
     */
    public String navigateMembresiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Membresia_items", this.getSelected().getMembresiaList());
        }
        return "/membresia/index";
    }

}
