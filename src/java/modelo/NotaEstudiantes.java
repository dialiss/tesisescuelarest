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
@Table(name = "nota_estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaEstudiantes.findAll", query = "SELECT n FROM NotaEstudiantes n"),
    @NamedQuery(name = "NotaEstudiantes.findByIdEstudiante", query = "SELECT n FROM NotaEstudiantes n WHERE n.notaEstudiantesPK.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "NotaEstudiantes.findByIdMateria", query = "SELECT n FROM NotaEstudiantes n WHERE n.notaEstudiantesPK.idMateria = :idMateria"),
    @NamedQuery(name = "NotaEstudiantes.findByNota", query = "SELECT n FROM NotaEstudiantes n WHERE n.nota = :nota"),
    @NamedQuery(name = "NotaEstudiantes.findByFechaHoraRegistro", query = "SELECT n FROM NotaEstudiantes n WHERE n.fechaHoraRegistro = :fechaHoraRegistro")})
public class NotaEstudiantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotaEstudiantesPK notaEstudiantesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private long nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @JoinColumn(name = "id_docente", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idDocente;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materias materias;

    public NotaEstudiantes() {
    }

    public NotaEstudiantes(NotaEstudiantesPK notaEstudiantesPK) {
        this.notaEstudiantesPK = notaEstudiantesPK;
    }

    public NotaEstudiantes(NotaEstudiantesPK notaEstudiantesPK, long nota, Date fechaHoraRegistro) {
        this.notaEstudiantesPK = notaEstudiantesPK;
        this.nota = nota;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public NotaEstudiantes(int idEstudiante, int idMateria) {
        this.notaEstudiantesPK = new NotaEstudiantesPK(idEstudiante, idMateria);
    }

    public NotaEstudiantesPK getNotaEstudiantesPK() {
        return notaEstudiantesPK;
    }

    public void setNotaEstudiantesPK(NotaEstudiantesPK notaEstudiantesPK) {
        this.notaEstudiantesPK = notaEstudiantesPK;
    }

    public long getNota() {
        return nota;
    }

    public void setNota(long nota) {
        this.nota = nota;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Usuarios getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Usuarios idDocente) {
        this.idDocente = idDocente;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
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
        hash += (notaEstudiantesPK != null ? notaEstudiantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaEstudiantes)) {
            return false;
        }
        NotaEstudiantes other = (NotaEstudiantes) object;
        if ((this.notaEstudiantesPK == null && other.notaEstudiantesPK != null) || (this.notaEstudiantesPK != null && !this.notaEstudiantesPK.equals(other.notaEstudiantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.NotaEstudiantes[ notaEstudiantesPK=" + notaEstudiantesPK + " ]";
    }
    
}
