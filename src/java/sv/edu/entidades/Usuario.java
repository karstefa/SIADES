/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.entidades;

/**
 *
 * @author rgluis
 */
public class Usuario<T> {
    private String usuario;
    private String nombre;
    private String apellidos;
    private Class tipoUsuario;
    private T objeto;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Class getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Class tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
    
    
}
