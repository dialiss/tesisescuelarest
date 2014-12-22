/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Zozoranga
 */
@Entity
@Table(name = "tareas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tareas.findAll", query = "SELECT t FROM Tareas t"),
    @NamedQuery(name = "Tareas.findByIdDocente", query = "SELECT t FROM Tareas t WHERE t.idDocente = :idDocente"),
    @NamedQuery(name = "Tareas.findByFechaEnvio", query = "SELECT t FROM Tareas t WHERE t.fechaEnvio = :fechaEnvio"),
    @NamedQuery(name = "Tareas.findByFechaEntrega", query = "SELECT t FROM Tareas t WHERE t.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Tareas.findByTareaDocente", query = "SELECT t FROM Tareas t WHERE t.tareaDocente = :tareaDocente"),
    @NamedQuery(name = "Tareas.findByArchivoTarea", query = "SELECT t FROM Tareas t WHERE t.archivoTarea = :archivoTarea"),
    @NamedQuery(name = "Tareas.findByEstadoEnviado", query = "SELECT t FROM Tareas t WHERE t.estadoEnviado = :estadoEnviado"),
    @NamedQuery(name = "Tareas.findByCalificacion", query = "SELECT t FROM Tareas t WHERE t.calificacion = :calificacion"),
    @NamedQuery(name = "Tareas.findByEstadoCalificado", query = "SELECT t FROM Tareas t WHERE t.estadoCalificado = :estadoCalificado"),
    @NamedQuery(name = "Tareas.findByTareaEstudiante", query = "SELECT t FROM Tareas t WHERE t.tareaEstudiante = :tareaEstudiante"),
    @NamedQuery(name = "Tareas.findByComentario", query = "SELECT t FROM Tareas t WHERE t.comentario = :comentario")})
public class Tareas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_docente")
    private Integer idDocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_envio")
    private String fechaEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_entrega")
    private String fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tarea_docente")
    private String tareaDocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "archivo_tarea")
    private String archivoTarea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_enviado")
    private int estadoEnviado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private long calificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_calificado")
    private int estadoCalificado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tarea_estudiante")
    private String tareaEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "id_docente", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idEstudiante;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne(optional = false)
    private Materias idMateria;

    public Tareas() {
    }

    public Tareas(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Tareas(Integer idDocente, String fechaEnvio, String fechaEntrega, String tareaDocente, String archivoTarea, int estadoEnviado, long calificacion, int estadoCalificado, String tareaEstudiante, String comentario) {
        this.idDocente = idDocente;
        this.fechaEnvio = fechaEnvio;
        this.fechaEntrega = fechaEntrega;
        this.tareaDocente = tareaDocente;
        this.archivoTarea = archivoTarea;
        this.estadoEnviado = estadoEnviado;
        this.calificacion = calificacion;
        this.estadoCalificado = estadoCalificado;
        this.tareaEstudiante = tareaEstudiante;
        this.comentario = comentario;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getTareaDocente() {
        return tareaDocente;
    }

    public void setTareaDocente(String tareaDocente) {
        this.tareaDocente = tareaDocente;
    }

    public String getArchivoTarea() {
        return archivoTarea;
    }

    public void setArchivoTarea(String archivoTarea) {
        this.archivoTarea = archivoTarea;
    }

    public int getEstadoEnviado() {
        return estadoEnviado;
    }

    public void setEstadoEnviado(int estadoEnviado) {
        this.estadoEnviado = estadoEnviado;
    }

    public long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(long calificacion) {
        this.calificacion = calificacion;
    }

    public int getEstadoCalificado() {
        return estadoCalificado;
    }

    public void setEstadoCalificado(int estadoCalificado) {
        this.estadoCalificado = estadoCalificado;
    }

    public String getTareaEstudiante() {
        return tareaEstudiante;
    }

    public void setTareaEstudiante(String tareaEstudiante) {
        this.tareaEstudiante = tareaEstudiante;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Usuarios idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Materias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materias idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocente != null ? idDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tareas)) {
            return false;
        }
        Tareas other = (Tareas) object;
        if ((this.idDocente == null && other.idDocente != null) || (this.idDocente != null && !this.idDocente.equals(other.idDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tareas[ idDocente=" + idDocente + " ]";
    }
    
}
