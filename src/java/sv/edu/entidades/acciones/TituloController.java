package sv.edu.entidades.acciones;

import sv.edu.entidades.Titulo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tituloController")
@ViewScoped
public class TituloController extends AbstractController<Titulo> {

    @Inject
    private EstudioController idEstudioController;

    public TituloController() {
        // Inform the Abstract parent controller of the concrete Titulo?cap_first Entity
        super(Titulo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEstudioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Estudio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEstudio(ActionEvent event) {
        if (this.getSelected() != null && idEstudioController.getSelected() == null) {
            idEstudioController.setSelected(this.getSelected().getIdEstudio());
        }
    }
}
