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

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "existencia_producto")
@NamedQueries({
    @NamedQuery(name = "ExistenciaProducto.findAll", query = "SELECT e FROM ExistenciaProducto e")})
public class ExistenciaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_existencia_donacion", nullable = false)
    private Integer idExistenciaDonacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @JoinColumn(name = "id_donacion", referencedColumnName = "id_donacion", nullable = false)
    @ManyToOne(optional = false)
    private Donacion idDonacion;

    public ExistenciaProducto() {
    }

    public ExistenciaProducto(Integer idExistenciaDonacion) {
        this.idExistenciaDonacion = idExistenciaDonacion;
    }

    public ExistenciaProducto(Integer idExistenciaDonacion, int cantidad) {
        this.idExistenciaDonacion = idExistenciaDonacion;
        this.cantidad = cantidad;
    }

    public Integer getIdExistenciaDonacion() {
        return idExistenciaDonacion;
    }

    public void setIdExistenciaDonacion(Integer idExistenciaDonacion) {
        this.idExistenciaDonacion = idExistenciaDonacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Donacion getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Donacion idDonacion) {
        this.idDonacion = idDonacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExistenciaDonacion != null ? idExistenciaDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExistenciaProducto)) {
            return false;
        }
        ExistenciaProducto other = (ExistenciaProducto) object;
        if ((this.idExistenciaDonacion == null && other.idExistenciaDonacion != null) || (this.idExistenciaDonacion != null && !this.idExistenciaDonacion.equals(other.idExistenciaDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.ExistenciaProducto[ idExistenciaDonacion=" + idExistenciaDonacion + " ]";
    }
    
}
