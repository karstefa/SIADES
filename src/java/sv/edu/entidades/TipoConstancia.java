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
@Table(name = "tipo_constancia")
@NamedQueries({
    @NamedQuery(name = "TipoConstancia.findAll", query = "SELECT t FROM TipoConstancia t")})
public class TipoConstancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_constancia", nullable = false)
    private Integer idTipoConstancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoConstancia")
    private List<Constancia> constanciaList;

    public TipoConstancia() {
    }

    public TipoConstancia(Integer idTipoConstancia) {
        this.idTipoConstancia = idTipoConstancia;
    }

    public TipoConstancia(Integer idTipoConstancia, String nombre) {
        this.idTipoConstancia = idTipoConstancia;
        this.nombre = nombre;
    }

    public Integer getIdTipoConstancia() {
        return idTipoConstancia;
    }

    public void setIdTipoConstancia(Integer idTipoConstancia) {
        this.idTipoConstancia = idTipoConstancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Constancia> getConstanciaList() {
        return constanciaList;
    }

    public void setConstanciaList(List<Constancia> constanciaList) {
        this.constanciaList = constanciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoConstancia != null ? idTipoConstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConstancia)) {
            return false;
        }
        TipoConstancia other = (TipoConstancia) object;
        if ((this.idTipoConstancia == null && other.idTipoConstancia != null) || (this.idTipoConstancia != null && !this.idTipoConstancia.equals(other.idTipoConstancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.TipoConstancia[ idTipoConstancia=" + idTipoConstancia + " ]";
    }
    
}
