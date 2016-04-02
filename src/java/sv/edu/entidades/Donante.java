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
@Table(name = "donante")
@NamedQueries({
    @NamedQuery(name = "Donante.findAll", query = "SELECT d FROM Donante d")})
public class Donante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_donante", nullable = false)
    private Integer idDonante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDonante")
    private List<ProductoDonante> productoDonanteList;

    public Donante() {
    }

    public Donante(Integer idDonante) {
        this.idDonante = idDonante;
    }

    public Donante(Integer idDonante, String nombre) {
        this.idDonante = idDonante;
        this.nombre = nombre;
    }

    public Integer getIdDonante() {
        return idDonante;
    }

    public void setIdDonante(Integer idDonante) {
        this.idDonante = idDonante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ProductoDonante> getProductoDonanteList() {
        return productoDonanteList;
    }

    public void setProductoDonanteList(List<ProductoDonante> productoDonanteList) {
        this.productoDonanteList = productoDonanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDonante != null ? idDonante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donante)) {
            return false;
        }
        Donante other = (Donante) object;
        if ((this.idDonante == null && other.idDonante != null) || (this.idDonante != null && !this.idDonante.equals(other.idDonante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Donante[ idDonante=" + idDonante + " ]";
    }
    
}
