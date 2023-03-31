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
import py.com.backend.parcial1.dto.Respuesta;
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
        Respuesta resp = clienteDao.findAll();
        return  Response.status(resp.getCodigo()).entity(resp).build();
    }

    @GET
    @Path("/")
    public Response findById(@QueryParam(value = "id") Integer id) {
        System.out.println("id: " + id);
        Respuesta resp = clienteDao.findById(id);
        return  Response.status(resp.getCodigo()).entity(resp).build();
    }

    @GET
    @Path("/")
    public Response findByNombre(@QueryParam(value = "nombre") String nombre) {
        System.out.println("nombre: " + nombre);
        Respuesta resp = clienteDao.findByNombre(nombre);
        return  Response.status(resp.getCodigo()).entity(resp).build();
    }

    @GET
    @Path("/")
    public Response findByApellido(@QueryParam(value = "apellido") String apellido) {
        System.out.println("apellido: " + apellido);
        Respuesta resp = clienteDao.findByApellido(apellido);
        return  Response.status(resp.getCodigo()).entity(resp).build();
    }

    @GET
    @Path("/")
    public Response findByFechaNacimiento(@QueryParam(value = "fechaNacDesde") String fechaNacDesde, @QueryParam(value = "fechaNacHasta") String fechaNacHasta) {
        System.out.println("fechaNacDesde: " + fechaNacDesde);
        System.out.println("fechaNacHasta: " + fechaNacHasta);
        Respuesta resp = clienteDao.findByFechaNacimiento(fechaNacDesde, fechaNacHasta);
        return  Response.status(resp.getCodigo()).entity(resp).build();
    }

    @POST
    @Path("/")
    public Response crear(Cliente cliente) {
        Respuesta resp = clienteDao.insertar(cliente);
        return  Response.status(resp.getCodigo()).entity(resp).build();
    }
    
    @PUT
    @Path("/")
    public Response actualizar(Cliente cliente) {
        System.out.println("cliente: " + cliente);
        Respuesta resp = clienteDao.update(cliente);
        return  Response.status(resp.getCodigo()).entity(resp).build();
    }
    
    @DELETE
    @Path("/")
    public Response delete(@QueryParam(value = "id") Integer id) {
        System.out.println("cliente: " + id);
        Respuesta resp = clienteDao.delete(id);
        return  Response.status(resp.getCodigo()).entity(resp).build();
    }
}
