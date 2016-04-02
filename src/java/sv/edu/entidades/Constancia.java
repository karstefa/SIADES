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
@Table(name = "constancia")
@NamedQueries({
    @NamedQuery(name = "Constancia.findAll", query = "SELECT c FROM Constancia c")})
public class Constancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_constancia", nullable = false)
    private Integer idConstancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private double cantidad;
    @JoinColumn(name = "id_tipo_constancia", referencedColumnName = "id_tipo_constancia", nullable = false)
    @ManyToOne(optional = false)
    private TipoConstancia idTipoConstancia;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago", nullable = false)
    @ManyToOne(optional = false)
    private Pago idPago;

    public Constancia() {
    }

    public Constancia(Integer idConstancia) {
        this.idConstancia = idConstancia;
    }

    public Constancia(Integer idConstancia, Date fechaEmision, String descripcion, double cantidad) {
        this.idConstancia = idConstancia;
        this.fechaEmision = fechaEmision;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Integer getIdConstancia() {
        return idConstancia;
    }

    public void setIdConstancia(Integer idConstancia) {
        this.idConstancia = idConstancia;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public TipoConstancia getIdTipoConstancia() {
        return idTipoConstancia;
    }

    public void setIdTipoConstancia(TipoConstancia idTipoConstancia) {
        this.idTipoConstancia = idTipoConstancia;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConstancia != null ? idConstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constancia)) {
            return false;
        }
        Constancia other = (Constancia) object;
        if ((this.idConstancia == null && other.idConstancia != null) || (this.idConstancia != null && !this.idConstancia.equals(other.idConstancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Constancia[ idConstancia=" + idConstancia + " ]";
    }
    
}
