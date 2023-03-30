/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.backend.parcial1.model.ConceptosUsoPuntos;

/**
 *
 * @author macro
 */
@Stateless
public class ConceptosUsoPuntosDAO {

    @PersistenceContext(unitName = "parcial1PU")
    private EntityManager em;

    public void insertar(ConceptosUsoPuntos conceptosusopuntos) {
        this.em.persist(conceptosusopuntos);
    }

    public List<ConceptosUsoPuntos> findAll() {
        try {
            Query q = this.em.createNamedQuery("ConceptosUsoPuntos.findAll", ConceptosUsoPuntos.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("ConceptosUsoPuntosDAO.findAll: " + e.getMessage());
        }
        return null;
    }

    public ConceptosUsoPuntos findById(Integer id) {
        try {
            Query q = this.em.createNamedQuery("ConceptosUsoPuntos.findById", ConceptosUsoPuntos.class);
            q.setParameter("id", id);
            return (ConceptosUsoPuntos)q.getSingleResult();
        } catch (Exception e) {
            System.out.println("ConceptosUsoPuntosDAO.findById: " + e.getMessage());
        }
        return null;
    }
    
    public boolean update(ConceptosUsoPuntos conceptosusopuntos) {
        try {
            ConceptosUsoPuntos c = findById(conceptosusopuntos.getId());
            if (c == null) {
                return false;
            }
            this.em.merge(conceptosusopuntos);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en update conceptosusopuntos:\n" + e.getMessage());
            return false;
        }
    }
    
    public boolean delete(Integer conceptosusopuntosId) {
        try {
            ConceptosUsoPuntos c = (ConceptosUsoPuntos) findById(conceptosusopuntosId);
            if (c == null) {
                return false;
            }
            this.em.remove(c);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en delete conceptosusopuntos:\n" + e.getMessage());
            return false;
        }
    }
}
