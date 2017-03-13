/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.PublicacionDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jhonny
 */
@Local
public interface PublicacionServicio {
    
    public List<PublicacionDTO> encontrarPublicacionPorPersona(String idPersona);
    
    public void registrarPublicacion(PublicacionDTO publicacionDTO);
    
    public void modificarPublicacion(PublicacionDTO publicacionDTO);
    
    public void confirmarPublicacion(PublicacionDTO publicacionDTO);
    
}
