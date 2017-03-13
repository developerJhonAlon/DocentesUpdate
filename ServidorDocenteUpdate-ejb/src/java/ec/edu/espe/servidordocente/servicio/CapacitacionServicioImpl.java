/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.CapacitacionDTO;
import ec.edu.espe.servidordocente.eis.CapacitacionDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jhonny
 */
@Stateless
public class CapacitacionServicioImpl implements CapacitacionServicio{
    
    @EJB
    private CapacitacionDAO capacitacionDAO;

    @Override
    public List<CapacitacionDTO> encontrarCapacitacionPorPersona(String idPersona) {
        return capacitacionDAO.findCapacitacionByPersona(idPersona);
    }

    @Override
    public void registrarCapacitacion(CapacitacionDTO capacitacionDTO) {
        capacitacionDAO.insertCapacitacion(capacitacionDTO);
    }

    @Override
    public void modificarCapacitacion(CapacitacionDTO capacitacionDTO) {
        capacitacionDAO.updateCapacitacion(capacitacionDTO);
    }

    @Override
    public void confirmarCapacitacion(CapacitacionDTO capacitacionDTO) {
        capacitacionDAO.confirmCapacitacion(capacitacionDTO);
    }
    
}
