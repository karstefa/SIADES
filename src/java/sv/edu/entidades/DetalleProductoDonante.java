/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "detalle_producto_donante")
@NamedQueries({
    @NamedQuery(name = "DetalleProductoDonante.findAll", query = "SELECT d FROM DetalleProductoDonante d")})
public class DetalleProductoDonante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_producto_donante", nullable = false)
    private Integer idDetalleProductoDonante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_inventario", nullable = false, length = 1)
    private String estadoInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_expiracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaExpiracion;
    @JoinColumn(name = "id_detalle_producto", referencedColumnName = "id_detalle_producto", nullable = false)
    @ManyToOne(optional = false)
    private ProductoDonante idDetalleProducto;

    public DetalleProductoDonante() {
    }

    public DetalleProductoDonante(Integer idDetalleProductoDonante) {
        this.idDetalleProductoDonante = idDetalleProductoDonante;
    }

    public DetalleProductoDonante(Integer idDetalleProductoDonante, String estadoInventario, Date fechaExpiracion) {
        this.idDetalleProductoDonante = idDetalleProductoDonante;
        this.estadoInventario = estadoInventario;
        this.fechaExpiracion = fechaExpiracion;
    }

    public Integer getIdDetalleProductoDonante() {
        return idDetalleProductoDonante;
    }

    public void setIdDetalleProductoDonante(Integer idDetalleProductoDonante) {
        this.idDetalleProductoDonante = idDetalleProductoDonante;
    }

    public String getEstadoInventario() {
        return estadoInventario;
    }

    public void setEstadoInventario(String estadoInventario) {
        this.estadoInventario = estadoInventario;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public ProductoDonante getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(ProductoDonante idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleProductoDonante != null ? idDetalleProductoDonante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProductoDonante)) {
            return false;
        }
        DetalleProductoDonante other = (DetalleProductoDonante) object;
        if ((this.idDetalleProductoDonante == null && other.idDetalleProductoDonante != null) || (this.idDetalleProductoDonante != null && !this.idDetalleProductoDonante.equals(other.idDetalleProductoDonante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.DetalleProductoDonante[ idDetalleProductoDonante=" + idDetalleProductoDonante + " ]";
    }
    
}
