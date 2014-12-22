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
import modelo.Roles;
import modelo.Usuarios;

/**
 *
 * @author Luis Zozoranga
 */
@Stateless
@Path("modelo.roles")
public class RolesFacadeREST extends AbstractFacade<Roles> {

    @PersistenceContext(unitName = "TesisEscuelaRestPU")
    private EntityManager em;

    public RolesFacadeREST() {
        super(Roles.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Roles entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Roles entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Roles find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json", "application/json"})
    public List<Roles> findAll() {
        return super.findAll();
    }

    @GET
    @Path("listar")
    @Produces({"application/json; charset=utf-8", "application/json"})
    public String listar() {
        String res = "[";
        List<Roles> roles = super.findAll();
        for (int i = 0; i < roles.size(); i++) {
            res += "['" + roles.get(i).getRol() + "','" + roles.get(i).getRol() + "],";
        }
        res+="]";
        return res;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Roles> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
