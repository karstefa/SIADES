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
@Table(name = "usuario_socio_rol")
@NamedQueries({
    @NamedQuery(name = "UsuarioSocioRol.findAll", query = "SELECT u FROM UsuarioSocioRol u")})
public class UsuarioSocioRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_socio_rol", nullable = false)
    private Integer idUsuarioSocioRol;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Socio idPersona;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @ManyToOne(optional = false)
    private Rol idRol;

    public UsuarioSocioRol() {
    }

    public UsuarioSocioRol(Integer idUsuarioSocioRol) {
        this.idUsuarioSocioRol = idUsuarioSocioRol;
    }

    public Integer getIdUsuarioSocioRol() {
        return idUsuarioSocioRol;
    }

    public void setIdUsuarioSocioRol(Integer idUsuarioSocioRol) {
        this.idUsuarioSocioRol = idUsuarioSocioRol;
    }

    public Socio getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Socio idPersona) {
        this.idPersona = idPersona;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioSocioRol != null ? idUsuarioSocioRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioSocioRol)) {
            return false;
        }
        UsuarioSocioRol other = (UsuarioSocioRol) object;
        if ((this.idUsuarioSocioRol == null && other.idUsuarioSocioRol != null) || (this.idUsuarioSocioRol != null && !this.idUsuarioSocioRol.equals(other.idUsuarioSocioRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.UsuarioSocioRol[ idUsuarioSocioRol=" + idUsuarioSocioRol + " ]";
    }
    
}
