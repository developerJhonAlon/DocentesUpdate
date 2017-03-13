/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.beans;

import ec.edu.espe.servidordocente.dto.PersonaDTO;
import ec.edu.espe.servidordocente.servicio.PersonaServicio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jhonny
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
    
    @EJB
    private PersonaServicio personaServicio;
    
    private PersonaDTO personaDTO = null;
    private String identificador = "";
    private String identificadorTHumano = "";
     
    
    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }

    public String getIdentificadorTHumano() {
        return identificadorTHumano;
    }

    public void setIdentificadorTHumano(String identificadorTHumano) {
        this.identificadorTHumano = identificadorTHumano;
    }
    
    

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }
    
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
     public String iniciarSesion(){
        this.personaDTO = personaServicio.encontrarPersonaPorId(this.identificador);
        if(this.personaDTO == null){
            return "loginPersona";
        }else{
            return "menuDocente";
        }
    }
    
      public String iniciarSesionTHumano(){
         if("admin".equals(this.identificadorTHumano)){
            return "listadoDocentes";
        }else{
            return "loginConfirmar";
        }
    }
}
