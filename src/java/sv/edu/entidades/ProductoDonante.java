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

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "producto_donante")
@NamedQueries({
    @NamedQuery(name = "ProductoDonante.findAll", query = "SELECT p FROM ProductoDonante p")})
public class ProductoDonante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_producto", nullable = false)
    private Integer idDetalleProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private long cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor", nullable = false)
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_horas", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date tiempoHoras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serie_inicial", nullable = false)
    private long serieInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serie_final", nullable = false)
    private long serieFinal;
    @JoinColumn(name = "id_donante", referencedColumnName = "id_donante", nullable = false)
    @ManyToOne(optional = false)
    private Donante idDonante;
    @JoinColumn(name = "id_donacion", referencedColumnName = "id_donacion", nullable = false)
    @ManyToOne(optional = false)
    private Donacion idDonacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetalleProducto")
    private List<DetalleProductoDonante> detalleProductoDonanteList;

    public ProductoDonante() {
    }

    public ProductoDonante(Integer idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public ProductoDonante(Integer idDetalleProducto, long cantidad, long valor, Date tiempoHoras, Date fecha, long serieInicial, long serieFinal) {
        this.idDetalleProducto = idDetalleProducto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.tiempoHoras = tiempoHoras;
        this.fecha = fecha;
        this.serieInicial = serieInicial;
        this.serieFinal = serieFinal;
    }

    public Integer getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(Integer idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Date getTiempoHoras() {
        return tiempoHoras;
    }

    public void setTiempoHoras(Date tiempoHoras) {
        this.tiempoHoras = tiempoHoras;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getSerieInicial() {
        return serieInicial;
    }

    public void setSerieInicial(long serieInicial) {
        this.serieInicial = serieInicial;
    }

    public long getSerieFinal() {
        return serieFinal;
    }

    public void setSerieFinal(long serieFinal) {
        this.serieFinal = serieFinal;
    }

    public Donante getIdDonante() {
        return idDonante;
    }

    public void setIdDonante(Donante idDonante) {
        this.idDonante = idDonante;
    }

    public Donacion getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Donacion idDonacion) {
        this.idDonacion = idDonacion;
    }

    public List<DetalleProductoDonante> getDetalleProductoDonanteList() {
        return detalleProductoDonanteList;
    }

    public void setDetalleProductoDonanteList(List<DetalleProductoDonante> detalleProductoDonanteList) {
        this.detalleProductoDonanteList = detalleProductoDonanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleProducto != null ? idDetalleProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoDonante)) {
            return false;
        }
        ProductoDonante other = (ProductoDonante) object;
        if ((this.idDetalleProducto == null && other.idDetalleProducto != null) || (this.idDetalleProducto != null && !this.idDetalleProducto.equals(other.idDetalleProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.ProductoDonante[ idDetalleProducto=" + idDetalleProducto + " ]";
    }
    
}
