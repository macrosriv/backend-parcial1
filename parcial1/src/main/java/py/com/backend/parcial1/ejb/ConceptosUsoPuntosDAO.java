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
import py.com.backend.parcial1.dto.Respuesta;
import py.com.backend.parcial1.model.ConceptosUsoPuntos;

/**
 *
 * @author macro
 */
@Stateless
public class ConceptosUsoPuntosDAO {

    @PersistenceContext(unitName = "parcial1PU")
    private EntityManager em;

    public Respuesta insertar(ConceptosUsoPuntos conceptosusopuntos) {
        try {
            this.em.persist(conceptosusopuntos);
            return new Respuesta(Boolean.TRUE, 200, conceptosusopuntos);
        } catch (Exception e) {
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }

    public Respuesta findAll() {
        try {
            Query q = this.em.createNamedQuery("ConceptosUsoPuntos.findAll", ConceptosUsoPuntos.class);
            return new Respuesta(Boolean.TRUE, 200, (List<ConceptosUsoPuntos>) q.getResultList());
        } catch (Exception e) {
            System.out.println("ConceptosUsoPuntosDAO.findAll: " + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }

    public Respuesta findById(Integer id) {
        try {
            Query q = this.em.createNamedQuery("ConceptosUsoPuntos.findById", ConceptosUsoPuntos.class);
            q.setParameter("id", id);
            return new Respuesta(Boolean.TRUE, 200, (ConceptosUsoPuntos) q.getSingleResult());
        } catch (Exception e) {
            System.out.println("ConceptosUsoPuntosDAO.findById: " + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }
    
    public Respuesta update(ConceptosUsoPuntos conceptosusopuntos) {
        try {
            Respuesta respCup= findById(conceptosusopuntos.getId());
            if (!respCup.getExito()) {
                return new Respuesta(Boolean.FALSE, 500, "ConceptosUsoPuntos no existe");
            }
            this.em.merge(conceptosusopuntos);
            return new Respuesta(Boolean.TRUE, 200, "ConceptosUsoPuntos Actualizado");
        } catch (Exception e) {
            System.out.println("Excepcion en update conceptosusopuntos:\n" + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }
    
    public Respuesta delete(Integer conceptosusopuntosId) {
        try {
            Respuesta respConceptosUsoPuntos = findById(conceptosusopuntosId);
            if (!respConceptosUsoPuntos.getExito()) {
                return new Respuesta(Boolean.FALSE, 500, "ConceptosUsoPuntos no existe");
            }
            this.em.remove((ConceptosUsoPuntos) respConceptosUsoPuntos.getMensaje());
            return new Respuesta(Boolean.TRUE, 200, "ConceptosUsoPuntos Eliminado");
        } catch (Exception e) {
            System.out.println("Excepcion en delete conceptosusopuntos:\n" + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }
}
