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
import py.com.backend.parcial1.model.ParametrizacionVencimientosPuntos;

/**
 *
 * @author macro
 */
@Stateless
public class ParametrizacionVencimientosPuntosDAO {

    @PersistenceContext(unitName = "parcial1PU")
    private EntityManager em;

    public void insertar(ParametrizacionVencimientosPuntos parametrizacionvencimientospuntos) {
        this.em.persist(parametrizacionvencimientospuntos);
    }

    public List<ParametrizacionVencimientosPuntos> findAll() {
        try {
            Query q = this.em.createNamedQuery("ParametrizacionVencimientosPuntos.findAll", ParametrizacionVencimientosPuntos.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("ParametrizacionVencimientosPuntosDAO.findAll: " + e.getMessage());
        }
        return null;
    }

    public ParametrizacionVencimientosPuntos findById(Integer id) {
        try {
            Query q = this.em.createNamedQuery("ParametrizacionVencimientosPuntos.findById", ParametrizacionVencimientosPuntos.class);
            q.setParameter("id", id);
            return (ParametrizacionVencimientosPuntos)q.getSingleResult();
        } catch (Exception e) {
            System.out.println("ParametrizacionVencimientosPuntosDAO.findById: " + e.getMessage());
        }
        return null;
    }
    
    public boolean update(ParametrizacionVencimientosPuntos parametrizacionvencimientospuntos) {
        try {
            ParametrizacionVencimientosPuntos c = findById(parametrizacionvencimientospuntos.getId());
            if (c == null) {
                return false;
            }
            this.em.merge(parametrizacionvencimientospuntos);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en update parametrizacionvencimientospuntos:\n" + e.getMessage());
            return false;
        }
    }
    
    public boolean delete(Integer parametrizacionvencimientospuntosId) {
        try {
            ParametrizacionVencimientosPuntos c = (ParametrizacionVencimientosPuntos) findById(parametrizacionvencimientospuntosId);
            if (c == null) {
                return false;
            }
            this.em.remove(c);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en delete parametrizacionvencimientospuntos:\n" + e.getMessage());
            return false;
        }
    }
}
