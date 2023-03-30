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
import py.com.backend.parcial1.ejb.ParametrizacionVencimientosPuntosDAO;
import py.com.backend.parcial1.model.ParametrizacionVencimientosPuntos;

/**
 *
 * @author macro
 */
@Path("parametrizacionvencimientospuntos")
@Consumes("application/json")
@Produces("application/json")
public class ParametrizacionVencimientosPuntosRest {

    @Inject
    private ParametrizacionVencimientosPuntosDAO pvpDao;

    @GET
    @Path("/")
    public Response findAll() {
        return Response.ok(pvpDao.findAll()).build();
    }

    @GET
    @Path("/")
    public Response findById(@QueryParam(value = "id") Integer id) {
        System.out.println("id: " + id);
        return Response.ok(pvpDao.findById(id)).build();
    }

    @POST
    @Path("/")
    public Response crear(ParametrizacionVencimientosPuntos pvp) {
        pvpDao.insertar(pvp);
        return Response.ok().build();
    }
    
    @PUT
    @Path("/")
    public Response actualizar(ParametrizacionVencimientosPuntos pvp) {
        System.out.println("parametrizacionvencimientospuntos: " + pvp);
        return pvpDao.update(pvp) ? Response.ok().build() : Response.notModified().build();
    }
    
    @DELETE
    @Path("/")
    public Response delete(@QueryParam(value = "id") Integer id) {
        System.out.println("parametrizacionvencimientospuntos: " + id);
        return pvpDao.delete(id) ? Response.ok().build() : Response.notModified().build();
    }
}
