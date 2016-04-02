package sv.edu.entidades.acciones;

import sv.edu.entidades.Documento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "documentoController")
@ViewScoped
public class DocumentoController extends AbstractController<Documento> {

    @Inject
    private DocumentoEmpleadoController documentoEmpleadoListController;
    @Inject
    private DocumentoSocioController documentoSocioListController;

    public DocumentoController() {
        // Inform the Abstract parent controller of the concrete Documento?cap_first Entity
        super(Documento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of DocumentoEmpleado
     * entities that are retrieved from Documento?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DocumentoEmpleado page
     */
    public String navigateDocumentoEmpleadoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DocumentoEmpleado_items", this.getSelected().getDocumentoEmpleadoList());
        }
        return "/documentoEmpleado/index";
    }

    /**
     * Sets the "items" attribute with a collection of DocumentoSocio entities
     * that are retrieved from Documento?cap_first and returns the navigation
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

}
