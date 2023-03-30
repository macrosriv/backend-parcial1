/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import py.com.backend.parcial1.model.Cliente;

/**
 *
 * @author macro
 */
@Stateless
public class ClienteDAO {

    @PersistenceContext(unitName = "parcial1PU")
    private EntityManager em;

    public void insertar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public List<Cliente> findAll() {
        try {
            Query q = this.em.createNamedQuery("Cliente.findAll", Cliente.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("ClienteDAO.findAll: " + e.getMessage());
        }
        return null;
    }

    public Cliente findById(Integer id) {
        try {
            Query q = this.em.createNamedQuery("Cliente.findById", Cliente.class);
            q.setParameter("id", id);
            return (Cliente)q.getSingleResult();
        } catch (Exception e) {
            System.out.println("ClienteDAO.findById: " + e.getMessage());
        }
        return null;
    }

    public List<Cliente> findByNombre(String nombre) {
        try {
            Query q = this.em.createNamedQuery("Cliente.findByNombre", Cliente.class);
            q.setParameter("nombre", "%" + nombre + "%");
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("ClienteDAO.findByNombre: " + e.getMessage());
        }
        return null;
    }

    public List<Cliente> findByApellido(String apellido) {
        try {
            Query q = this.em.createNamedQuery("Cliente.findByApellido", Cliente.class);
            q.setParameter("apellido", "%" + apellido + "%");
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("ClienteDAO.findByApellido: " + e.getMessage());
        }
        return null;
    }

    public List<Cliente> findByFechaNacimiento(String desde, String hasta) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Query q = this.em.createNamedQuery("Cliente.findByFechaNacimiento", Cliente.class);
            q.setParameter("desde", sdf.parse(desde));
            q.setParameter("hasta", sdf.parse(hasta));
            return q.getResultList();
        } catch (ParseException e) {
            System.out.println("ClienteDAO.findByFechaNacimiento: " + e.getMessage());
        }
        return null;
    }
    
    public boolean update(Cliente cliente) {
        try {
            Cliente c = findById(cliente.getId());
            if (c == null) {
                return false;
            }
            this.em.merge(cliente);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en update cliente:\n" + e.getMessage());
            return false;
        }
    }
    
    public boolean delete(Integer clienteId) {
        try {
            Cliente c = (Cliente) findById(clienteId);
            if (c == null) {
                return false;
            }
            this.em.remove(c);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en delete cliente:\n" + e.getMessage());
            return false;
        }
    }
}
