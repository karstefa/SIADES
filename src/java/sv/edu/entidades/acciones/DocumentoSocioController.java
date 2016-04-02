package sv.edu.entidades.acciones;

import sv.edu.entidades.DocumentoSocio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "documentoSocioController")
@ViewScoped
public class DocumentoSocioController extends AbstractController<DocumentoSocio> {

    @Inject
    private SocioController idPersonaController;
    @Inject
    private DocumentoController idDocumentoController;

    public DocumentoSocioController() {
        // Inform the Abstract parent controller of the concrete DocumentoSocio?cap_first Entity
        super(DocumentoSocio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idPersonaController.setSelected(null);
        idDocumentoController.setSelected(null);
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
     * Sets the "selected" attribute of the Documento controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDocumento(ActionEvent event) {
        if (this.getSelected() != null && idDocumentoController.getSelected() == null) {
            idDocumentoController.setSelected(this.getSelected().getIdDocumento());
        }
    }
}
