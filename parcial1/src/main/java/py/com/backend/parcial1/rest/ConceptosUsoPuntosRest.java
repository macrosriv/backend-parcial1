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
import py.com.backend.parcial1.ejb.ConceptosUsoPuntosDAO;
import py.com.backend.parcial1.model.ConceptosUsoPuntos;

/**
 *
 * @author macro
 */
@Path("conceptosusopuntos")
@Consumes("application/json")
@Produces("application/json")
public class ConceptosUsoPuntosRest {

    @Inject
    private ConceptosUsoPuntosDAO conceptosusopuntosDao;

    @GET
    @Path("/")
    public Response findAll() {
        return Response.ok(conceptosusopuntosDao.findAll()).build();
    }

    @GET
    @Path("/")
    public Response findById(@QueryParam(value = "id") Integer id) {
        System.out.println("id: " + id);
        return Response.ok(conceptosusopuntosDao.findById(id)).build();
    }

    @POST
    @Path("/")
    public Response crear(ConceptosUsoPuntos cup) {
        conceptosusopuntosDao.insertar(cup);
        return Response.ok().build();
    }
    
    @PUT
    @Path("/")
    public Response actualizar(ConceptosUsoPuntos cup) {
        System.out.println("conceptosusopuntos: " + cup);
        return conceptosusopuntosDao.update(cup) ? Response.ok().build() : Response.notModified().build();
    }
    
    @DELETE
    @Path("/")
    public Response delete(@QueryParam(value = "id") Integer id) {
        System.out.println("conceptosusopuntos: " + id);
        return conceptosusopuntosDao.delete(id) ? Response.ok().build() : Response.notModified().build();
    }
}
