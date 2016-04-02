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
@Table(name = "tipo_donacion")
@NamedQueries({
    @NamedQuery(name = "TipoDonacion.findAll", query = "SELECT t FROM TipoDonacion t")})
public class TipoDonacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_donacion", nullable = false)
    private Integer idTipoDonacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "descripcion", nullable = false, length = 400)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDonacion")
    private List<Donacion> donacionList;

    public TipoDonacion() {
    }

    public TipoDonacion(Integer idTipoDonacion) {
        this.idTipoDonacion = idTipoDonacion;
    }

    public TipoDonacion(Integer idTipoDonacion, String nombre, String descripcion) {
        this.idTipoDonacion = idTipoDonacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoDonacion() {
        return idTipoDonacion;
    }

    public void setIdTipoDonacion(Integer idTipoDonacion) {
        this.idTipoDonacion = idTipoDonacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Donacion> getDonacionList() {
        return donacionList;
    }

    public void setDonacionList(List<Donacion> donacionList) {
        this.donacionList = donacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDonacion != null ? idTipoDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDonacion)) {
            return false;
        }
        TipoDonacion other = (TipoDonacion) object;
        if ((this.idTipoDonacion == null && other.idTipoDonacion != null) || (this.idTipoDonacion != null && !this.idTipoDonacion.equals(other.idTipoDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.TipoDonacion[ idTipoDonacion=" + idTipoDonacion + " ]";
    }
    
}
