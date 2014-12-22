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
import modelo.NotaEstudiantes;
import modelo.NotaEstudiantesPK;

/**
 *
 * @author Luis Zozoranga
 */
@Stateless
@Path("modelo.notaestudiantes")
public class NotaEstudiantesFacadeREST extends AbstractFacade<NotaEstudiantes> {
    @PersistenceContext(unitName = "TesisEscuelaRestPU")
    private EntityManager em;

    private NotaEstudiantesPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idEstudiante=idEstudianteValue;idMateria=idMateriaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        modelo.NotaEstudiantesPK key = new modelo.NotaEstudiantesPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idEstudiante = map.get("idEstudiante");
        if (idEstudiante != null && !idEstudiante.isEmpty()) {
            key.setIdEstudiante(new java.lang.Integer(idEstudiante.get(0)));
        }
        java.util.List<String> idMateria = map.get("idMateria");
        if (idMateria != null && !idMateria.isEmpty()) {
            key.setIdMateria(new java.lang.Integer(idMateria.get(0)));
        }
        return key;
    }

    public NotaEstudiantesFacadeREST() {
        super(NotaEstudiantes.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(NotaEstudiantes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, NotaEstudiantes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        modelo.NotaEstudiantesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public NotaEstudiantes find(@PathParam("id") PathSegment id) {
        modelo.NotaEstudiantesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<NotaEstudiantes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<NotaEstudiantes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
