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
@Table(name = "pago")
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago", nullable = false)
    private Integer idPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmacion_pago", nullable = false)
    private int confirmacionPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pago_final", nullable = false)
    private double pagoFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_tipo_pago", nullable = false)
    @ManyToOne(optional = false)
    private TipoPago idTipoPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPago")
    private List<PagoMembresia> pagoMembresiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPago")
    private List<MoraPago> moraPagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPago")
    private List<Constancia> constanciaList;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Pago(Integer idPago, int confirmacionPago, double pagoFinal, Date fechaPago) {
        this.idPago = idPago;
        this.confirmacionPago = confirmacionPago;
        this.pagoFinal = pagoFinal;
        this.fechaPago = fechaPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public int getConfirmacionPago() {
        return confirmacionPago;
    }

    public void setConfirmacionPago(int confirmacionPago) {
        this.confirmacionPago = confirmacionPago;
    }

    public double getPagoFinal() {
        return pagoFinal;
    }

    public void setPagoFinal(double pagoFinal) {
        this.pagoFinal = pagoFinal;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public TipoPago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TipoPago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public List<PagoMembresia> getPagoMembresiaList() {
        return pagoMembresiaList;
    }

    public void setPagoMembresiaList(List<PagoMembresia> pagoMembresiaList) {
        this.pagoMembresiaList = pagoMembresiaList;
    }

    public List<MoraPago> getMoraPagoList() {
        return moraPagoList;
    }

    public void setMoraPagoList(List<MoraPago> moraPagoList) {
        this.moraPagoList = moraPagoList;
    }

    public List<Constancia> getConstanciaList() {
        return constanciaList;
    }

    public void setConstanciaList(List<Constancia> constanciaList) {
        this.constanciaList = constanciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Pago[ idPago=" + idPago + " ]";
    }
    
}
