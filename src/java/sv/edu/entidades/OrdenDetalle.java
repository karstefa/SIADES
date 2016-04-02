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
@Table(name = "orden_detalle")
@NamedQueries({
    @NamedQuery(name = "OrdenDetalle.findAll", query = "SELECT o FROM OrdenDetalle o")})
public class OrdenDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_detalle", nullable = false)
    private Integer idOrdenDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ubicacion", nullable = false, length = 150)
    private String ubicacion;
    @JoinColumn(name = "id_donacion", referencedColumnName = "id_donacion", nullable = false)
    @ManyToOne(optional = false)
    private Donacion idDonacion;
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden", nullable = false)
    @ManyToOne(optional = false)
    private Orden idOrden;

    public OrdenDetalle() {
    }

    public OrdenDetalle(Integer idOrdenDetalle) {
        this.idOrdenDetalle = idOrdenDetalle;
    }

    public OrdenDetalle(Integer idOrdenDetalle, int cantidad, String ubicacion) {
        this.idOrdenDetalle = idOrdenDetalle;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }

    public Integer getIdOrdenDetalle() {
        return idOrdenDetalle;
    }

    public void setIdOrdenDetalle(Integer idOrdenDetalle) {
        this.idOrdenDetalle = idOrdenDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Donacion getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Donacion idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Orden idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenDetalle != null ? idOrdenDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDetalle)) {
            return false;
        }
        OrdenDetalle other = (OrdenDetalle) object;
        if ((this.idOrdenDetalle == null && other.idOrdenDetalle != null) || (this.idOrdenDetalle != null && !this.idOrdenDetalle.equals(other.idOrdenDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.OrdenDetalle[ idOrdenDetalle=" + idOrdenDetalle + " ]";
    }
    
}
