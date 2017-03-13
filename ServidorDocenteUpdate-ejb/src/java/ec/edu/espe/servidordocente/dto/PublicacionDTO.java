/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhonny
 */
@Entity
@Table(name = "PUBLICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PublicacionDTO.findAll", query = "SELECT p FROM PublicacionDTO p"),
    @NamedQuery(name = "PublicacionDTO.findByPubIdPublicacion", query = "SELECT p FROM PublicacionDTO p WHERE p.pubIdPublicacion = :pubIdPublicacion"),
    @NamedQuery(name = "PublicacionDTO.findByPubTitulo", query = "SELECT p FROM PublicacionDTO p WHERE p.pubTitulo = :pubTitulo"),
    @NamedQuery(name = "PublicacionDTO.findByPubParticipacion", query = "SELECT p FROM PublicacionDTO p WHERE p.pubParticipacion = :pubParticipacion"),
    @NamedQuery(name = "PublicacionDTO.findByPubPublicacion", query = "SELECT p FROM PublicacionDTO p WHERE p.pubPublicacion = :pubPublicacion"),
    @NamedQuery(name = "PublicacionDTO.findByPubCodDoi", query = "SELECT p FROM PublicacionDTO p WHERE p.pubCodDoi = :pubCodDoi"),
    @NamedQuery(name = "PublicacionDTO.findByPubNumRevision", query = "SELECT p FROM PublicacionDTO p WHERE p.pubNumRevision = :pubNumRevision"),
    @NamedQuery(name = "PublicacionDTO.findByPubCtgIndice", query = "SELECT p FROM PublicacionDTO p WHERE p.pubCtgIndice = :pubCtgIndice"),
    @NamedQuery(name = "PublicacionDTO.findByPubVolumen", query = "SELECT p FROM PublicacionDTO p WHERE p.pubVolumen = :pubVolumen"),
    @NamedQuery(name = "PublicacionDTO.findByPubRevision", query = "SELECT p FROM PublicacionDTO p WHERE p.pubRevision = :pubRevision"),
    @NamedQuery(name = "PublicacionDTO.findByPubCuartil", query = "SELECT p FROM PublicacionDTO p WHERE p.pubCuartil = :pubCuartil"),
    @NamedQuery(name = "PublicacionDTO.findByPubIdioma", query = "SELECT p FROM PublicacionDTO p WHERE p.pubIdioma = :pubIdioma"),
    @NamedQuery(name = "PublicacionDTO.findByPubNumIsbn", query = "SELECT p FROM PublicacionDTO p WHERE p.pubNumIsbn = :pubNumIsbn"),
    @NamedQuery(name = "PublicacionDTO.findByPubEstadoPub", query = "SELECT p FROM PublicacionDTO p WHERE p.pubEstadoPub = :pubEstadoPub"),
    @NamedQuery(name = "PublicacionDTO.findByPubCodIsbn", query = "SELECT p FROM PublicacionDTO p WHERE p.pubCodIsbn = :pubCodIsbn"),
    @NamedQuery(name = "PublicacionDTO.findByPubNumPagina", query = "SELECT p FROM PublicacionDTO p WHERE p.pubNumPagina = :pubNumPagina"),
    @NamedQuery(name = "PublicacionDTO.findByPubConfirmado", query = "SELECT p FROM PublicacionDTO p WHERE p.pubConfirmado = :pubConfirmado"),
    @NamedQuery(name = "PublicacionDTO.findByPubPdf", query = "SELECT p FROM PublicacionDTO p WHERE p.pubPdf = :pubPdf")})
public class PublicacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "PUB_ID_PUBLICACION")
    private BigDecimal pubIdPublicacion;
    
    @Size(max = 50)
    @Column(name = "PUB_TITULO")
    private String pubTitulo;
    @Size(max = 40)
    @Column(name = "PUB_PARTICIPACION")
    private String pubParticipacion;
    @Size(max = 50)
    @Column(name = "PUB_PUBLICACION")
    private String pubPublicacion;
    @Size(max = 40)
    @Column(name = "PUB_COD_DOI")
    private String pubCodDoi;
    @Size(max = 40)
    @Column(name = "PUB_NUM_REVISION")
    private String pubNumRevision;
    @Size(max = 40)
    @Column(name = "PUB_CTG_INDICE")
    private String pubCtgIndice;
    @Size(max = 40)
    @Column(name = "PUB_VOLUMEN")
    private String pubVolumen;
    @Size(max = 40)
    @Column(name = "PUB_REVISION")
    private String pubRevision;
    @Size(max = 40)
    @Column(name = "PUB_CUARTIL")
    private String pubCuartil;
    @Size(max = 40)
    @Column(name = "PUB_IDIOMA")
    private String pubIdioma;
    @Size(max = 40)
    @Column(name = "PUB_NUM_ISBN")
    private String pubNumIsbn;
    @Size(max = 40)
    @Column(name = "PUB_ESTADO_PUB")
    private String pubEstadoPub;
    @Size(max = 40)
    @Column(name = "PUB_COD_ISBN")
    private String pubCodIsbn;
    @Column(name = "PUB_NUM_PAGINA")
    private BigInteger pubNumPagina;
    
    @Column(name = "PUB_CONFIRMADO")
    private Boolean pubConfirmado;
    
    @Size(max = 30)
    @Column(name = "PUB_PDF")
    private String pubPdf;
    @JoinColumn(name = "PER_ID_PERSONA", referencedColumnName = "PER_ID_PERSONA")
    @ManyToOne(optional = false)
    private PersonaDTO perIdPersona;

    public PublicacionDTO() {
    }

    public PublicacionDTO(BigDecimal pubIdPublicacion) {
        this.pubIdPublicacion = pubIdPublicacion;
    }

    public BigDecimal getPubIdPublicacion() {
        return pubIdPublicacion;
    }

    public void setPubIdPublicacion(BigDecimal pubIdPublicacion) {
        this.pubIdPublicacion = pubIdPublicacion;
    }

    public String getPubTitulo() {
        return pubTitulo;
    }

    public void setPubTitulo(String pubTitulo) {
        this.pubTitulo = pubTitulo;
    }

    public String getPubParticipacion() {
        return pubParticipacion;
    }

    public void setPubParticipacion(String pubParticipacion) {
        this.pubParticipacion = pubParticipacion;
    }

    public String getPubPublicacion() {
        return pubPublicacion;
    }

    public void setPubPublicacion(String pubPublicacion) {
        this.pubPublicacion = pubPublicacion;
    }

    public String getPubCodDoi() {
        return pubCodDoi;
    }

    public void setPubCodDoi(String pubCodDoi) {
        this.pubCodDoi = pubCodDoi;
    }

    public String getPubNumRevision() {
        return pubNumRevision;
    }

    public void setPubNumRevision(String pubNumRevision) {
        this.pubNumRevision = pubNumRevision;
    }

    public String getPubCtgIndice() {
        return pubCtgIndice;
    }

    public void setPubCtgIndice(String pubCtgIndice) {
        this.pubCtgIndice = pubCtgIndice;
    }

    public String getPubVolumen() {
        return pubVolumen;
    }

    public void setPubVolumen(String pubVolumen) {
        this.pubVolumen = pubVolumen;
    }

    public String getPubRevision() {
        return pubRevision;
    }

    public void setPubRevision(String pubRevision) {
        this.pubRevision = pubRevision;
    }

    public String getPubCuartil() {
        return pubCuartil;
    }

    public void setPubCuartil(String pubCuartil) {
        this.pubCuartil = pubCuartil;
    }

    public String getPubIdioma() {
        return pubIdioma;
    }

    public void setPubIdioma(String pubIdioma) {
        this.pubIdioma = pubIdioma;
    }

    public String getPubNumIsbn() {
        return pubNumIsbn;
    }

    public void setPubNumIsbn(String pubNumIsbn) {
        this.pubNumIsbn = pubNumIsbn;
    }

    public String getPubEstadoPub() {
        return pubEstadoPub;
    }

    public void setPubEstadoPub(String pubEstadoPub) {
        this.pubEstadoPub = pubEstadoPub;
    }

    public String getPubCodIsbn() {
        return pubCodIsbn;
    }

    public void setPubCodIsbn(String pubCodIsbn) {
        this.pubCodIsbn = pubCodIsbn;
    }

    public BigInteger getPubNumPagina() {
        return pubNumPagina;
    }

    public void setPubNumPagina(BigInteger pubNumPagina) {
        this.pubNumPagina = pubNumPagina;
    }

    public Boolean getPubConfirmado() {
        return pubConfirmado;
    }

    public void setPubConfirmado(Boolean pubConfirmado) {
        this.pubConfirmado = pubConfirmado;
    }

    

    public String getPubPdf() {
        return pubPdf;
    }

    public void setPubPdf(String pubPdf) {
        this.pubPdf = pubPdf;
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
        hash += (pubIdPublicacion != null ? pubIdPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicacionDTO)) {
            return false;
        }
        PublicacionDTO other = (PublicacionDTO) object;
        if ((this.pubIdPublicacion == null && other.pubIdPublicacion != null) || (this.pubIdPublicacion != null && !this.pubIdPublicacion.equals(other.pubIdPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.servidordocente.dto.PublicacionDTO[ pubIdPublicacion=" + pubIdPublicacion + " ]";
    }
    
}
