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
import modelo.Observaciones;
import modelo.ObservacionesPK;

/**
 *
 * @author Luis Zozoranga
 */
@Stateless
@Path("modelo.observaciones")
public class ObservacionesFacadeREST extends AbstractFacade<Observaciones> {
    @PersistenceContext(unitName = "TesisEscuelaRestPU")
    private EntityManager em;

    private ObservacionesPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idDocente=idDocenteValue;idEstudiante=idEstudianteValue;fechaHoraRegistro=fechaHoraRegistroValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        modelo.ObservacionesPK key = new modelo.ObservacionesPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idDocente = map.get("idDocente");
        if (idDocente != null && !idDocente.isEmpty()) {
            key.setIdDocente(new java.lang.Integer(idDocente.get(0)));
        }
        java.util.List<String> idEstudiante = map.get("idEstudiante");
        if (idEstudiante != null && !idEstudiante.isEmpty()) {
            key.setIdEstudiante(new java.lang.Integer(idEstudiante.get(0)));
        }
        java.util.List<String> fechaHoraRegistro = map.get("fechaHoraRegistro");
        if (fechaHoraRegistro != null && !fechaHoraRegistro.isEmpty()) {
            key.setFechaHoraRegistro(new java.util.Date(fechaHoraRegistro.get(0)));
        }
        return key;
    }

    public ObservacionesFacadeREST() {
        super(Observaciones.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Observaciones entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Observaciones entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        modelo.ObservacionesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Observaciones find(@PathParam("id") PathSegment id) {
        modelo.ObservacionesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Observaciones> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Observaciones> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
