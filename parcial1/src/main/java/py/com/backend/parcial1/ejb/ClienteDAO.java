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
import py.com.backend.parcial1.dto.Respuesta;
import py.com.backend.parcial1.model.Cliente;

/**
 *
 * @author macro
 */
@Stateless
public class ClienteDAO {

    @PersistenceContext(unitName = "parcial1PU")
    private EntityManager em;

    public Respuesta insertar(Cliente cliente) {
        try {
            this.em.persist(cliente);
            return new Respuesta(Boolean.TRUE, 200, cliente);
        } catch (Exception e) {
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }

    public Respuesta findAll() {
        try {
            Query q = this.em.createNamedQuery("Cliente.findAll", Cliente.class);
            return new Respuesta(Boolean.TRUE, 200, (List<Cliente>) q.getResultList());
        } catch (Exception e) {
            System.out.println("ClienteDAO.findAll: " + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }

    public Respuesta findById(Integer id) {
        try {
            Query q = this.em.createNamedQuery("Cliente.findById", Cliente.class);
            q.setParameter("id", id);
            return new Respuesta(Boolean.TRUE, 200, (Cliente) q.getSingleResult());
        } catch (Exception e) {
            System.out.println("ClienteDAO.findById: " + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }

    public Respuesta findByNombre(String nombre) {
        try {
            Query q = this.em.createNamedQuery("Cliente.findByNombre", Cliente.class);
            q.setParameter("nombre", "%" + nombre + "%");
            return new Respuesta(Boolean.TRUE, 200, (List<Cliente>) q.getResultList());
        } catch (Exception e) {
            System.out.println("ClienteDAO.findByNombre: " + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }

    public Respuesta findByApellido(String apellido) {
        try {
            Query q = this.em.createNamedQuery("Cliente.findByApellido", Cliente.class);
            q.setParameter("apellido", "%" + apellido + "%");
            return new Respuesta(Boolean.TRUE, 200, (List<Cliente>) q.getResultList());
        } catch (Exception e) {
            System.out.println("ClienteDAO.findByApellido: " + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }

    public Respuesta findByFechaNacimiento(String desde, String hasta) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Query q = this.em.createNamedQuery("Cliente.findByFechaNacimiento", Cliente.class);
            q.setParameter("desde", sdf.parse(desde));
            q.setParameter("hasta", sdf.parse(hasta));
            return new Respuesta(Boolean.TRUE, 200, (List<Cliente>) q.getResultList());
        } catch (ParseException e) {
            System.out.println("ClienteDAO.findByFechaNacimiento: " + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }
    
    public Respuesta update(Cliente cliente) {
        try {
            Respuesta respCliente = findById(cliente.getId());
            if (!respCliente.getExito()) {
                return new Respuesta(Boolean.FALSE, 500, "Cliente no existe");
            }
            this.em.merge((Cliente) respCliente.getMensaje());
            return new Respuesta(Boolean.TRUE, 200, "Cliente Actualizado");
        } catch (Exception e) {
            System.out.println("Excepcion en update cliente:\n" + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }
    
    public Respuesta delete(Integer clienteId) {
        try {
            Respuesta respCliente = findById(clienteId);
            if (!respCliente.getExito()) {
                return new Respuesta(Boolean.FALSE, 500, "Cliente no existe");
            }
            this.em.remove((Cliente) respCliente.getMensaje());
            return new Respuesta(Boolean.TRUE, 200, "Cliente Eliminado");
        } catch (Exception e) {
            System.out.println("Excepcion en delete cliente:\n" + e.getMessage());
            return new Respuesta(Boolean.FALSE, 500, e.getMessage());
        }
    }
}
