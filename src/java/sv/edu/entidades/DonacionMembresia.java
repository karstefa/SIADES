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
@Table(name = "donacion_membresia")
@NamedQueries({
    @NamedQuery(name = "DonacionMembresia.findAll", query = "SELECT d FROM DonacionMembresia d")})
public class DonacionMembresia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_donancion_membresia", nullable = false)
    private Integer idDonancionMembresia;
    @JoinColumn(name = "id_donacion", referencedColumnName = "id_donacion", nullable = false)
    @ManyToOne(optional = false)
    private Donacion idDonacion;
    @JoinColumn(name = "id_membresia", referencedColumnName = "id_membresia", nullable = false)
    @ManyToOne(optional = false)
    private Membresia idMembresia;

    public DonacionMembresia() {
    }

    public DonacionMembresia(Integer idDonancionMembresia) {
        this.idDonancionMembresia = idDonancionMembresia;
    }

    public Integer getIdDonancionMembresia() {
        return idDonancionMembresia;
    }

    public void setIdDonancionMembresia(Integer idDonancionMembresia) {
        this.idDonancionMembresia = idDonancionMembresia;
    }

    public Donacion getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Donacion idDonacion) {
        this.idDonacion = idDonacion;
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
        hash += (idDonancionMembresia != null ? idDonancionMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonacionMembresia)) {
            return false;
        }
        DonacionMembresia other = (DonacionMembresia) object;
        if ((this.idDonancionMembresia == null && other.idDonancionMembresia != null) || (this.idDonancionMembresia != null && !this.idDonancionMembresia.equals(other.idDonancionMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.DonacionMembresia[ idDonancionMembresia=" + idDonancionMembresia + " ]";
    }
    
}
