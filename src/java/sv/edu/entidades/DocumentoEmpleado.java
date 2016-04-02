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
@Table(name = "documento_empleado")
@NamedQueries({
    @NamedQuery(name = "DocumentoEmpleado.findAll", query = "SELECT d FROM DocumentoEmpleado d")})
public class DocumentoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento_empleado", nullable = false)
    private Integer idDocumentoEmpleado;
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
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento", nullable = false)
    @ManyToOne(optional = false)
    private Documento idDocumento;

    public DocumentoEmpleado() {
    }

    public DocumentoEmpleado(Integer idDocumentoEmpleado) {
        this.idDocumentoEmpleado = idDocumentoEmpleado;
    }

    public DocumentoEmpleado(Integer idDocumentoEmpleado, String estado, String valor) {
        this.idDocumentoEmpleado = idDocumentoEmpleado;
        this.estado = estado;
        this.valor = valor;
    }

    public Integer getIdDocumentoEmpleado() {
        return idDocumentoEmpleado;
    }

    public void setIdDocumentoEmpleado(Integer idDocumentoEmpleado) {
        this.idDocumentoEmpleado = idDocumentoEmpleado;
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

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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
        hash += (idDocumentoEmpleado != null ? idDocumentoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoEmpleado)) {
            return false;
        }
        DocumentoEmpleado other = (DocumentoEmpleado) object;
        if ((this.idDocumentoEmpleado == null && other.idDocumentoEmpleado != null) || (this.idDocumentoEmpleado != null && !this.idDocumentoEmpleado.equals(other.idDocumentoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.DocumentoEmpleado[ idDocumentoEmpleado=" + idDocumentoEmpleado + " ]";
    }
    
}
