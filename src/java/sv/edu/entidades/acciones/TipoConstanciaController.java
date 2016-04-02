package sv.edu.entidades.acciones;

import sv.edu.entidades.TipoConstancia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoConstanciaController")
@ViewScoped
public class TipoConstanciaController extends AbstractController<TipoConstancia> {

    @Inject
    private ConstanciaController constanciaListController;

    public TipoConstanciaController() {
        // Inform the Abstract parent controller of the concrete TipoConstancia?cap_first Entity
        super(TipoConstancia.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Constancia entities that
     * are retrieved from TipoConstancia?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Constancia page
     */
    public String navigateConstanciaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Constancia_items", this.getSelected().getConstanciaList());
        }
        return "/constancia/index";
    }

}
