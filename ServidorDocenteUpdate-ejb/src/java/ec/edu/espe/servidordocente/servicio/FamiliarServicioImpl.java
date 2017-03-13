/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.FamiliarDTO;
import ec.edu.espe.servidordocente.eis.FamiliarDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jhonny
 */
@Stateless
public class FamiliarServicioImpl implements FamiliarServicio{

    @EJB
    private FamiliarDAO familiarDAO;
    
    @Override
    public List<FamiliarDTO> encontrarFamiliarPorPersona(String idPersona) {
       return familiarDAO.findFamiliarByPersona(idPersona);
    }

    @Override
    public void registrarFamiliar(FamiliarDTO familiarDTO) {
        familiarDAO.insertFamiliar(familiarDTO);
    }

    @Override
    public void modificarFamiliar(FamiliarDTO familiarDTO) {
        familiarDAO.updateFamiliar(familiarDTO);
    }

    @Override
    public void confirmarFamiliar(FamiliarDTO familiarDTO) {
        familiarDAO.confirmFamiliar(familiarDTO);
    }
    
    
}
