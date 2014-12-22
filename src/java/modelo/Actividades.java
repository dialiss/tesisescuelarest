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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Zozoranga
 */
@Entity
@Table(name = "actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a"),
    @NamedQuery(name = "Actividades.findByIdMateria", query = "SELECT a FROM Actividades a WHERE a.idMateria = :idMateria"),
    @NamedQuery(name = "Actividades.findByFecha", query = "SELECT a FROM Actividades a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Actividades.findByActividad", query = "SELECT a FROM Actividades a WHERE a.actividad = :actividad"),
    @NamedQuery(name = "Actividades.findByFechaHoraRegistro", query = "SELECT a FROM Actividades a WHERE a.fechaHoraRegistro = :fechaHoraRegistro"),
    @NamedQuery(name = "Actividades.findByDireccionArchivo", query = "SELECT a FROM Actividades a WHERE a.direccionArchivo = :direccionArchivo")})
public class Actividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia")
    private Integer idMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "actividad")
    private String actividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion_archivo")
    private String direccionArchivo;
    @JoinColumn(name = "id_docente", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idDocente;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Materias materias;

    public Actividades() {
    }

    public Actividades(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Actividades(Integer idMateria, Date fecha, String actividad, Date fechaHoraRegistro, String direccionArchivo) {
        this.idMateria = idMateria;
        this.fecha = fecha;
        this.actividad = actividad;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.direccionArchivo = direccionArchivo;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public String getDireccionArchivo() {
        return direccionArchivo;
    }

    public void setDireccionArchivo(String direccionArchivo) {
        this.direccionArchivo = direccionArchivo;
    }

    public Usuarios getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Usuarios idDocente) {
        this.idDocente = idDocente;
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
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Actividades[ idMateria=" + idMateria + " ]";
    }
    
}
