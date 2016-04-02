package sv.edu.entidades.acciones;

import sv.edu.entidades.ExistenciaProducto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "existenciaProductoController")
@ViewScoped
public class ExistenciaProductoController extends AbstractController<ExistenciaProducto> {

    @Inject
    private DonacionController idDonacionController;

    public ExistenciaProductoController() {
        // Inform the Abstract parent controller of the concrete ExistenciaProducto?cap_first Entity
        super(ExistenciaProducto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDonacionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Donacion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDonacion(ActionEvent event) {
        if (this.getSelected() != null && idDonacionController.getSelected() == null) {
            idDonacionController.setSelected(this.getSelected().getIdDonacion());
        }
    }
}
