package sv.edu.entidades.acciones;

import sv.edu.entidades.TipoDonacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoDonacionController")
@ViewScoped
public class TipoDonacionController extends AbstractController<TipoDonacion> {

    @Inject
    private DonacionController donacionListController;

    public TipoDonacionController() {
        // Inform the Abstract parent controller of the concrete TipoDonacion?cap_first Entity
        super(TipoDonacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Donacion entities that
     * are retrieved from TipoDonacion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Donacion page
     */
    public String navigateDonacionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Donacion_items", this.getSelected().getDonacionList());
        }
        return "/donacion/index";
    }

}
