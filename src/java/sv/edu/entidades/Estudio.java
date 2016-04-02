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
@Table(name = "estudio")
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e")})
public class Estudio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudio", nullable = false)
    private Integer idEstudio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estudio_realizados", nullable = false, length = 50)
    private String estudioRealizados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date anioInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_finalizado", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date anioFinalizado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Socio idPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudio")
    private List<Titulo> tituloList;

    public Estudio() {
    }

    public Estudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public Estudio(Integer idEstudio, String estudioRealizados, Date anioInicio, Date anioFinalizado) {
        this.idEstudio = idEstudio;
        this.estudioRealizados = estudioRealizados;
        this.anioInicio = anioInicio;
        this.anioFinalizado = anioFinalizado;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public String getEstudioRealizados() {
        return estudioRealizados;
    }

    public void setEstudioRealizados(String estudioRealizados) {
        this.estudioRealizados = estudioRealizados;
    }

    public Date getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Date anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Date getAnioFinalizado() {
        return anioFinalizado;
    }

    public void setAnioFinalizado(Date anioFinalizado) {
        this.anioFinalizado = anioFinalizado;
    }

    public Socio getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Socio idPersona) {
        this.idPersona = idPersona;
    }

    public List<Titulo> getTituloList() {
        return tituloList;
    }

    public void setTituloList(List<Titulo> tituloList) {
        this.tituloList = tituloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudio != null ? idEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.idEstudio == null && other.idEstudio != null) || (this.idEstudio != null && !this.idEstudio.equals(other.idEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Estudio[ idEstudio=" + idEstudio + " ]";
    }
    
}
