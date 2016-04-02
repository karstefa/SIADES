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
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "direccion_empleado")
@NamedQueries({
    @NamedQuery(name = "DireccionEmpleado.findAll", query = "SELECT d FROM DireccionEmpleado d")})
public class DireccionEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion_empleado", nullable = false)
    private Integer idDireccionEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false)
    @ManyToOne(optional = false)
    private Direccion idDireccion;

    public DireccionEmpleado() {
    }

    public DireccionEmpleado(Integer idDireccionEmpleado) {
        this.idDireccionEmpleado = idDireccionEmpleado;
    }

    public DireccionEmpleado(Integer idDireccionEmpleado, String estado) {
        this.idDireccionEmpleado = idDireccionEmpleado;
        this.estado = estado;
    }

    public Integer getIdDireccionEmpleado() {
        return idDireccionEmpleado;
    }

    public void setIdDireccionEmpleado(Integer idDireccionEmpleado) {
        this.idDireccionEmpleado = idDireccionEmpleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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
        hash += (idDireccionEmpleado != null ? idDireccionEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionEmpleado)) {
            return false;
        }
        DireccionEmpleado other = (DireccionEmpleado) object;
        if ((this.idDireccionEmpleado == null && other.idDireccionEmpleado != null) || (this.idDireccionEmpleado != null && !this.idDireccionEmpleado.equals(other.idDireccionEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.DireccionEmpleado[ idDireccionEmpleado=" + idDireccionEmpleado + " ]";
    }
    
}
