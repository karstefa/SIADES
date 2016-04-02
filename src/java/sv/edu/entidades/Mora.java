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
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "mora")
@NamedQueries({
    @NamedQuery(name = "Mora.findAll", query = "SELECT m FROM Mora m")})
public class Mora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mora", nullable = false)
    private Integer idMora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto", nullable = false)
    private double monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_maxima", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaMaxima;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
    @JoinColumn(name = "id_tipo_mora", referencedColumnName = "id_tipo_mora", nullable = false)
    @ManyToOne(optional = false)
    private TipoMora idTipoMora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMora")
    private List<MoraPago> moraPagoList;

    public Mora() {
    }

    public Mora(Integer idMora) {
        this.idMora = idMora;
    }

    public Mora(Integer idMora, double monto, Date fechaMaxima, String estado) {
        this.idMora = idMora;
        this.monto = monto;
        this.fechaMaxima = fechaMaxima;
        this.estado = estado;
    }

    public Integer getIdMora() {
        return idMora;
    }

    public void setIdMora(Integer idMora) {
        this.idMora = idMora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaMaxima() {
        return fechaMaxima;
    }

    public void setFechaMaxima(Date fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoMora getIdTipoMora() {
        return idTipoMora;
    }

    public void setIdTipoMora(TipoMora idTipoMora) {
        this.idTipoMora = idTipoMora;
    }

    public List<MoraPago> getMoraPagoList() {
        return moraPagoList;
    }

    public void setMoraPagoList(List<MoraPago> moraPagoList) {
        this.moraPagoList = moraPagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMora != null ? idMora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mora)) {
            return false;
        }
        Mora other = (Mora) object;
        if ((this.idMora == null && other.idMora != null) || (this.idMora != null && !this.idMora.equals(other.idMora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Mora[ idMora=" + idMora + " ]";
    }
    
}
