/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Zozoranga
 */
@Entity
@Table(name = "asistencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencias.findAll", query = "SELECT a FROM Asistencias a"),
    @NamedQuery(name = "Asistencias.findByIdEstudiante", query = "SELECT a FROM Asistencias a WHERE a.asistenciasPK.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Asistencias.findByIdMateria", query = "SELECT a FROM Asistencias a WHERE a.asistenciasPK.idMateria = :idMateria"),
    @NamedQuery(name = "Asistencias.findByIdDocente", query = "SELECT a FROM Asistencias a WHERE a.asistenciasPK.idDocente = :idDocente"),
    @NamedQuery(name = "Asistencias.findByFecha", query = "SELECT a FROM Asistencias a WHERE a.asistenciasPK.fecha = :fecha"),
    @NamedQuery(name = "Asistencias.findByAsistio", query = "SELECT a FROM Asistencias a WHERE a.asistio = :asistio"),
    @NamedQuery(name = "Asistencias.findByFechaHoraRegistro", query = "SELECT a FROM Asistencias a WHERE a.fechaHoraRegistro = :fechaHoraRegistro")})
public class Asistencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciasPK asistenciasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistio")
    private boolean asistio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @JoinColumn(name = "id_docente", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios1;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materias materias;

    public Asistencias() {
    }

    public Asistencias(AsistenciasPK asistenciasPK) {
        this.asistenciasPK = asistenciasPK;
    }

    public Asistencias(AsistenciasPK asistenciasPK, boolean asistio, Date fechaHoraRegistro) {
        this.asistenciasPK = asistenciasPK;
        this.asistio = asistio;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Asistencias(int idEstudiante, int idMateria, int idDocente, Date fecha) {
        this.asistenciasPK = new AsistenciasPK(idEstudiante, idMateria, idDocente, fecha);
    }

    public AsistenciasPK getAsistenciasPK() {
        return asistenciasPK;
    }

    public void setAsistenciasPK(AsistenciasPK asistenciasPK) {
        this.asistenciasPK = asistenciasPK;
    }

    public boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsuarios1() {
        return usuarios1;
    }

    public void setUsuarios1(Usuarios usuarios1) {
        this.usuarios1 = usuarios1;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciasPK != null ? asistenciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencias)) {
            return false;
        }
        Asistencias other = (Asistencias) object;
        if ((this.asistenciasPK == null && other.asistenciasPK != null) || (this.asistenciasPK != null && !this.asistenciasPK.equals(other.asistenciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Asistencias[ asistenciasPK=" + asistenciasPK + " ]";
    }
    
}
