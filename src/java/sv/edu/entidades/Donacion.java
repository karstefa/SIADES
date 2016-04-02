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
@Table(name = "donacion")
@NamedQueries({
    @NamedQuery(name = "Donacion.findAll", query = "SELECT d FROM Donacion d")})
public class Donacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_donacion", nullable = false)
    private Integer idDonacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDonacion")
    private List<ExistenciaProducto> existenciaProductoList;
    @JoinColumn(name = "id_tipo_donacion", referencedColumnName = "id_tipo_donacion", nullable = false)
    @ManyToOne(optional = false)
    private TipoDonacion idTipoDonacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDonacion")
    private List<OrdenDetalle> ordenDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDonacion")
    private List<DonacionMembresia> donacionMembresiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDonacion")
    private List<ProductoDonante> productoDonanteList;

    public Donacion() {
    }

    public Donacion(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Donacion(Integer idDonacion, String nombre) {
        this.idDonacion = idDonacion;
        this.nombre = nombre;
    }

    public Integer getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ExistenciaProducto> getExistenciaProductoList() {
        return existenciaProductoList;
    }

    public void setExistenciaProductoList(List<ExistenciaProducto> existenciaProductoList) {
        this.existenciaProductoList = existenciaProductoList;
    }

    public TipoDonacion getIdTipoDonacion() {
        return idTipoDonacion;
    }

    public void setIdTipoDonacion(TipoDonacion idTipoDonacion) {
        this.idTipoDonacion = idTipoDonacion;
    }

    public List<OrdenDetalle> getOrdenDetalleList() {
        return ordenDetalleList;
    }

    public void setOrdenDetalleList(List<OrdenDetalle> ordenDetalleList) {
        this.ordenDetalleList = ordenDetalleList;
    }

    public List<DonacionMembresia> getDonacionMembresiaList() {
        return donacionMembresiaList;
    }

    public void setDonacionMembresiaList(List<DonacionMembresia> donacionMembresiaList) {
        this.donacionMembresiaList = donacionMembresiaList;
    }

    public List<ProductoDonante> getProductoDonanteList() {
        return productoDonanteList;
    }

    public void setProductoDonanteList(List<ProductoDonante> productoDonanteList) {
        this.productoDonanteList = productoDonanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDonacion != null ? idDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donacion)) {
            return false;
        }
        Donacion other = (Donacion) object;
        if ((this.idDonacion == null && other.idDonacion != null) || (this.idDonacion != null && !this.idDonacion.equals(other.idDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Donacion[ idDonacion=" + idDonacion + " ]";
    }
    
}
