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
@Table(name = "socio")
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s")})
public class Socio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona", nullable = false)
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasenia", nullable = false, length = 50)
    private String contrasenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero", nullable = false)
    private int genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @JoinColumn(name = "id_tipo_socio", referencedColumnName = "id_tipo_socio", nullable = false)
    @ManyToOne(optional = false)
    private TipoSocio idTipoSocio;
    @JoinColumn(name = "id_estado_socio", referencedColumnName = "id_estado_socio", nullable = false)
    @ManyToOne(optional = false)
    private EstadoSocio idEstadoSocio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<SocioMembresia> socioMembresiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<DocumentoSocio> documentoSocioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Estudio> estudioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<DireccionPersona> direccionPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<UsuarioSocioRol> usuarioSocioRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<ProyectoSocio> proyectoSocioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<ContactoPersona> contactoPersonaList;

    public Socio() {
    }

    public Socio(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Socio(Integer idPersona, String contrasenia, String usuario, String nombre, String apellido, int genero, Date fechaNacimiento) {
        this.idPersona = idPersona;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoSocio getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(TipoSocio idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public EstadoSocio getIdEstadoSocio() {
        return idEstadoSocio;
    }

    public void setIdEstadoSocio(EstadoSocio idEstadoSocio) {
        this.idEstadoSocio = idEstadoSocio;
    }

    public List<SocioMembresia> getSocioMembresiaList() {
        return socioMembresiaList;
    }

    public void setSocioMembresiaList(List<SocioMembresia> socioMembresiaList) {
        this.socioMembresiaList = socioMembresiaList;
    }

    public List<DocumentoSocio> getDocumentoSocioList() {
        return documentoSocioList;
    }

    public void setDocumentoSocioList(List<DocumentoSocio> documentoSocioList) {
        this.documentoSocioList = documentoSocioList;
    }

    public List<Estudio> getEstudioList() {
        return estudioList;
    }

    public void setEstudioList(List<Estudio> estudioList) {
        this.estudioList = estudioList;
    }

    public List<DireccionPersona> getDireccionPersonaList() {
        return direccionPersonaList;
    }

    public void setDireccionPersonaList(List<DireccionPersona> direccionPersonaList) {
        this.direccionPersonaList = direccionPersonaList;
    }

    public List<UsuarioSocioRol> getUsuarioSocioRolList() {
        return usuarioSocioRolList;
    }

    public void setUsuarioSocioRolList(List<UsuarioSocioRol> usuarioSocioRolList) {
        this.usuarioSocioRolList = usuarioSocioRolList;
    }

    public List<ProyectoSocio> getProyectoSocioList() {
        return proyectoSocioList;
    }

    public void setProyectoSocioList(List<ProyectoSocio> proyectoSocioList) {
        this.proyectoSocioList = proyectoSocioList;
    }

    public List<ContactoPersona> getContactoPersonaList() {
        return contactoPersonaList;
    }

    public void setContactoPersonaList(List<ContactoPersona> contactoPersonaList) {
        this.contactoPersonaList = contactoPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.Socio[ idPersona=" + idPersona + " ]";
    }
    
}
