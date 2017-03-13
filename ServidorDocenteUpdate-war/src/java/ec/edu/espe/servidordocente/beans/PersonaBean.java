/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.beans;

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
public class PersonaBean implements Serializable{ 
    
    @EJB
    private PersonaServicio personaServicio;
    
    @EJB
    private ContactoServicio contactoServicio;
    
    private PersonaDTO personaDTO;
    private ContactoDTO contactoDTO;
    
    @ManagedProperty(value= "#{loginBean}")
    private LoginBean loginBean;
    
    /** Creates a new instance of PersonalBean */
    public PersonaBean() {
    } 

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    public ContactoDTO getContactoDTO() {
        return contactoDTO;
    }

    public void setContactoDTO(ContactoDTO contactoDTO) {
        this.contactoDTO = contactoDTO;
    }
    
 

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    
    @PostConstruct
    public void inicializar(){
        this.personaDTO = this.personaServicio.encontrarPersonaPorId(this.loginBean.getPersonaDTO().getPerIdPersona());
        this.contactoDTO = this.contactoServicio.encontrarContactoPorId(this.loginBean.getPersonaDTO().getPerIdPersona());
    }
    
    
   


    
    
    
}
