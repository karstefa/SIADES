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
@Table(name = "documento_socio")
@NamedQueries({
    @NamedQuery(name = "DocumentoSocio.findAll", query = "SELECT d FROM DocumentoSocio d")})
public class DocumentoSocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento_socio", nullable = false)
    private Integer idDocumentoSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "valor", nullable = false, length = 50)
    private String valor;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Socio idPersona;
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento", nullable = false)
    @ManyToOne(optional = false)
    private Documento idDocumento;

    public DocumentoSocio() {
    }

    public DocumentoSocio(Integer idDocumentoSocio) {
        this.idDocumentoSocio = idDocumentoSocio;
    }

    public DocumentoSocio(Integer idDocumentoSocio, String estado, String valor) {
        this.idDocumentoSocio = idDocumentoSocio;
        this.estado = estado;
        this.valor = valor;
    }

    public Integer getIdDocumentoSocio() {
        return idDocumentoSocio;
    }

    public void setIdDocumentoSocio(Integer idDocumentoSocio) {
        this.idDocumentoSocio = idDocumentoSocio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Socio getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Socio idPersona) {
        this.idPersona = idPersona;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoSocio != null ? idDocumentoSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoSocio)) {
            return false;
        }
        DocumentoSocio other = (DocumentoSocio) object;
        if ((this.idDocumentoSocio == null && other.idDocumentoSocio != null) || (this.idDocumentoSocio != null && !this.idDocumentoSocio.equals(other.idDocumentoSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.DocumentoSocio[ idDocumentoSocio=" + idDocumentoSocio + " ]";
    }
    
}
