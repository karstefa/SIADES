package sv.edu.entidades.acciones;

import sv.edu.entidades.UsuarioSocioRol;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioSocioRolController")
@ViewScoped
public class UsuarioSocioRolController extends AbstractController<UsuarioSocioRol> {

    @Inject
    private SocioController idPersonaController;
    @Inject
    private RolController idRolController;

    public UsuarioSocioRolController() {
        // Inform the Abstract parent controller of the concrete UsuarioSocioRol?cap_first Entity
        super(UsuarioSocioRol.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPersonaController.setSelected(null);
        idRolController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Socio controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPersona(ActionEvent event) {
        if (this.getSelected() != null && idPersonaController.getSelected() == null) {
            idPersonaController.setSelected(this.getSelected().getIdPersona());
        }
    }

    /**
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRol(ActionEvent event) {
        if (this.getSelected() != null && idRolController.getSelected() == null) {
            idRolController.setSelected(this.getSelected().getIdRol());
        }
    }
}
