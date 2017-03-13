/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.CapacitacionDTO;
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
public class CapacitacionDAOImpl implements CapacitacionDAO{
    
    @PersistenceContext(unitName="ServidorDocenteUpdate-ejbPU")
    EntityManager em; 
       
    @Override
    public List<CapacitacionDTO> findCapacitacionByPersona(String idPersona) {
        Query query = em.createQuery("SELECT c FROM CapacitacionDTO c WHERE c.perIdPersona.perIdPersona = :idPersona");
        query.setParameter("idPersona", idPersona);
        return query.getResultList();    
    }

    @Override
    public void insertCapacitacion(CapacitacionDTO capacitacionDTO) {
        capacitacionDTO.setCapConfirmado(false);
        em.persist(capacitacionDTO);
    }

    @Override
    public void updateCapacitacion(CapacitacionDTO capacitacionDTO) {
        em.merge(capacitacionDTO);
    }

    @Override
    public void confirmCapacitacion(CapacitacionDTO capacitacionDTO) {
        capacitacionDTO.setCapConfirmado(true);
        em.merge(capacitacionDTO);
    }
    
    
}
