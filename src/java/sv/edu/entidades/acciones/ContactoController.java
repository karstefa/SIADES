package sv.edu.entidades.acciones;

import sv.edu.entidades.Contacto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "contactoController")
@ViewScoped
public class ContactoController extends AbstractController<Contacto> {

    @Inject
    private ContactoEmpleadoController contactoEmpleadoListController;
    @Inject
    private ContactoPersonaController contactoPersonaListController;

    public ContactoController() {
        // Inform the Abstract parent controller of the concrete Contacto?cap_first Entity
        super(Contacto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of ContactoEmpleado entities
     * that are retrieved from Contacto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ContactoEmpleado page
     */
    public String navigateContactoEmpleadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ContactoEmpleado_items", this.getSelected().getContactoEmpleadoList());
        }
        return "/contactoEmpleado/index";
    }

    /**
     * Sets the "items" attribute with a collection of ContactoPersona entities
     * that are retrieved from Contacto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ContactoPersona page
     */
    public String navigateContactoPersonaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ContactoPersona_items", this.getSelected().getContactoPersonaList());
        }
        return "/contactoPersona/index";
    }

}
