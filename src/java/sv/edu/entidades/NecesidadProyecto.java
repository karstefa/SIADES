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
@Table(name = "necesidad_proyecto")
@NamedQueries({
    @NamedQuery(name = "NecesidadProyecto.findAll", query = "SELECT n FROM NecesidadProyecto n")})
public class NecesidadProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_necesidad_proyecto", nullable = false)
    private Integer idNecesidadProyecto;
    @JoinColumn(name = "id_necesidad", referencedColumnName = "id_necesidad", nullable = false)
    @ManyToOne(optional = false)
    private Necesidad idNecesidad;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public NecesidadProyecto() {
    }

    public NecesidadProyecto(Integer idNecesidadProyecto) {
        this.idNecesidadProyecto = idNecesidadProyecto;
    }

    public Integer getIdNecesidadProyecto() {
        return idNecesidadProyecto;
    }

    public void setIdNecesidadProyecto(Integer idNecesidadProyecto) {
        this.idNecesidadProyecto = idNecesidadProyecto;
    }

    public Necesidad getIdNecesidad() {
        return idNecesidad;
    }

    public void setIdNecesidad(Necesidad idNecesidad) {
        this.idNecesidad = idNecesidad;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNecesidadProyecto != null ? idNecesidadProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NecesidadProyecto)) {
            return false;
        }
        NecesidadProyecto other = (NecesidadProyecto) object;
        if ((this.idNecesidadProyecto == null && other.idNecesidadProyecto != null) || (this.idNecesidadProyecto != null && !this.idNecesidadProyecto.equals(other.idNecesidadProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.NecesidadProyecto[ idNecesidadProyecto=" + idNecesidadProyecto + " ]";
    }
    
}
