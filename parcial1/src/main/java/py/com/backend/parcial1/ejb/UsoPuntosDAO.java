/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.backend.parcial1.dto.Respuesta;
import py.com.backend.parcial1.dto.UsoPuntosDTO;
import py.com.backend.parcial1.model.Cliente;
import py.com.backend.parcial1.model.ConceptosUsoPuntos;
import py.com.backend.parcial1.model.UsoPuntos;

/**
 *
 * @author macro
 */
@Stateless
public class UsoPuntosDAO {

    @PersistenceContext(unitName = "parcial1PU")
    private EntityManager em;
    
    @Inject
    ClienteDAO cDAO;
    @Inject
    ConceptosUsoPuntosDAO cupDAO;

    public Respuesta insertar(UsoPuntosDTO upd) {
        Respuesta resp = new Respuesta(true, 200, "");
        try {
            Respuesta respCliente = cDAO.findById(upd.getClienteId());
            if (!respCliente.getExito()) {
                respCliente.setMensaje("Cliente no encontrado");
                return respCliente;                        
            }
            Respuesta respConcepto = cupDAO.findById(upd.getConceptoId());
            if (!respConcepto.getExito()) {
                respConcepto.setMensaje("Concepto no encontrado");
                return respConcepto;                        
            }
            UsoPuntos up = new UsoPuntos();
            this.em.persist(up);
            resp.setMensaje(up);
            return resp;
        } catch (Exception e) {
            resp.setCodigo(500);
            resp.setMensaje(e.getMessage());
            System.out.println("UsoPuntosDAO.findAll: " + e.getMessage());
            return resp;
        }
    }

    public List<UsoPuntos> findAll() {
        try {
            Query q = this.em.createNamedQuery("UsoPuntos.findAll", UsoPuntos.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("UsoPuntosDAO.findAll: " + e.getMessage());
        }
        return null;
    }

    public UsoPuntos findById(Integer id) {
        try {
            Query q = this.em.createNamedQuery("UsoPuntos.findById", UsoPuntos.class);
            q.setParameter("id", id);
            return (UsoPuntos)q.getSingleResult();
        } catch (Exception e) {
            System.out.println("UsoPuntosDAO.findById: " + e.getMessage());
        }
        return null;
    }
    
    public boolean update(UsoPuntos usopuntos) {
        try {
            UsoPuntos c = findById(usopuntos.getId());
            if (c == null) {
                return false;
            }
            this.em.merge(usopuntos);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en update usopuntos:\n" + e.getMessage());
            return false;
        }
    }
    
    public boolean delete(Integer usopuntosId) {
        try {
            UsoPuntos c = (UsoPuntos) findById(usopuntosId);
            if (c == null) {
                return false;
            }
            this.em.remove(c);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en delete usopuntos:\n" + e.getMessage());
            return false;
        }
    }
}
