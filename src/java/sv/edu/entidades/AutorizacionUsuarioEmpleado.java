/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "autorizacion_usuario_empleado")
@NamedQueries({
    @NamedQuery(name = "AutorizacionUsuarioEmpleado.findAll", query = "SELECT a FROM AutorizacionUsuarioEmpleado a")})
public class AutorizacionUsuarioEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autorizacion_usuario_empleado", nullable = false)
    private Integer idAutorizacionUsuarioEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado", nullable = false, length = 2)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "sqlEjecutar", nullable = false, length = 4000)
    private String sqlEjecutar;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioEmpleadoRol idUsuario;

    public AutorizacionUsuarioEmpleado() {
    }

    public AutorizacionUsuarioEmpleado(Integer idAutorizacionUsuarioEmpleado) {
        this.idAutorizacionUsuarioEmpleado = idAutorizacionUsuarioEmpleado;
    }

    public AutorizacionUsuarioEmpleado(Integer idAutorizacionUsuarioEmpleado, String estado, String sqlEjecutar) {
        this.idAutorizacionUsuarioEmpleado = idAutorizacionUsuarioEmpleado;
        this.estado = estado;
        this.sqlEjecutar = sqlEjecutar;
    }

    public Integer getIdAutorizacionUsuarioEmpleado() {
        return idAutorizacionUsuarioEmpleado;
    }

    public void setIdAutorizacionUsuarioEmpleado(Integer idAutorizacionUsuarioEmpleado) {
        this.idAutorizacionUsuarioEmpleado = idAutorizacionUsuarioEmpleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSqlEjecutar() {
        return sqlEjecutar;
    }

    public void setSqlEjecutar(String sqlEjecutar) {
        this.sqlEjecutar = sqlEjecutar;
    }

    public UsuarioEmpleadoRol getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioEmpleadoRol idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutorizacionUsuarioEmpleado != null ? idAutorizacionUsuarioEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorizacionUsuarioEmpleado)) {
            return false;
        }
        AutorizacionUsuarioEmpleado other = (AutorizacionUsuarioEmpleado) object;
        if ((this.idAutorizacionUsuarioEmpleado == null && other.idAutorizacionUsuarioEmpleado != null) || (this.idAutorizacionUsuarioEmpleado != null && !this.idAutorizacionUsuarioEmpleado.equals(other.idAutorizacionUsuarioEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.AutorizacionUsuarioEmpleado[ idAutorizacionUsuarioEmpleado=" + idAutorizacionUsuarioEmpleado + " ]";
    }
    
}
