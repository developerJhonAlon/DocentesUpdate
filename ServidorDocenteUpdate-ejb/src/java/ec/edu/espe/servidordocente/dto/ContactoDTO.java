/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "CONTACTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoDTO.findAll", query = "SELECT c FROM ContactoDTO c"),
    @NamedQuery(name = "ContactoDTO.findByPerIdPersona", query = "SELECT c FROM ContactoDTO c WHERE c.perIdPersona = :perIdPersona"),
    @NamedQuery(name = "ContactoDTO.findByConNombre", query = "SELECT c FROM ContactoDTO c WHERE c.conNombre = :conNombre"),
    @NamedQuery(name = "ContactoDTO.findByConTelefono", query = "SELECT c FROM ContactoDTO c WHERE c.conTelefono = :conTelefono"),
    @NamedQuery(name = "ContactoDTO.findByConParentesco", query = "SELECT c FROM ContactoDTO c WHERE c.conParentesco = :conParentesco"),
    @NamedQuery(name = "ContactoDTO.findByConExtension", query = "SELECT c FROM ContactoDTO c WHERE c.conExtension = :conExtension"),
    @NamedQuery(name = "ContactoDTO.findByConParroquia", query = "SELECT c FROM ContactoDTO c WHERE c.conParroquia = :conParroquia"),
    @NamedQuery(name = "ContactoDTO.findByConCiudad", query = "SELECT c FROM ContactoDTO c WHERE c.conCiudad = :conCiudad"),
    @NamedQuery(name = "ContactoDTO.findByConDireccion", query = "SELECT c FROM ContactoDTO c WHERE c.conDireccion = :conDireccion")})
public class ContactoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PER_ID_PERSONA")
    private String perIdPersona;
    @Size(max = 70)
    @Column(name = "CON_NOMBRE")
    private String conNombre;
    @Size(max = 70)
    @Column(name = "CON_TELEFONO")
    private String conTelefono;
    @Size(max = 70)
    @Column(name = "CON_PARENTESCO")
    private String conParentesco;
    @Size(max = 70)
    @Column(name = "CON_EXTENSION")
    private String conExtension;
    @Size(max = 70)
    @Column(name = "CON_PARROQUIA")
    private String conParroquia;
    @Size(max = 70)
    @Column(name = "CON_CIUDAD")
    private String conCiudad;
    @Size(max = 70)
    @Column(name = "CON_DIRECCION")
    private String conDireccion;
    @JoinColumn(name = "PER_ID_PERSONA", referencedColumnName = "PER_ID_PERSONA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PersonaDTO personaDTO;

    public ContactoDTO() {
    }

    public ContactoDTO(String perIdPersona) {
        this.perIdPersona = perIdPersona;
    }

    public String getPerIdPersona() {
        return perIdPersona;
    }

    public void setPerIdPersona(String perIdPersona) {
        this.perIdPersona = perIdPersona;
    }

    public String getConNombre() {
        return conNombre;
    }

    public void setConNombre(String conNombre) {
        this.conNombre = conNombre;
    }

    public String getConTelefono() {
        return conTelefono;
    }

    public void setConTelefono(String conTelefono) {
        this.conTelefono = conTelefono;
    }

    public String getConParentesco() {
        return conParentesco;
    }

    public void setConParentesco(String conParentesco) {
        this.conParentesco = conParentesco;
    }

    public String getConExtension() {
        return conExtension;
    }

    public void setConExtension(String conExtension) {
        this.conExtension = conExtension;
    }

    public String getConParroquia() {
        return conParroquia;
    }

    public void setConParroquia(String conParroquia) {
        this.conParroquia = conParroquia;
    }

    public String getConCiudad() {
        return conCiudad;
    }

    public void setConCiudad(String conCiudad) {
        this.conCiudad = conCiudad;
    }

    public String getConDireccion() {
        return conDireccion;
    }

    public void setConDireccion(String conDireccion) {
        this.conDireccion = conDireccion;
    }

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perIdPersona != null ? perIdPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoDTO)) {
            return false;
        }
        ContactoDTO other = (ContactoDTO) object;
        if ((this.perIdPersona == null && other.perIdPersona != null) || (this.perIdPersona != null && !this.perIdPersona.equals(other.perIdPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.servidordocente.dto.ContactoDTO[ perIdPersona=" + perIdPersona + " ]";
    }
    
}
