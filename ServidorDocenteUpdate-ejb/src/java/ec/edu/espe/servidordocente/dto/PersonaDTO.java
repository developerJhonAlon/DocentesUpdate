/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonaDTO.findAll", query = "SELECT p FROM PersonaDTO p"),
    @NamedQuery(name = "PersonaDTO.findByPerIdPersona", query = "SELECT p FROM PersonaDTO p WHERE p.perIdPersona = :perIdPersona"),
    @NamedQuery(name = "PersonaDTO.findByPerTipo", query = "SELECT p FROM PersonaDTO p WHERE p.perTipo = :perTipo"),
    @NamedQuery(name = "PersonaDTO.findByPerNombre", query = "SELECT p FROM PersonaDTO p WHERE p.perNombre = :perNombre"),
    @NamedQuery(name = "PersonaDTO.findByPerApellido", query = "SELECT p FROM PersonaDTO p WHERE p.perApellido = :perApellido"),
    @NamedQuery(name = "PersonaDTO.findByPerCiudadania", query = "SELECT p FROM PersonaDTO p WHERE p.perCiudadania = :perCiudadania"),
    @NamedQuery(name = "PersonaDTO.findByPerEtnia", query = "SELECT p FROM PersonaDTO p WHERE p.perEtnia = :perEtnia"),
    @NamedQuery(name = "PersonaDTO.findByPerEmailPersonal", query = "SELECT p FROM PersonaDTO p WHERE p.perEmailPersonal = :perEmailPersonal"),
    @NamedQuery(name = "PersonaDTO.findByPerEmailInstitucional", query = "SELECT p FROM PersonaDTO p WHERE p.perEmailInstitucional = :perEmailInstitucional"),
    @NamedQuery(name = "PersonaDTO.findByPerGenero", query = "SELECT p FROM PersonaDTO p WHERE p.perGenero = :perGenero"),
    @NamedQuery(name = "PersonaDTO.findByPerEstCivil", query = "SELECT p FROM PersonaDTO p WHERE p.perEstCivil = :perEstCivil"),
    @NamedQuery(name = "PersonaDTO.findByPerFechaNacimiento", query = "SELECT p FROM PersonaDTO p WHERE p.perFechaNacimiento = :perFechaNacimiento"),
    @NamedQuery(name = "PersonaDTO.findByPerCampus", query = "SELECT p FROM PersonaDTO p WHERE p.perCampus = :perCampus"),
    @NamedQuery(name = "PersonaDTO.findByPerDedicacion", query = "SELECT p FROM PersonaDTO p WHERE p.perDedicacion = :perDedicacion"),
    @NamedQuery(name = "PersonaDTO.findByPerDepartamento", query = "SELECT p FROM PersonaDTO p WHERE p.perDepartamento = :perDepartamento"),
    @NamedQuery(name = "PersonaDTO.findByPerProvincia", query = "SELECT p FROM PersonaDTO p WHERE p.perProvincia = :perProvincia"),
    @NamedQuery(name = "PersonaDTO.findByPerCiudad", query = "SELECT p FROM PersonaDTO p WHERE p.perCiudad = :perCiudad"),
    @NamedQuery(name = "PersonaDTO.findByPerParroquia", query = "SELECT p FROM PersonaDTO p WHERE p.perParroquia = :perParroquia"),
    @NamedQuery(name = "PersonaDTO.findByPerDireccion", query = "SELECT p FROM PersonaDTO p WHERE p.perDireccion = :perDireccion"),
    @NamedQuery(name = "PersonaDTO.findByPerPdf", query = "SELECT p FROM PersonaDTO p WHERE p.perPdf = :perPdf")})
public class PersonaDTO implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perIdPersona")
    private Set<PublicacionDTO> publicacionDTOSet;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PER_ID_PERSONA")
    private String perIdPersona;
    @Size(max = 50)
    @Column(name = "PER_TIPO")
    private String perTipo;
    @Size(max = 70)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Size(max = 70)
    @Column(name = "PER_APELLIDO")
    private String perApellido;
    @Size(max = 50)
    @Column(name = "PER_CIUDADANIA")
    private String perCiudadania;
    @Size(max = 50)
    @Column(name = "PER_ETNIA")
    private String perEtnia;
    @Size(max = 50)
    @Column(name = "PER_EMAIL_PERSONAL")
    private String perEmailPersonal;
    @Size(max = 50)
    @Column(name = "PER_EMAIL_INSTITUCIONAL")
    private String perEmailInstitucional;
    @Size(max = 50)
    @Column(name = "PER_GENERO")
    private String perGenero;
    @Size(max = 50)
    @Column(name = "PER_EST_CIVIL")
    private String perEstCivil;
    @Column(name = "PER_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date perFechaNacimiento;
    @Size(max = 50)
    @Column(name = "PER_CAMPUS")
    private String perCampus;
    @Size(max = 50)
    @Column(name = "PER_DEDICACION")
    private String perDedicacion;
    @Size(max = 50)
    @Column(name = "PER_DEPARTAMENTO")
    private String perDepartamento;
    @Size(max = 50)
    @Column(name = "PER_PROVINCIA")
    private String perProvincia;
    @Size(max = 50)
    @Column(name = "PER_CIUDAD")
    private String perCiudad;
    @Size(max = 50)
    @Column(name = "PER_PARROQUIA")
    private String perParroquia;
    @Size(max = 50)
    @Column(name = "PER_DIRECCION")
    private String perDireccion;
    @Size(max = 30)
    @Column(name = "PER_PDF")
    private String perPdf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perIdPersona")
    private Set<CapacitacionDTO> capacitacionDTOSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personaDTO")
    private ContactoDTO contactoDTO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perIdPersona")
    private Set<FamiliarDTO> familiarDTOSet;

    public PersonaDTO() {
    }

    public PersonaDTO(String perIdPersona) {
        this.perIdPersona = perIdPersona;
    }

    public String getPerIdPersona() {
        return perIdPersona;
    }

    public void setPerIdPersona(String perIdPersona) {
        this.perIdPersona = perIdPersona;
    }

    public String getPerTipo() {
        return perTipo;
    }

    public void setPerTipo(String perTipo) {
        this.perTipo = perTipo;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerCiudadania() {
        return perCiudadania;
    }

    public void setPerCiudadania(String perCiudadania) {
        this.perCiudadania = perCiudadania;
    }

    public String getPerEtnia() {
        return perEtnia;
    }

    public void setPerEtnia(String perEtnia) {
        this.perEtnia = perEtnia;
    }

    public String getPerEmailPersonal() {
        return perEmailPersonal;
    }

    public void setPerEmailPersonal(String perEmailPersonal) {
        this.perEmailPersonal = perEmailPersonal;
    }

    public String getPerEmailInstitucional() {
        return perEmailInstitucional;
    }

    public void setPerEmailInstitucional(String perEmailInstitucional) {
        this.perEmailInstitucional = perEmailInstitucional;
    }

    public String getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(String perGenero) {
        this.perGenero = perGenero;
    }

    public String getPerEstCivil() {
        return perEstCivil;
    }

    public void setPerEstCivil(String perEstCivil) {
        this.perEstCivil = perEstCivil;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerCampus() {
        return perCampus;
    }

    public void setPerCampus(String perCampus) {
        this.perCampus = perCampus;
    }

    public String getPerDedicacion() {
        return perDedicacion;
    }

    public void setPerDedicacion(String perDedicacion) {
        this.perDedicacion = perDedicacion;
    }

    public String getPerDepartamento() {
        return perDepartamento;
    }

    public void setPerDepartamento(String perDepartamento) {
        this.perDepartamento = perDepartamento;
    }

    public String getPerProvincia() {
        return perProvincia;
    }

    public void setPerProvincia(String perProvincia) {
        this.perProvincia = perProvincia;
    }

    public String getPerCiudad() {
        return perCiudad;
    }

    public void setPerCiudad(String perCiudad) {
        this.perCiudad = perCiudad;
    }

    public String getPerParroquia() {
        return perParroquia;
    }

    public void setPerParroquia(String perParroquia) {
        this.perParroquia = perParroquia;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerPdf() {
        return perPdf;
    }

    public void setPerPdf(String perPdf) {
        this.perPdf = perPdf;
    }

    @XmlTransient
    public Set<CapacitacionDTO> getCapacitacionDTOSet() {
        return capacitacionDTOSet;
    }

    public void setCapacitacionDTOSet(Set<CapacitacionDTO> capacitacionDTOSet) {
        this.capacitacionDTOSet = capacitacionDTOSet;
    }

    public ContactoDTO getContactoDTO() {
        return contactoDTO;
    }

    public void setContactoDTO(ContactoDTO contactoDTO) {
        this.contactoDTO = contactoDTO;
    }

    @XmlTransient
    public Set<FamiliarDTO> getFamiliarDTOSet() {
        return familiarDTOSet;
    }

    public void setFamiliarDTOSet(Set<FamiliarDTO> familiarDTOSet) {
        this.familiarDTOSet = familiarDTOSet;
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
        if (!(object instanceof PersonaDTO)) {
            return false;
        }
        PersonaDTO other = (PersonaDTO) object;
        if ((this.perIdPersona == null && other.perIdPersona != null) || (this.perIdPersona != null && !this.perIdPersona.equals(other.perIdPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.servidordocente.dto.PersonaDTO[ perIdPersona=" + perIdPersona + " ]";
    }

    @XmlTransient
    public Set<PublicacionDTO> getPublicacionDTOSet() {
        return publicacionDTOSet;
    }

    public void setPublicacionDTOSet(Set<PublicacionDTO> publicacionDTOSet) {
        this.publicacionDTOSet = publicacionDTOSet;
    }
    
}
