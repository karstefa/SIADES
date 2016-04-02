/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "estado_socio")
@NamedQueries({
    @NamedQuery(name = "EstadoSocio.findAll", query = "SELECT e FROM EstadoSocio e")})
public class EstadoSocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_socio", nullable = false)
    private Integer idEstadoSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoSocio")
    private List<Socio> socioList;

    public EstadoSocio() {
    }

    public EstadoSocio(Integer idEstadoSocio) {
        this.idEstadoSocio = idEstadoSocio;
    }

    public EstadoSocio(Integer idEstadoSocio, String nombre) {
        this.idEstadoSocio = idEstadoSocio;
        this.nombre = nombre;
    }

    public Integer getIdEstadoSocio() {
        return idEstadoSocio;
    }

    public void setIdEstadoSocio(Integer idEstadoSocio) {
        this.idEstadoSocio = idEstadoSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Socio> getSocioList() {
        return socioList;
    }

    public void setSocioList(List<Socio> socioList) {
        this.socioList = socioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoSocio != null ? idEstadoSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoSocio)) {
            return false;
        }
        EstadoSocio other = (EstadoSocio) object;
        if ((this.idEstadoSocio == null && other.idEstadoSocio != null) || (this.idEstadoSocio != null && !this.idEstadoSocio.equals(other.idEstadoSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.EstadoSocio[ idEstadoSocio=" + idEstadoSocio + " ]";
    }
    
}
