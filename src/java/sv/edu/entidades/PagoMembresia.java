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
@Table(name = "pago_membresia")
@NamedQueries({
    @NamedQuery(name = "PagoMembresia.findAll", query = "SELECT p FROM PagoMembresia p")})
public class PagoMembresia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago_membresia", nullable = false)
    private Integer idPagoMembresia;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago", nullable = false)
    @ManyToOne(optional = false)
    private Pago idPago;
    @JoinColumn(name = "id_membresia", referencedColumnName = "id_membresia", nullable = false)
    @ManyToOne(optional = false)
    private Membresia idMembresia;

    public PagoMembresia() {
    }

    public PagoMembresia(Integer idPagoMembresia) {
        this.idPagoMembresia = idPagoMembresia;
    }

    public Integer getIdPagoMembresia() {
        return idPagoMembresia;
    }

    public void setIdPagoMembresia(Integer idPagoMembresia) {
        this.idPagoMembresia = idPagoMembresia;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    public Membresia getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(Membresia idMembresia) {
        this.idMembresia = idMembresia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoMembresia != null ? idPagoMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoMembresia)) {
            return false;
        }
        PagoMembresia other = (PagoMembresia) object;
        if ((this.idPagoMembresia == null && other.idPagoMembresia != null) || (this.idPagoMembresia != null && !this.idPagoMembresia.equals(other.idPagoMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.PagoMembresia[ idPagoMembresia=" + idPagoMembresia + " ]";
    }
    
}
