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
@Table(name = "necesidad")
@NamedQueries({
    @NamedQuery(name = "Necesidad.findAll", query = "SELECT n FROM Necesidad n")})
public class Necesidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_necesidad", nullable = false)
    private Integer idNecesidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre", nullable = false, length = 75)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNecesidad")
    private List<NecesidadProyecto> necesidadProyectoList;

    public Necesidad() {
    }

    public Necesidad(Integer idNecesidad) {
        this.idNecesidad = idNecesidad;
    }

    public Necesidad(Integer idNecesidad, String nombre, String descripcion) {
        this.idNecesidad = idNecesidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdNecesidad() {
        return idNecesidad;
    }

    public void setIdNecesidad(Integer idNecesidad) {
        this.idNecesidad = idNecesidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<NecesidadProyecto> getNecesidadProyectoList() {
        return necesidadProyectoList;
    }

    public void setNecesidadProyectoList(List<NecesidadProyecto> necesidadProyectoList) {
        this.necesidadProyectoList = necesidadProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNecesidad != null ? idNecesidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Necesidad)) {
            return false;
        }
        Necesidad other = (Necesidad) object;
        if ((this.idNecesidad == null && other.idNecesidad != null) || (this.idNecesidad != null && !this.idNecesidad.equals(other.idNecesidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Necesidad[ idNecesidad=" + idNecesidad + " ]";
    }
    
}
