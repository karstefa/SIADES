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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso", nullable = false)
    @ManyToOne(optional = false)
    private Permiso idPermiso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<UsuarioSocioRol> usuarioSocioRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<UsuarioEmpleadoRol> usuarioEmpleadoRolList;

    public Rol() {
    }

    public Rol(Integer idRol) {
        this.idRol = idRol;
    }

    public Rol(Integer idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Permiso getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Permiso idPermiso) {
        this.idPermiso = idPermiso;
    }

    public List<UsuarioSocioRol> getUsuarioSocioRolList() {
        return usuarioSocioRolList;
    }

    public void setUsuarioSocioRolList(List<UsuarioSocioRol> usuarioSocioRolList) {
        this.usuarioSocioRolList = usuarioSocioRolList;
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
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Rol[ idRol=" + idRol + " ]";
    }
    
}
