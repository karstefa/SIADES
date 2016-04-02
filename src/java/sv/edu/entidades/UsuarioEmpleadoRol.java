/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.entidades;

import java.io.Serializable;
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

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "usuario_empleado_rol")
@NamedQueries({
    @NamedQuery(name = "UsuarioEmpleadoRol.findAll", query = "SELECT u FROM UsuarioEmpleadoRol u")})
public class UsuarioEmpleadoRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<AutorizacionUsuarioEmpleado> autorizacionUsuarioEmpleadoList;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @ManyToOne(optional = false)
    private Rol idRol;

    public UsuarioEmpleadoRol() {
    }

    public UsuarioEmpleadoRol(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<AutorizacionUsuarioEmpleado> getAutorizacionUsuarioEmpleadoList() {
        return autorizacionUsuarioEmpleadoList;
    }

    public void setAutorizacionUsuarioEmpleadoList(List<AutorizacionUsuarioEmpleado> autorizacionUsuarioEmpleadoList) {
        this.autorizacionUsuarioEmpleadoList = autorizacionUsuarioEmpleadoList;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEmpleadoRol)) {
            return false;
        }
        UsuarioEmpleadoRol other = (UsuarioEmpleadoRol) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.UsuarioEmpleadoRol[ idUsuario=" + idUsuario + " ]";
    }
    
}
