/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.ContactoDTO;


/**
 *
 * @author Jhonny
 */
public interface ContactoDAO {
    
    
    /**
     * Permite obtener el contacto de emergencia de una Persona.
     *
     * @param idPersona  Identificador de la Persona.
     * @return PersonaDTO  Un objeto Contacto con sus datos.
     */
    public ContactoDTO findContactoById(String idPersona);
        
        
}
