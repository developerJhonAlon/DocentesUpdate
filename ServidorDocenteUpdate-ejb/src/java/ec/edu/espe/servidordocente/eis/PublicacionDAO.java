/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.PublicacionDTO;
import java.util.List;

/**
 *
 * @author Jhonny
 */
public interface PublicacionDAO {
    
    public List<PublicacionDTO> findPublicacionByPersona(String idPersona);
    
    public void insertPublicacion(PublicacionDTO publicacionDTO);
    
    public void updatePublicacion(PublicacionDTO publicacionDTO);
    
    public void confirmPublicacion(PublicacionDTO publicacionDTO);
}

