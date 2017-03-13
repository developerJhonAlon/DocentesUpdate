/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.PersonaDTO;
import ec.edu.espe.servidordocente.eis.PersonaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jhonny
 */
@Stateless
public class PersonaServicioImpl implements PersonaServicio{

    @EJB
    private PersonaDAO personaDAO;
    
   
    @Override
    public PersonaDTO encontrarPersonaPorId(String idPersona) {
        return personaDAO.findPersonaById(idPersona);
        
    }

    @Override
    public void modificarPersona(PersonaDTO personaDTO) {
        personaDAO.updatePersona(personaDTO);
    }

    @Override
    public List<PersonaDTO> listarPersonas() {
        return personaDAO.findAllPersonas();
    }
  
    
    
    
    
}
