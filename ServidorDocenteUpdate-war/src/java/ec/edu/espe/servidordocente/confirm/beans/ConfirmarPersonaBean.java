/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.confirm.beans;

import ec.edu.espe.servidordocente.dto.ContactoDTO;
import ec.edu.espe.servidordocente.dto.PersonaDTO;
import ec.edu.espe.servidordocente.servicio.ContactoServicio;
import ec.edu.espe.servidordocente.servicio.PersonaServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jhonny
 */
@ManagedBean
@ViewScoped
public class ConfirmarPersonaBean implements Serializable{
    
    @EJB
    private PersonaServicio personaServicio;
    
    @EJB
    private ContactoServicio contactoServicio;
    
    @ManagedProperty(value = "#{docenteBean}")
    private DocenteBean docenteBean;
    
    private ContactoDTO contactoDTO;
    private PersonaDTO personaDTO;

    /** Creates a new instance of ConfirmarPersona */
    public ConfirmarPersonaBean() {
    }

    public DocenteBean getDocenteBean() {
        return docenteBean;
    }

    public void setDocenteBean(DocenteBean docenteBean) {
        this.docenteBean = docenteBean;
    }

    public ContactoDTO getContactoDTO() {
        return contactoDTO;
    }

    public void setContactoDTO(ContactoDTO contactoDTO) {
        this.contactoDTO = contactoDTO;
    }

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }
    
    @PostConstruct
    public void inicializar() {
        this.personaDTO = this.personaServicio.encontrarPersonaPorId(docenteBean.getDocenteSeleccionado().getPerIdPersona());
        this.contactoDTO = this.contactoServicio.encontrarContactoPorId(docenteBean.getDocenteSeleccionado().getPerIdPersona());
        
    }
    
    
    
    
}
