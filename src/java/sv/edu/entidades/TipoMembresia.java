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
@Table(name = "tipo_membresia")
@NamedQueries({
    @NamedQuery(name = "TipoMembresia.findAll", query = "SELECT t FROM TipoMembresia t")})
public class TipoMembresia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_membresia", nullable = false)
    private Integer idTipoMembresia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMembresia")
    private List<Membresia> membresiaList;

    public TipoMembresia() {
    }

    public TipoMembresia(Integer idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public TipoMembresia(Integer idTipoMembresia, String nombre, String estado) {
        this.idTipoMembresia = idTipoMembresia;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoMembresia() {
        return idTipoMembresia;
    }

    public void setIdTipoMembresia(Integer idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Membresia> getMembresiaList() {
        return membresiaList;
    }

    public void setMembresiaList(List<Membresia> membresiaList) {
        this.membresiaList = membresiaList;
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
        if (!(object instanceof TipoMembresia)) {
            return false;
        }
        TipoMembresia other = (TipoMembresia) object;
        if ((this.idTipoMembresia == null && other.idTipoMembresia != null) || (this.idTipoMembresia != null && !this.idTipoMembresia.equals(other.idTipoMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.TipoMembresia[ idTipoMembresia=" + idTipoMembresia + " ]";
    }
    
}
