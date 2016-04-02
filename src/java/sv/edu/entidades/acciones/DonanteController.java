package sv.edu.entidades.acciones;

import sv.edu.entidades.Donante;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "donanteController")
@ViewScoped
public class DonanteController extends AbstractController<Donante> {

    @Inject
    private ProductoDonanteController productoDonanteListController;

    public DonanteController() {
        // Inform the Abstract parent controller of the concrete Donante?cap_first Entity
        super(Donante.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of ProductoDonante entities
     * that are retrieved from Donante?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ProductoDonante page
     */
    public String navigateProductoDonanteList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ProductoDonante_items", this.getSelected().getProductoDonanteList());
        }
        return "/productoDonante/index";
    }

}
