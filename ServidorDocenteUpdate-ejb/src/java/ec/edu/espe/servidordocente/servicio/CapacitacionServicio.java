/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.CapacitacionDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhonny
 */
@Local
public interface CapacitacionServicio {
    
    public List<CapacitacionDTO> encontrarCapacitacionPorPersona(String idPersona);
    
    public void registrarCapacitacion(CapacitacionDTO capacitacionDTO);
    
    public void modificarCapacitacion(CapacitacionDTO capacitacionDTO);
    
    public void confirmarCapacitacion(CapacitacionDTO capacitacionDTO);
}
