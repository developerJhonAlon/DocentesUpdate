/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.PersonaDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface PersonaDAO {
    
    /**
     * Permite obtener la información personal de una Persona.
     *
     * @param idPersona  Identificador de la Persona.
     * @return PersonaDTO  Uno objeto Persona con sus datos.
     */
    public PersonaDTO findPersonaById(String idPersona);
    
    
    public List<PersonaDTO> findAllPersonas();
    
    public void updatePersona(PersonaDTO personaDTO);
    
    
}
