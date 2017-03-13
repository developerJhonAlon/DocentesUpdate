/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.CapacitacionDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface CapacitacionDAO {
    
    public List<CapacitacionDTO> findCapacitacionByPersona(String idPersona);
    
    public void insertCapacitacion(CapacitacionDTO capacitacionDTO);
    
    public void updateCapacitacion(CapacitacionDTO capacitacionDTO);
    
    
     /**
     * Permite confirmar que la Capacitacion es correcta.
     *
     * @param capacitacionDTO  Objeto de tipo Capacitacion para confirmar.
     */
    public void confirmCapacitacion(CapacitacionDTO capacitacionDTO);
    
}
