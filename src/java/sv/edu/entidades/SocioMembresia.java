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

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "socio_membresia")
@NamedQueries({
    @NamedQuery(name = "SocioMembresia.findAll", query = "SELECT s FROM SocioMembresia s")})
public class SocioMembresia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_membresia", nullable = false)
    private Integer idTipoMembresia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia_pago_proximo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date diaPagoProximo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia_pago_anterior", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date diaPagoAnterior;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Socio idPersona;
    @JoinColumn(name = "id_membresia", referencedColumnName = "id_membresia", nullable = false)
    @ManyToOne(optional = false)
    private Membresia idMembresia;

    public SocioMembresia() {
    }

    public SocioMembresia(Integer idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public SocioMembresia(Integer idTipoMembresia, Date diaPagoProximo, Date diaPagoAnterior) {
        this.idTipoMembresia = idTipoMembresia;
        this.diaPagoProximo = diaPagoProximo;
        this.diaPagoAnterior = diaPagoAnterior;
    }

    public Integer getIdTipoMembresia() {
        return idTipoMembresia;
    }

    public void setIdTipoMembresia(Integer idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public Date getDiaPagoProximo() {
        return diaPagoProximo;
    }

    public void setDiaPagoProximo(Date diaPagoProximo) {
        this.diaPagoProximo = diaPagoProximo;
    }

    public Date getDiaPagoAnterior() {
        return diaPagoAnterior;
    }

    public void setDiaPagoAnterior(Date diaPagoAnterior) {
        this.diaPagoAnterior = diaPagoAnterior;
    }

    public Socio getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Socio idPersona) {
        this.idPersona = idPersona;
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
        hash += (idTipoMembresia != null ? idTipoMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocioMembresia)) {
            return false;
        }
        SocioMembresia other = (SocioMembresia) object;
        if ((this.idTipoMembresia == null && other.idTipoMembresia != null) || (this.idTipoMembresia != null && !this.idTipoMembresia.equals(other.idTipoMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.SocioMembresia[ idTipoMembresia=" + idTipoMembresia + " ]";
    }
    
}
