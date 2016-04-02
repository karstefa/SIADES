package sv.edu.entidades.acciones;

import sv.edu.entidades.DocumentoEmpleado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "documentoEmpleadoController")
@ViewScoped
public class DocumentoEmpleadoController extends AbstractController<DocumentoEmpleado> {

    @Inject
    private EmpleadoController idEmpleadoController;
    @Inject
    private DocumentoController idDocumentoController;

    public DocumentoEmpleadoController() {
        // Inform the Abstract parent controller of the concrete DocumentoEmpleado?cap_first Entity
        super(DocumentoEmpleado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEmpleadoController.setSelected(null);
        idDocumentoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Empleado controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmpleado(ActionEvent event) {
        if (this.getSelected() != null && idEmpleadoController.getSelected() == null) {
            idEmpleadoController.setSelected(this.getSelected().getIdEmpleado());
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
