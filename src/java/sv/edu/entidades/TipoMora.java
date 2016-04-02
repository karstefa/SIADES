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
@Table(name = "tipo_mora")
@NamedQueries({
    @NamedQuery(name = "TipoMora.findAll", query = "SELECT t FROM TipoMora t")})
public class TipoMora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_mora", nullable = false)
    private Integer idTipoMora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMora")
    private List<Mora> moraList;

    public TipoMora() {
    }

    public TipoMora(Integer idTipoMora) {
        this.idTipoMora = idTipoMora;
    }

    public TipoMora(Integer idTipoMora, String nombre) {
        this.idTipoMora = idTipoMora;
        this.nombre = nombre;
    }

    public Integer getIdTipoMora() {
        return idTipoMora;
    }

    public void setIdTipoMora(Integer idTipoMora) {
        this.idTipoMora = idTipoMora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mora> getMoraList() {
        return moraList;
    }

    public void setMoraList(List<Mora> moraList) {
        this.moraList = moraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMora != null ? idTipoMora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMora)) {
            return false;
        }
        TipoMora other = (TipoMora) object;
        if ((this.idTipoMora == null && other.idTipoMora != null) || (this.idTipoMora != null && !this.idTipoMora.equals(other.idTipoMora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.TipoMora[ idTipoMora=" + idTipoMora + " ]";
    }
    
}
