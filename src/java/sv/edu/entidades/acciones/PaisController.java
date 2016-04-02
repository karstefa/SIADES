package sv.edu.entidades.acciones;

import sv.edu.entidades.Pais;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "paisController")
@ViewScoped
public class PaisController extends AbstractController<Pais> {

    @Inject
    private DepartamentoController departamentoListController;

    public PaisController() {
        // Inform the Abstract parent controller of the concrete Pais?cap_first Entity
        super(Pais.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Departamento entities
     * that are retrieved from Pais?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Departamento page
     */
    public String navigateDepartamentoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Departamento_items", this.getSelected().getDepartamentoList());
        }
        return "/departamento/index";
    }

}
