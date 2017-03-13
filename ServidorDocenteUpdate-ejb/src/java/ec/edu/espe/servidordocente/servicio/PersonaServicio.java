/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.PersonaDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhonny
 */
@Local
public interface PersonaServicio {
    
   /**
     * Permite obtener la información personal de una Persona.
     *
     * @param idPersona  Identificador de la Persona.
     * @return PersonaDTO  Uno objeto Persona con sus datos.
     */
    public PersonaDTO encontrarPersonaPorId(String idPersona);
    
    public List<PersonaDTO> listarPersonas();
    
    public void modificarPersona(PersonaDTO personaDTO);
}
