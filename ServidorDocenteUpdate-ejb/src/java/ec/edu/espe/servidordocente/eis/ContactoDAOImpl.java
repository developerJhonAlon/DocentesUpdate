/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.ContactoDTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhonny
 */
@Stateless
public class ContactoDAOImpl implements ContactoDAO{

    
    @PersistenceContext(unitName="ServidorDocenteUpdate-ejbPU")
    EntityManager em;
    
    @Override
    public ContactoDTO findContactoById(String idPersona) {
        Query query = em.createQuery("SELECT c FROM ContactoDTO c WHERE c.perIdPersona = :idPersona");
        query.setParameter("idPersona", idPersona);
        return (ContactoDTO) query.getSingleResult();
      }
    
}
