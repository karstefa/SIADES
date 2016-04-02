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
@Table(name = "estado_empleado")
@NamedQueries({
    @NamedQuery(name = "EstadoEmpleado.findAll", query = "SELECT e FROM EstadoEmpleado e")})
public class EstadoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_empleado", nullable = false)
    private Integer idEstadoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoEmpleado")
    private List<Empleado> empleadoList;

    public EstadoEmpleado() {
    }

    public EstadoEmpleado(Integer idEstadoEmpleado) {
        this.idEstadoEmpleado = idEstadoEmpleado;
    }

    public EstadoEmpleado(Integer idEstadoEmpleado, String nombre) {
        this.idEstadoEmpleado = idEstadoEmpleado;
        this.nombre = nombre;
    }

    public Integer getIdEstadoEmpleado() {
        return idEstadoEmpleado;
    }

    public void setIdEstadoEmpleado(Integer idEstadoEmpleado) {
        this.idEstadoEmpleado = idEstadoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoEmpleado != null ? idEstadoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEmpleado)) {
            return false;
        }
        EstadoEmpleado other = (EstadoEmpleado) object;
        if ((this.idEstadoEmpleado == null && other.idEstadoEmpleado != null) || (this.idEstadoEmpleado != null && !this.idEstadoEmpleado.equals(other.idEstadoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.EstadoEmpleado[ idEstadoEmpleado=" + idEstadoEmpleado + " ]";
    }
    
}
