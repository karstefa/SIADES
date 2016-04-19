/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.entidades.acciones;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import sv.edu.entidades.Empleado;
import sv.edu.entidades.Socio;
import sv.edu.entidades.Usuario;
import sv.edu.entidades.acciones.util.JsfUtil;
import sv.edu.entidades.controladores.EmpleadoFacade;
import sv.edu.entidades.controladores.SocioFacade;

/**
 *
 * @author rgluis
 */
@ManagedBean(name="usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{
    @Inject
    private SocioFacade socioFacade;
    @Inject
    private EmpleadoFacade empleadoFacade;
    
    private String usuario;
    private String contrasenia;
    private Usuario usuarioEnSesion;
    
    
    public String validarUsuario(){
        
        try{
            Socio s = socioFacade.obtenerPorUsuarioContrasenia(usuario, contrasenia);
            if(s!= null){
                Usuario<Socio> u = new Usuario();
                u = new Usuario<>();
                u.setUsuario(s.getUsuario());
                u.setApellidos(s.getApellido());
                u.setNombre(s.getNombre());
                u.setTipoUsuario(s.getClass());
                u.setObjeto(s);
                usuarioEnSesion = u;
                
            }else{
                Empleado e = empleadoFacade.obtenerPorUsuarioContrasenia(usuario, contrasenia);
                if(e!=null){
                    Usuario<Empleado> u = new Usuario();
                    u = new Usuario<>();
                    u.setUsuario(e.getUsuario());
                    u.setApellidos(e.getApellido());
                    u.setNombre(e.getNombre());
                    u.setTipoUsuario(e.getClass());
                    u.setObjeto(e);
                    usuarioEnSesion = u;
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
    
    
    public void validarSesion(){
     

       if(isSesionInvalida()){
               redireccionarPagina("inicioSesion",".ufg");
        }

    }

    public void redireccionarPagina(String nombrePagina, String urlPatron) {
        try {
            System.out.println("Redireccionando a pagina de inicio");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath =
             ((ServletContext) context.getContext()).getContextPath();
            String redirect= "";
                redirect=ctxPath+"/"+nombrePagina+urlPatron;
            context.redirect(redirect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public boolean isSesionInvalida(){
        return usuarioEnSesion==null || usuarioEnSesion.getUsuario()==null;
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

    public Usuario getUsuarioEnSesion() {
        return usuarioEnSesion;
    }

    public void setUsuarioEnSesion(Usuario usuarioEnSesion) {
        this.usuarioEnSesion = usuarioEnSesion;
    }



    
    
    
}
