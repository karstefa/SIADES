/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasenia", nullable = false, length = 50)
    private String contrasenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero", nullable = false)
    private int genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<DocumentoEmpleado> documentoEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<ContactoEmpleado> contactoEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<DireccionEmpleado> direccionEmpleadoList;
    @JoinColumn(name = "id_estado_empleado", referencedColumnName = "id_estado_empleado", nullable = false)
    @ManyToOne(optional = false)
    private EstadoEmpleado idEstadoEmpleado;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo", nullable = false)
    @ManyToOne(optional = false)
    private Cargo idCargo;
    @JoinColumn(name = "id_tipo_empleado", referencedColumnName = "id_tipo_empleado", nullable = false)
    @ManyToOne(optional = false)
    private TipoEmpleado idTipoEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<UsuarioEmpleadoRol> usuarioEmpleadoRolList;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String usuario, String contrasenia, String nombre, String apellido, int genero, Date fechaNacimiento) {
        this.idEmpleado = idEmpleado;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<DocumentoEmpleado> getDocumentoEmpleadoList() {
        return documentoEmpleadoList;
    }

    public void setDocumentoEmpleadoList(List<DocumentoEmpleado> documentoEmpleadoList) {
        this.documentoEmpleadoList = documentoEmpleadoList;
    }

    public List<ContactoEmpleado> getContactoEmpleadoList() {
        return contactoEmpleadoList;
    }

    public void setContactoEmpleadoList(List<ContactoEmpleado> contactoEmpleadoList) {
        this.contactoEmpleadoList = contactoEmpleadoList;
    }

    public List<DireccionEmpleado> getDireccionEmpleadoList() {
        return direccionEmpleadoList;
    }

    public void setDireccionEmpleadoList(List<DireccionEmpleado> direccionEmpleadoList) {
        this.direccionEmpleadoList = direccionEmpleadoList;
    }

    public EstadoEmpleado getIdEstadoEmpleado() {
        return idEstadoEmpleado;
    }

    public void setIdEstadoEmpleado(EstadoEmpleado idEstadoEmpleado) {
        this.idEstadoEmpleado = idEstadoEmpleado;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public TipoEmpleado getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(TipoEmpleado idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public List<UsuarioEmpleadoRol> getUsuarioEmpleadoRolList() {
        return usuarioEmpleadoRolList;
    }

    public void setUsuarioEmpleadoRolList(List<UsuarioEmpleadoRol> usuarioEmpleadoRolList) {
        this.usuarioEmpleadoRolList = usuarioEmpleadoRolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
