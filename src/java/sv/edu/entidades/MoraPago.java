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

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "mora_pago")
@NamedQueries({
    @NamedQuery(name = "MoraPago.findAll", query = "SELECT m FROM MoraPago m")})
public class MoraPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mora_pago", nullable = false)
    private Integer idMoraPago;
    @JoinColumn(name = "id_mora", referencedColumnName = "id_mora", nullable = false)
    @ManyToOne(optional = false)
    private Mora idMora;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago", nullable = false)
    @ManyToOne(optional = false)
    private Pago idPago;

    public MoraPago() {
    }

    public MoraPago(Integer idMoraPago) {
        this.idMoraPago = idMoraPago;
    }

    public Integer getIdMoraPago() {
        return idMoraPago;
    }

    public void setIdMoraPago(Integer idMoraPago) {
        this.idMoraPago = idMoraPago;
    }

    public Mora getIdMora() {
        return idMora;
    }

    public void setIdMora(Mora idMora) {
        this.idMora = idMora;
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
        hash += (idMoraPago != null ? idMoraPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoraPago)) {
            return false;
        }
        MoraPago other = (MoraPago) object;
        if ((this.idMoraPago == null && other.idMoraPago != null) || (this.idMoraPago != null && !this.idMoraPago.equals(other.idMoraPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.MoraPago[ idMoraPago=" + idMoraPago + " ]";
    }
    
}
