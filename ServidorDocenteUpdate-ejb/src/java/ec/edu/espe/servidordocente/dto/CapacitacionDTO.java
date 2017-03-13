/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "CAPACITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CapacitacionDTO.findAll", query = "SELECT c FROM CapacitacionDTO c"),
    @NamedQuery(name = "CapacitacionDTO.findByCapIdCapacitacion", query = "SELECT c FROM CapacitacionDTO c WHERE c.capIdCapacitacion = :capIdCapacitacion"),
    @NamedQuery(name = "CapacitacionDTO.findByCapTipo", query = "SELECT c FROM CapacitacionDTO c WHERE c.capTipo = :capTipo"),
    @NamedQuery(name = "CapacitacionDTO.findByCapNombre", query = "SELECT c FROM CapacitacionDTO c WHERE c.capNombre = :capNombre"),
    @NamedQuery(name = "CapacitacionDTO.findByCapInstitucion", query = "SELECT c FROM CapacitacionDTO c WHERE c.capInstitucion = :capInstitucion"),
    @NamedQuery(name = "CapacitacionDTO.findByCapProfesional", query = "SELECT c FROM CapacitacionDTO c WHERE c.capProfesional = :capProfesional"),
    @NamedQuery(name = "CapacitacionDTO.findByCapArea", query = "SELECT c FROM CapacitacionDTO c WHERE c.capArea = :capArea"),
    @NamedQuery(name = "CapacitacionDTO.findByCapNumHoras", query = "SELECT c FROM CapacitacionDTO c WHERE c.capNumHoras = :capNumHoras"),
    @NamedQuery(name = "CapacitacionDTO.findByCapPais", query = "SELECT c FROM CapacitacionDTO c WHERE c.capPais = :capPais"),
    @NamedQuery(name = "CapacitacionDTO.findByCapFechaInicio", query = "SELECT c FROM CapacitacionDTO c WHERE c.capFechaInicio = :capFechaInicio"),
    @NamedQuery(name = "CapacitacionDTO.findByCapFechaFinal", query = "SELECT c FROM CapacitacionDTO c WHERE c.capFechaFinal = :capFechaFinal"),
    @NamedQuery(name = "CapacitacionDTO.findByCapConfirmado", query = "SELECT c FROM CapacitacionDTO c WHERE c.capConfirmado = :capConfirmado"),
    @NamedQuery(name = "CapacitacionDTO.findByCapPdf", query = "SELECT c FROM CapacitacionDTO c WHERE c.capPdf = :capPdf")})
public class CapacitacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "CAP_ID_CAPACITACION")
    private BigDecimal capIdCapacitacion;
    
    
    @Size(max = 50)
    @Column(name = "CAP_TIPO")
    private String capTipo;
    @Size(max = 70)
    @Column(name = "CAP_NOMBRE")
    private String capNombre;
    @Size(max = 50)
    @Column(name = "CAP_INSTITUCION")
    private String capInstitucion;
    @Size(max = 50)
    @Column(name = "CAP_PROFESIONAL")
    private String capProfesional;
    @Size(max = 50)
    @Column(name = "CAP_AREA")
    private String capArea;
    @Size(max = 30)
    @Column(name = "CAP_NUM_HORAS")
    private String capNumHoras;
    @Size(max = 50)
    @Column(name = "CAP_PAIS")
    private String capPais;
    @Column(name = "CAP_FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date capFechaInicio;
    @Column(name = "CAP_FECHA_FINAL")
    @Temporal(TemporalType.DATE)
    private Date capFechaFinal;
    @Column(name = "CAP_CONFIRMADO")
    private Boolean capConfirmado;
    @Size(max = 30)
    @Column(name = "CAP_PDF")
    private String capPdf;
    @JoinColumn(name = "PER_ID_PERSONA", referencedColumnName = "PER_ID_PERSONA")
    @ManyToOne(optional = false)
    private PersonaDTO perIdPersona;

    public CapacitacionDTO() {
    }

    public CapacitacionDTO(BigDecimal capIdCapacitacion) {
        this.capIdCapacitacion = capIdCapacitacion;
    }

    public BigDecimal getCapIdCapacitacion() {
        return capIdCapacitacion;
    }

    public void setCapIdCapacitacion(BigDecimal capIdCapacitacion) {
        this.capIdCapacitacion = capIdCapacitacion;
    }

    public String getCapTipo() {
        return capTipo;
    }

    public void setCapTipo(String capTipo) {
        this.capTipo = capTipo;
    }

    public String getCapNombre() {
        return capNombre;
    }

    public void setCapNombre(String capNombre) {
        this.capNombre = capNombre;
    }

    public String getCapInstitucion() {
        return capInstitucion;
    }

    public void setCapInstitucion(String capInstitucion) {
        this.capInstitucion = capInstitucion;
    }

    public String getCapProfesional() {
        return capProfesional;
    }

    public void setCapProfesional(String capProfesional) {
        this.capProfesional = capProfesional;
    }

    public String getCapArea() {
        return capArea;
    }

    public void setCapArea(String capArea) {
        this.capArea = capArea;
    }

    public String getCapNumHoras() {
        return capNumHoras;
    }

    public void setCapNumHoras(String capNumHoras) {
        this.capNumHoras = capNumHoras;
    }

    public String getCapPais() {
        return capPais;
    }

    public void setCapPais(String capPais) {
        this.capPais = capPais;
    }

    public Date getCapFechaInicio() {
        return capFechaInicio;
    }

    public void setCapFechaInicio(Date capFechaInicio) {
        this.capFechaInicio = capFechaInicio;
    }

    public Date getCapFechaFinal() {
        return capFechaFinal;
    }

    public void setCapFechaFinal(Date capFechaFinal) {
        this.capFechaFinal = capFechaFinal;
    }

  

    public String getCapPdf() {
        return capPdf;
    }

    public Boolean getCapConfirmado() {
        return capConfirmado;
    }

    public void setCapConfirmado(Boolean capConfirmado) {
        this.capConfirmado = capConfirmado;
    }

    public void setCapPdf(String capPdf) {
        this.capPdf = capPdf;
    }

    public PersonaDTO getPerIdPersona() {
        return perIdPersona;
    }

    public void setPerIdPersona(PersonaDTO perIdPersona) {
        this.perIdPersona = perIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capIdCapacitacion != null ? capIdCapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionDTO)) {
            return false;
        }
        CapacitacionDTO other = (CapacitacionDTO) object;
        if ((this.capIdCapacitacion == null && other.capIdCapacitacion != null) || (this.capIdCapacitacion != null && !this.capIdCapacitacion.equals(other.capIdCapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.servidordocente.dto.CapacitacionDTO[ capIdCapacitacion=" + capIdCapacitacion + " ]";
    }
    
}
