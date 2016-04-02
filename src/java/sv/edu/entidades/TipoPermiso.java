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
@Table(name = "tipo_permiso")
@NamedQueries({
    @NamedQuery(name = "TipoPermiso.findAll", query = "SELECT t FROM TipoPermiso t")})
public class TipoPermiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_permiso", nullable = false)
    private Integer idTipoPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPermiso")
    private List<Permiso> permisoList;

    public TipoPermiso() {
    }

    public TipoPermiso(Integer idTipoPermiso) {
        this.idTipoPermiso = idTipoPermiso;
    }

    public TipoPermiso(Integer idTipoPermiso, String nombre) {
        this.idTipoPermiso = idTipoPermiso;
        this.nombre = nombre;
    }

    public Integer getIdTipoPermiso() {
        return idTipoPermiso;
    }

    public void setIdTipoPermiso(Integer idTipoPermiso) {
        this.idTipoPermiso = idTipoPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPermiso != null ? idTipoPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPermiso)) {
            return false;
        }
        TipoPermiso other = (TipoPermiso) object;
        if ((this.idTipoPermiso == null && other.idTipoPermiso != null) || (this.idTipoPermiso != null && !this.idTipoPermiso.equals(other.idTipoPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.TipoPermiso[ idTipoPermiso=" + idTipoPermiso + " ]";
    }
    
}
