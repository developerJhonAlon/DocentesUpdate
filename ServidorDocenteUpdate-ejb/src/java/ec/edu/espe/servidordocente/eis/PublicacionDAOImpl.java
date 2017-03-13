/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.PublicacionDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jhonny
 */
@Stateless
public class PublicacionDAOImpl implements PublicacionDAO{
    
    @PersistenceContext(unitName="ServidorDocenteUpdate-ejbPU")
    EntityManager em; 
       

    @Override
    public List<PublicacionDTO> findPublicacionByPersona(String idPersona) {
        Query query = em.createQuery("SELECT p FROM PublicacionDTO p WHERE p.perIdPersona.perIdPersona = :idPersona");
        query.setParameter("idPersona", idPersona);
        return query.getResultList();  
    }

    @Override
    public void insertPublicacion(PublicacionDTO publicacionDTO) {
        publicacionDTO.setPubConfirmado(false);
        em.persist(publicacionDTO);
       
    }

    @Override
    public void updatePublicacion(PublicacionDTO publicacionDTO) {
        em.merge(publicacionDTO);
    }

    @Override
    public void confirmPublicacion(PublicacionDTO publicacionDTO) {
        publicacionDTO.setPubConfirmado(true);
        em.merge(publicacionDTO);
   }
    
}
