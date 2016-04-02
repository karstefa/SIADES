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
@Table(name = "contacto_persona")
@NamedQueries({
    @NamedQuery(name = "ContactoPersona.findAll", query = "SELECT c FROM ContactoPersona c")})
public class ContactoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacto_persona", nullable = false)
    private Integer idContactoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valor", nullable = false, length = 100)
    private String valor;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Socio idPersona;
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto", nullable = false)
    @ManyToOne(optional = false)
    private Contacto idContacto;

    public ContactoPersona() {
    }

    public ContactoPersona(Integer idContactoPersona) {
        this.idContactoPersona = idContactoPersona;
    }

    public ContactoPersona(Integer idContactoPersona, String estado, String valor) {
        this.idContactoPersona = idContactoPersona;
        this.estado = estado;
        this.valor = valor;
    }

    public Integer getIdContactoPersona() {
        return idContactoPersona;
    }

    public void setIdContactoPersona(Integer idContactoPersona) {
        this.idContactoPersona = idContactoPersona;
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

    public Contacto getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Contacto idContacto) {
        this.idContacto = idContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContactoPersona != null ? idContactoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoPersona)) {
            return false;
        }
        ContactoPersona other = (ContactoPersona) object;
        if ((this.idContactoPersona == null && other.idContactoPersona != null) || (this.idContactoPersona != null && !this.idContactoPersona.equals(other.idContactoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.entidades.ContactoPersona[ idContactoPersona=" + idContactoPersona + " ]";
    }
    
}
