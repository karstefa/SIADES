/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.entidades.acciones;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rgluis
 */
@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController {
    @Inject
    private SocioController socioController;
    @Inject
    private EmpleadoController empleadoController;
    
    
}
