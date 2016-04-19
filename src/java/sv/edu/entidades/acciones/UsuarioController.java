/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.entidades.acciones;


import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.entidades.Empleado;
import sv.edu.entidades.Socio;
import sv.edu.entidades.acciones.util.JsfUtil;
import sv.edu.entidades.controladores.EmpleadoFacade;
import sv.edu.entidades.controladores.SocioFacade;

/**
 *
 * @author rgluis
 */
@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController implements Serializable{
    @Inject
    private SocioFacade socioFacade;
    @Inject
    private EmpleadoFacade empleadoFacade;
    
    private String usuario;
    private String contrasenia;
    private Object usuarioEnSesion;
    
    
    public String validarUsuario(){
        try{
            Socio s = socioFacade.obtenerPorUsuarioContrasenia(usuario, contrasenia);
            if(s!= null){
                usuarioEnSesion = s;
            }else{
                Empleado e = empleadoFacade.obtenerPorUsuarioContrasenia(usuario, contrasenia);
                if(e!=null){
                    usuarioEnSesion = e;
                }else{
                    JsfUtil.addErrorMessage("Usuario o contraseña invalidos");
                    return "inicioSesion";
                }
            }
            return "bienvenido";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Object getUsuarioEnSesion() {
        return usuarioEnSesion;
    }

    public void setUsuarioEnSesion(Object usuarioEnSesion) {
        this.usuarioEnSesion = usuarioEnSesion;
    }
    
    
    
}
