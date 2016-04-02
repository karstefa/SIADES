package sv.edu.entidades.acciones;

import sv.edu.entidades.Socio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "socioController")
@ViewScoped
public class SocioController extends AbstractController<Socio> {

    @Inject
    private TipoSocioController idTipoSocioController;
    @Inject
    private EstadoSocioController idEstadoSocioController;
    @Inject
    private SocioMembresiaController socioMembresiaListController;
    @Inject
    private DocumentoSocioController documentoSocioListController;
    @Inject
    private EstudioController estudioListController;
    @Inject
    private DireccionPersonaController direccionPersonaListController;
    @Inject
    private UsuarioSocioRolController usuarioSocioRolListController;
    @Inject
    private ProyectoSocioController proyectoSocioListController;
    @Inject
    private ContactoPersonaController contactoPersonaListController;

    public SocioController() {
        // Inform the Abstract parent controller of the concrete Socio?cap_first Entity
        super(Socio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoSocioController.setSelected(null);
        idEstadoSocioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoSocio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoSocio(ActionEvent event) {
        if (this.getSelected() != null && idTipoSocioController.getSelected() == null) {
            idTipoSocioController.setSelected(this.getSelected().getIdTipoSocio());
        }
    }

    /**
     * Sets the "selected" attribute of the EstadoSocio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEstadoSocio(ActionEvent event) {
        if (this.getSelected() != null && idEstadoSocioController.getSelected() == null) {
            idEstadoSocioController.setSelected(this.getSelected().getIdEstadoSocio());
        }
    }

    /**
     * Sets the "items" attribute with a collection of SocioMembresia entities
     * that are retrieved from Socio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SocioMembresia page
     */
    public String navigateSocioMembresiaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SocioMembresia_items", this.getSelected().getSocioMembresiaList());
        }
        return "/socioMembresia/index";
    }

    /**
     * Sets the "items" attribute with a collection of DocumentoSocio entities
     * that are retrieved from Socio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DocumentoSocio page
     */
    public String navigateDocumentoSocioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DocumentoSocio_items", this.getSelected().getDocumentoSocioList());
        }
        return "/documentoSocio/index";
    }

    /**
     * Sets the "items" attribute with a collection of Estudio entities that are
     * retrieved from Socio?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Estudio page
     */
    public String navigateEstudioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Estudio_items", this.getSelected().getEstudioList());
        }
        return "/estudio/index";
    }

    /**
     * Sets the "items" attribute with a collection of DireccionPersona entities
     * that are retrieved from Socio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DireccionPersona page
     */
    public String navigateDireccionPersonaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DireccionPersona_items", this.getSelected().getDireccionPersonaList());
        }
        return "/direccionPersona/index";
    }

    /**
     * Sets the "items" attribute with a collection of UsuarioSocioRol entities
     * that are retrieved from Socio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for UsuarioSocioRol page
     */
    public String navigateUsuarioSocioRolList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UsuarioSocioRol_items", this.getSelected().getUsuarioSocioRolList());
        }
        return "/usuarioSocioRol/index";
    }

    /**
     * Sets the "items" attribute with a collection of ProyectoSocio entities
     * that are retrieved from Socio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ProyectoSocio page
     */
    public String navigateProyectoSocioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ProyectoSocio_items", this.getSelected().getProyectoSocioList());
        }
        return "/proyectoSocio/index";
    }

    /**
     * Sets the "items" attribute with a collection of ContactoPersona entities
     * that are retrieved from Socio?cap_first and returns the navigation
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
