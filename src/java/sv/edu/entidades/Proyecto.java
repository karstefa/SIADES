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
@Table(name = "proyecto")
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private char estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "archivo", nullable = false, length = 50)
    private String archivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona", nullable = false)
    private int idPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<NecesidadProyecto> necesidadProyectoList;
    @JoinColumn(name = "id_tipo_proyecto", referencedColumnName = "id_tipo_proyecto", nullable = false)
    @ManyToOne(optional = false)
    private TipoProyecto idTipoProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<Orden> ordenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<ProyectoSocio> proyectoSocioList;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String descripcion, char estado, Date fecha, String archivo, int idPersona) {
        this.idProyecto = idProyecto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.archivo = archivo;
        this.idPersona = idPersona;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public List<NecesidadProyecto> getNecesidadProyectoList() {
        return necesidadProyectoList;
    }

    public void setNecesidadProyectoList(List<NecesidadProyecto> necesidadProyectoList) {
        this.necesidadProyectoList = necesidadProyectoList;
    }

    public TipoProyecto getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(TipoProyecto idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    public List<ProyectoSocio> getProyectoSocioList() {
        return proyectoSocioList;
    }

    public void setProyectoSocioList(List<ProyectoSocio> proyectoSocioList) {
        this.proyectoSocioList = proyectoSocioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}
