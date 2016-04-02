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
@Table(name = "direccion_persona")
@NamedQueries({
    @NamedQuery(name = "DireccionPersona.findAll", query = "SELECT d FROM DireccionPersona d")})
public class DireccionPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion_persona", nullable = false)
    private Integer idDireccionPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private char estado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Socio idPersona;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false)
    @ManyToOne(optional = false)
    private Direccion idDireccion;

    public DireccionPersona() {
    }

    public DireccionPersona(Integer idDireccionPersona) {
        this.idDireccionPersona = idDireccionPersona;
    }

    public DireccionPersona(Integer idDireccionPersona, char estado) {
        this.idDireccionPersona = idDireccionPersona;
        this.estado = estado;
    }

    public Integer getIdDireccionPersona() {
        return idDireccionPersona;
    }

    public void setIdDireccionPersona(Integer idDireccionPersona) {
        this.idDireccionPersona = idDireccionPersona;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Socio getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Socio idPersona) {
        this.idPersona = idPersona;
    }

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionPersona != null ? idDireccionPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionPersona)) {
            return false;
        }
        DireccionPersona other = (DireccionPersona) object;
        if ((this.idDireccionPersona == null && other.idDireccionPersona != null) || (this.idDireccionPersona != null && !this.idDireccionPersona.equals(other.idDireccionPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.DireccionPersona[ idDireccionPersona=" + idDireccionPersona + " ]";
    }
    
}
