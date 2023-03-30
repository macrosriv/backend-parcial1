/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import py.com.backend.parcial1.ejb.ClienteDAO;
import py.com.backend.parcial1.model.Cliente;

/**
 *
 * @author macro
 */
@Path("cliente")
@Consumes("application/json")
@Produces("application/json")
public class ClienteRest {

    @Inject
    private ClienteDAO clienteDao;

    @GET
    @Path("/")
    public Response findAll() {
        return Response.ok(clienteDao.findAll()).build();
    }

    @GET
    @Path("/")
    public Response findById(@QueryParam(value = "id") Integer id) {
        System.out.println("id: " + id);
        return Response.ok(clienteDao.findById(id)).build();
    }

    @GET
    @Path("/")
    public Response findByNombre(@QueryParam(value = "nombre") String nombre) {
        System.out.println("nombre: " + nombre);
        return Response.ok(clienteDao.findByNombre(nombre)).build();
    }

    @GET
    @Path("/")
    public Response findByApellido(@QueryParam(value = "apellido") String apellido) {
        System.out.println("apellido: " + apellido);
        return Response.ok(clienteDao.findByApellido(apellido)).build();
    }

    @GET
    @Path("/")
    public Response findByFechaNacimiento(@QueryParam(value = "fechaNacDesde") String fechaNacDesde, @QueryParam(value = "fechaNacHasta") String fechaNacHasta) {
        System.out.println("fechaNacDesde: " + fechaNacDesde);
        System.out.println("fechaNacHasta: " + fechaNacHasta);
        return Response.ok(clienteDao.findByFechaNacimiento(fechaNacDesde, fechaNacHasta)).build();
    }

    @POST
    @Path("/")
    public Response crear(Cliente cliente) {
        clienteDao.insertar(cliente);
        return Response.ok().build();
    }
    
    @PUT
    @Path("/")
    public Response actualizar(Cliente cliente) {
        System.out.println("cliente: " + cliente);
        return clienteDao.update(cliente) ? Response.ok().build() : Response.notModified().build();
    }
    
    @DELETE
    @Path("/")
    public Response delete(@QueryParam(value = "id") Integer id) {
        System.out.println("cliente: " + id);
        return clienteDao.delete(id) ? Response.ok().build() : Response.notModified().build();
    }
}
