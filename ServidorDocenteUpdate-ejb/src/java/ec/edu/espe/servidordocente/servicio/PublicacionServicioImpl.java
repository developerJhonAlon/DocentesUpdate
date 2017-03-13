/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.PublicacionDTO;
import ec.edu.espe.servidordocente.eis.PublicacionDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jhonny
 */
@Stateless
public class PublicacionServicioImpl implements PublicacionServicio{
    
    @EJB
    private PublicacionDAO publicacionDAO;

    @Override
    public List<PublicacionDTO> encontrarPublicacionPorPersona(String idPersona) {
        return publicacionDAO.findPublicacionByPersona(idPersona);
    }

    @Override
    public void registrarPublicacion(PublicacionDTO publicacionDTO) {
        publicacionDAO.insertPublicacion(publicacionDTO);
    }

    @Override
    public void modificarPublicacion(PublicacionDTO publicacionDTO) {
        publicacionDAO.updatePublicacion(publicacionDTO);
    }

    @Override
    public void confirmarPublicacion(PublicacionDTO publicacionDTO) {
        publicacionDAO.confirmPublicacion(publicacionDTO);
    }
    
    
    
}
