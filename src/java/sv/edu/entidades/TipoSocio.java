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
@Table(name = "tipo_socio")
@NamedQueries({
    @NamedQuery(name = "TipoSocio.findAll", query = "SELECT t FROM TipoSocio t")})
public class TipoSocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_socio", nullable = false)
    private Integer idTipoSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoSocio")
    private List<Socio> socioList;

    public TipoSocio() {
    }

    public TipoSocio(Integer idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public TipoSocio(Integer idTipoSocio, String nombre) {
        this.idTipoSocio = idTipoSocio;
        this.nombre = nombre;
    }

    public Integer getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(Integer idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
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
        hash += (idTipoSocio != null ? idTipoSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSocio)) {
            return false;
        }
        TipoSocio other = (TipoSocio) object;
        if ((this.idTipoSocio == null && other.idTipoSocio != null) || (this.idTipoSocio != null && !this.idTipoSocio.equals(other.idTipoSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.TipoSocio[ idTipoSocio=" + idTipoSocio + " ]";
    }
    
}
