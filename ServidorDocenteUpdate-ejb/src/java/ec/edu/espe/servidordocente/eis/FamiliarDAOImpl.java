/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.FamiliarDTO;
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
public class FamiliarDAOImpl implements FamiliarDAO{

    @PersistenceContext(unitName="ServidorDocenteUpdate-ejbPU")
    EntityManager em;
    
    @Override
    public List<FamiliarDTO> findFamiliarByPersona(String idPersona) {
        Query query = em.createQuery("SELECT f FROM FamiliarDTO f WHERE f.perIdPersona.perIdPersona = :idPersona");
        query.setParameter("idPersona", idPersona);
        return query.getResultList();
    }

    @Override
    public void insertFamiliar(FamiliarDTO familiarDTO) {
        familiarDTO.setFamConfirmado(false);
        em.persist(familiarDTO);
   
    }

    @Override
    public void updateFamiliar(FamiliarDTO familiarDTO) {
        em.merge(familiarDTO);
  
    }

    @Override
    public void confirmFamiliar(FamiliarDTO familiarDTO) {
        familiarDTO.setFamConfirmado(true);
        em.merge(familiarDTO);
    }
    
    
}
