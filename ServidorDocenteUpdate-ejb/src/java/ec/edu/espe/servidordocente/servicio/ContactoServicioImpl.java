/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.servicio;

import ec.edu.espe.servidordocente.dto.ContactoDTO;
import ec.edu.espe.servidordocente.eis.ContactoDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jhonny
 */
@Stateless
public class ContactoServicioImpl implements ContactoServicio{
    
    @EJB
    private ContactoDAO contactoDAO;
    
    @Override
    public ContactoDTO encontrarContactoPorId(String idPersona) {
       return contactoDAO.findContactoById(idPersona);
    }
    
    
}
