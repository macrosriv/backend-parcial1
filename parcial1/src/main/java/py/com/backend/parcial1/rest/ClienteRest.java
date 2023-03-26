/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.backend.parcial1.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Response listar() {
        return Response.ok(clienteDao.listar()).build();
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
        //clienteDao.update(cliente);
        return Response.ok().build();
    }
}
