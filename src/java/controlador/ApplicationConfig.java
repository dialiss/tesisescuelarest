/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Luis Zozoranga
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(controlador.ActividadesFacadeREST.class);
        resources.add(controlador.AsistenciasFacadeREST.class);
        resources.add(controlador.CalendarioGeneralFacadeREST.class);
        resources.add(controlador.MaterialDidacticosFacadeREST.class);
        resources.add(controlador.MateriasFacadeREST.class);
        resources.add(controlador.MensajesFacadeREST.class);
        resources.add(controlador.NotaEstudiantesFacadeREST.class);
        resources.add(controlador.ObservacionesFacadeREST.class);
        resources.add(controlador.RolesFacadeREST.class);
        resources.add(controlador.TareasFacadeREST.class);
        resources.add(controlador.UsuariosFacadeREST.class);
    }
    
}
