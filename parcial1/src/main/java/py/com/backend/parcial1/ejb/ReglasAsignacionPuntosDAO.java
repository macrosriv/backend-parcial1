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
import py.com.backend.parcial1.model.ReglasAsignacionPuntos;

/**
 *
 * @author macro
 */
@Stateless
public class ReglasAsignacionPuntosDAO {

    @PersistenceContext(unitName = "parcial1PU")
    private EntityManager em;

    public void insertar(ReglasAsignacionPuntos reglasasignacionpuntos) {
        this.em.persist(reglasasignacionpuntos);
    }

    public List<ReglasAsignacionPuntos> findAll() {
        try {
            Query q = this.em.createNamedQuery("ReglasAsignacionPuntos.findAll", ReglasAsignacionPuntos.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("ReglasAsignacionPuntosDAO.findAll: " + e.getMessage());
        }
        return null;
    }

    public ReglasAsignacionPuntos findById(Integer id) {
        try {
            Query q = this.em.createNamedQuery("ReglasAsignacionPuntos.findById", ReglasAsignacionPuntos.class);
            q.setParameter("id", id);
            return (ReglasAsignacionPuntos)q.getSingleResult();
        } catch (Exception e) {
            System.out.println("ReglasAsignacionPuntosDAO.findById: " + e.getMessage());
        }
        return null;
    }
    
    public boolean update(ReglasAsignacionPuntos reglasasignacionpuntos) {
        try {
            ReglasAsignacionPuntos c = findById(reglasasignacionpuntos.getId());
            if (c == null) {
                return false;
            }
            this.em.merge(reglasasignacionpuntos);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en update reglasasignacionpuntos:\n" + e.getMessage());
            return false;
        }
    }
    
    public boolean delete(Integer reglasasignacionpuntosId) {
        try {
            ReglasAsignacionPuntos c = (ReglasAsignacionPuntos) findById(reglasasignacionpuntosId);
            if (c == null) {
                return false;
            }
            this.em.remove(c);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en delete reglasasignacionpuntos:\n" + e.getMessage());
            return false;
        }
    }
}
