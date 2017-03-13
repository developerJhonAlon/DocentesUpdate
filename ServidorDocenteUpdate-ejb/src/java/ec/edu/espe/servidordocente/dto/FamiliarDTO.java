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
@Table(name = "FAMILIAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamiliarDTO.findAll", query = "SELECT f FROM FamiliarDTO f"),
    @NamedQuery(name = "FamiliarDTO.findByFamIdFamiliar", query = "SELECT f FROM FamiliarDTO f WHERE f.famIdFamiliar = :famIdFamiliar"),
    @NamedQuery(name = "FamiliarDTO.findByFamNombre", query = "SELECT f FROM FamiliarDTO f WHERE f.famNombre = :famNombre"),
    @NamedQuery(name = "FamiliarDTO.findByFamParentesco", query = "SELECT f FROM FamiliarDTO f WHERE f.famParentesco = :famParentesco"),
    @NamedQuery(name = "FamiliarDTO.findByFamFechaNacimiento", query = "SELECT f FROM FamiliarDTO f WHERE f.famFechaNacimiento = :famFechaNacimiento"),
    @NamedQuery(name = "FamiliarDTO.findByFamGenero", query = "SELECT f FROM FamiliarDTO f WHERE f.famGenero = :famGenero"),
    @NamedQuery(name = "FamiliarDTO.findByFamDiscapacidad", query = "SELECT f FROM FamiliarDTO f WHERE f.famDiscapacidad = :famDiscapacidad"),
    @NamedQuery(name = "FamiliarDTO.findByFamTipoDiscapacidad", query = "SELECT f FROM FamiliarDTO f WHERE f.famTipoDiscapacidad = :famTipoDiscapacidad"),
    @NamedQuery(name = "FamiliarDTO.findByFamNumCarnet", query = "SELECT f FROM FamiliarDTO f WHERE f.famNumCarnet = :famNumCarnet"),
    @NamedQuery(name = "FamiliarDTO.findByFamPorDiscapacidad", query = "SELECT f FROM FamiliarDTO f WHERE f.famPorDiscapacidad = :famPorDiscapacidad"),
    @NamedQuery(name = "FamiliarDTO.findByFamConfirmado", query = "SELECT f FROM FamiliarDTO f WHERE f.famConfirmado = :famConfirmado"),
    @NamedQuery(name = "FamiliarDTO.findByFamPdf", query = "SELECT f FROM FamiliarDTO f WHERE f.famPdf = :famPdf")})
public class FamiliarDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "FAM_ID_FAMILIAR")
    private BigDecimal famIdFamiliar;
    
    @Size(max = 40)
    @Column(name = "FAM_NOMBRE")
    private String famNombre;
    @Size(max = 40)
    @Column(name = "FAM_PARENTESCO")
    private String famParentesco;
    @Column(name = "FAM_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date famFechaNacimiento;
    @Size(max = 40)
    @Column(name = "FAM_GENERO")
    private String famGenero;
    @Size(max = 40)
    @Column(name = "FAM_DISCAPACIDAD")
    private String famDiscapacidad;
    @Size(max = 40)
    @Column(name = "FAM_TIPO_DISCAPACIDAD")
    private String famTipoDiscapacidad;
    @Size(max = 40)
    @Column(name = "FAM_NUM_CARNET")
    private String famNumCarnet;
    @Column(name = "FAM_POR_DISCAPACIDAD")
    private BigInteger famPorDiscapacidad;
    @Column(name = "FAM_CONFIRMADO")
    private Boolean famConfirmado;
    @Size(max = 30)
    @Column(name = "FAM_PDF")
    private String famPdf;
    @JoinColumn(name = "PER_ID_PERSONA", referencedColumnName = "PER_ID_PERSONA")
    @ManyToOne(optional = false)
    private PersonaDTO perIdPersona;

    public FamiliarDTO() {
    }

    public FamiliarDTO(BigDecimal famIdFamiliar) {
        this.famIdFamiliar = famIdFamiliar;
    }

    public BigDecimal getFamIdFamiliar() {
        return famIdFamiliar;
    }

    public void setFamIdFamiliar(BigDecimal famIdFamiliar) {
        this.famIdFamiliar = famIdFamiliar;
    }

    public String getFamNombre() {
        return famNombre;
    }

    public void setFamNombre(String famNombre) {
        this.famNombre = famNombre;
    }

    public String getFamParentesco() {
        return famParentesco;
    }

    public void setFamParentesco(String famParentesco) {
        this.famParentesco = famParentesco;
    }

    public Date getFamFechaNacimiento() {
        return famFechaNacimiento;
    }

    public void setFamFechaNacimiento(Date famFechaNacimiento) {
        this.famFechaNacimiento = famFechaNacimiento;
    }

    public String getFamGenero() {
        return famGenero;
    }

    public void setFamGenero(String famGenero) {
        this.famGenero = famGenero;
    }

    public String getFamDiscapacidad() {
        return famDiscapacidad;
    }

    public void setFamDiscapacidad(String famDiscapacidad) {
        this.famDiscapacidad = famDiscapacidad;
    }

    public String getFamTipoDiscapacidad() {
        return famTipoDiscapacidad;
    }

    public void setFamTipoDiscapacidad(String famTipoDiscapacidad) {
        this.famTipoDiscapacidad = famTipoDiscapacidad;
    }

    public String getFamNumCarnet() {
        return famNumCarnet;
    }

    public void setFamNumCarnet(String famNumCarnet) {
        this.famNumCarnet = famNumCarnet;
    }

    public BigInteger getFamPorDiscapacidad() {
        return famPorDiscapacidad;
    }

    public void setFamPorDiscapacidad(BigInteger famPorDiscapacidad) {
        this.famPorDiscapacidad = famPorDiscapacidad;
    }

    public Boolean getFamConfirmado() {
        return famConfirmado;
    }

    public void setFamConfirmado(Boolean famConfirmado) {
        this.famConfirmado = famConfirmado;
    }

    

    public String getFamPdf() {
        return famPdf;
    }

    public void setFamPdf(String famPdf) {
        this.famPdf = famPdf;
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
        hash += (famIdFamiliar != null ? famIdFamiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliarDTO)) {
            return false;
        }
        FamiliarDTO other = (FamiliarDTO) object;
        if ((this.famIdFamiliar == null && other.famIdFamiliar != null) || (this.famIdFamiliar != null && !this.famIdFamiliar.equals(other.famIdFamiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.servidordocente.dto.FamiliarDTO[ famIdFamiliar=" + famIdFamiliar + " ]";
    }
    
}
