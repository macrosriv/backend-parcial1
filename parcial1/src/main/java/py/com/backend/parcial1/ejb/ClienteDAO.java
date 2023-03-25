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

    public List<Cliente> listar() {
        Query q = this.em.createQuery("select o from Cliente o");
        return (List<Cliente>) q.getResultList();
    }
    
    public boolean update(Cliente cliente) {
        try {
            this.em.merge(cliente);
            return true;
        } catch (Exception e) {
            System.out.println("Excepcion en update cliente:\n" + e.getMessage());
            return false;
        }
    }
}
