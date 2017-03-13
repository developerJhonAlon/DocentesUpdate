/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servidordocente.eis;

import ec.edu.espe.servidordocente.dto.PersonaDTO;
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
public class PersonaDAOImpl implements PersonaDAO{

    @PersistenceContext(unitName="ServidorDocenteUpdate-ejbPU")
    EntityManager em;

    @Override
    public PersonaDTO findPersonaById(String idPersona) {
        Query query = em.createQuery("SELECT p FROM PersonaDTO p WHERE p.perIdPersona = :idPersona");
        query.setParameter("idPersona", idPersona);
        return (PersonaDTO) query.getSingleResult();
    }

    @Override
    public void updatePersona(PersonaDTO personaDTO) {
        em.merge(personaDTO);
    }

    @Override
    public List<PersonaDTO> findAllPersonas() {
        Query query = em.createQuery("SELECT p FROM PersonaDTO p");
        return query.getResultList();
    }

  

   
}
