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
import javax.validation.constraints.NotNull;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "proyecto_socio")
@NamedQueries({
    @NamedQuery(name = "ProyectoSocio.findAll", query = "SELECT p FROM ProyectoSocio p")})
public class ProyectoSocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto_persona", nullable = false)
    private Integer idProyectoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private char estado;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Socio idPersona;

    public ProyectoSocio() {
    }

    public ProyectoSocio(Integer idProyectoPersona) {
        this.idProyectoPersona = idProyectoPersona;
    }

    public ProyectoSocio(Integer idProyectoPersona, char estado) {
        this.idProyectoPersona = idProyectoPersona;
        this.estado = estado;
    }

    public Integer getIdProyectoPersona() {
        return idProyectoPersona;
    }

    public void setIdProyectoPersona(Integer idProyectoPersona) {
        this.idProyectoPersona = idProyectoPersona;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Socio getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Socio idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyectoPersona != null ? idProyectoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoSocio)) {
            return false;
        }
        ProyectoSocio other = (ProyectoSocio) object;
        if ((this.idProyectoPersona == null && other.idProyectoPersona != null) || (this.idProyectoPersona != null && !this.idProyectoPersona.equals(other.idProyectoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.ProyectoSocio[ idProyectoPersona=" + idProyectoPersona + " ]";
    }
    
}
