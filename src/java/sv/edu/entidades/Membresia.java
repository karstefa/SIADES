/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "membresia")
@NamedQueries({
    @NamedQuery(name = "Membresia.findAll", query = "SELECT m FROM Membresia m")})
public class Membresia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_membresia", nullable = false)
    private Integer idMembresia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto", nullable = false)
    private double monto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "terminos_condiciones", nullable = false, length = 2147483647)
    private String terminosCondiciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMembresia")
    private List<PagoMembresia> pagoMembresiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMembresia")
    private List<SocioMembresia> socioMembresiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMembresia")
    private List<DonacionMembresia> donacionMembresiaList;
    @JoinColumn(name = "id_tipo_membresia", referencedColumnName = "id_tipo_membresia", nullable = false)
    @ManyToOne(optional = false)
    private TipoMembresia idTipoMembresia;

    public Membresia() {
    }

    public Membresia(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Membresia(Integer idMembresia, String nombre, Date fechaInicio, Date fechaFin, double monto, String terminosCondiciones) {
        this.idMembresia = idMembresia;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.terminosCondiciones = terminosCondiciones;
    }

    public Integer getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTerminosCondiciones() {
        return terminosCondiciones;
    }

    public void setTerminosCondiciones(String terminosCondiciones) {
        this.terminosCondiciones = terminosCondiciones;
    }

    public List<PagoMembresia> getPagoMembresiaList() {
        return pagoMembresiaList;
    }

    public void setPagoMembresiaList(List<PagoMembresia> pagoMembresiaList) {
        this.pagoMembresiaList = pagoMembresiaList;
    }

    public List<SocioMembresia> getSocioMembresiaList() {
        return socioMembresiaList;
    }

    public void setSocioMembresiaList(List<SocioMembresia> socioMembresiaList) {
        this.socioMembresiaList = socioMembresiaList;
    }

    public List<DonacionMembresia> getDonacionMembresiaList() {
        return donacionMembresiaList;
    }

    public void setDonacionMembresiaList(List<DonacionMembresia> donacionMembresiaList) {
        this.donacionMembresiaList = donacionMembresiaList;
    }

    public TipoMembresia getIdTipoMembresia() {
        return idTipoMembresia;
    }

    public void setIdTipoMembresia(TipoMembresia idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembresia != null ? idMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membresia)) {
            return false;
        }
        Membresia other = (Membresia) object;
        if ((this.idMembresia == null && other.idMembresia != null) || (this.idMembresia != null && !this.idMembresia.equals(other.idMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Membresia[ idMembresia=" + idMembresia + " ]";
    }
    
}
