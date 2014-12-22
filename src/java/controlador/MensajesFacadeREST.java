/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;
import modelo.Mensajes;
import modelo.MensajesPK;

/**
 *
 * @author Luis Zozoranga
 */
@Stateless
@Path("modelo.mensajes")
public class MensajesFacadeREST extends AbstractFacade<Mensajes> {
    @PersistenceContext(unitName = "TesisEscuelaRestPU")
    private EntityManager em;

    private MensajesPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idEnvia=idEnviaValue;idRecibe=idRecibeValue;fechaHoraEnvio=fechaHoraEnvioValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        modelo.MensajesPK key = new modelo.MensajesPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idEnvia = map.get("idEnvia");
        if (idEnvia != null && !idEnvia.isEmpty()) {
            key.setIdEnvia(new java.lang.Integer(idEnvia.get(0)));
        }
        java.util.List<String> idRecibe = map.get("idRecibe");
        if (idRecibe != null && !idRecibe.isEmpty()) {
            key.setIdRecibe(new java.lang.Integer(idRecibe.get(0)));
        }
        java.util.List<String> fechaHoraEnvio = map.get("fechaHoraEnvio");
        if (fechaHoraEnvio != null && !fechaHoraEnvio.isEmpty()) {
            key.setFechaHoraEnvio(new java.util.Date(fechaHoraEnvio.get(0)));
        }
        return key;
    }

    public MensajesFacadeREST() {
        super(Mensajes.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Mensajes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Mensajes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        modelo.MensajesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Mensajes find(@PathParam("id") PathSegment id) {
        modelo.MensajesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Mensajes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Mensajes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
