/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.FamiliarDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhonny
 */
@Local
public interface FamiliarServicio {
 
      /**
     * Permite obtener todos los Familiares de una Persona.
     *
     * @param idPersona  Identificador de la Persona.
     * @return AdpFamiliar  Una lista de todos los familiares.
     */
    public List<FamiliarDTO> encontrarFamiliarPorPersona(String idPersona);
    
     /**
     * Permite añadir una Familiar de una Persona.
     *
     * @param familiarDTO  Objeto de tipo Familiar a guardar.
     */
    public void registrarFamiliar(FamiliarDTO familiarDTO);
    
    /**
     * Permite modificar caracteristicas de un Familiar.
     *
     * @param familiarDTO  Objeto de tipo Familiar a editar.
     */
    public void modificarFamiliar(FamiliarDTO familiarDTO);
    
    /**
     * Permite confirmar la Informacion de Familiar es correcta.
     *
     * @param familiarDTO  Objeto de tipo Familiar para confirmar.
     */
    public void confirmarFamiliar(FamiliarDTO familiarDTO);
}
