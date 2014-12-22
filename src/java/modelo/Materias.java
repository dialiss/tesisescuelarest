/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Zozoranga
 */
@Entity
@Table(name = "materias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m"),
    @NamedQuery(name = "Materias.findByIdMateria", query = "SELECT m FROM Materias m WHERE m.idMateria = :idMateria"),
    @NamedQuery(name = "Materias.findByMateria", query = "SELECT m FROM Materias m WHERE m.materia = :materia"),
    @NamedQuery(name = "Materias.findByDescripcion", query = "SELECT m FROM Materias m WHERE m.descripcion = :descripcion")})
public class Materias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia")
    private Integer idMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "materia")
    private String materia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private List<MaterialDidacticos> materialDidacticosList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "materias")
    private Actividades actividades;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materias")
    private List<NotaEstudiantes> notaEstudiantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private List<Tareas> tareasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materias")
    private List<Asistencias> asistenciasList;

    public Materias() {
    }

    public Materias(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Materias(Integer idMateria, String materia, String descripcion) {
        this.idMateria = idMateria;
        this.materia = materia;
        this.descripcion = descripcion;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<MaterialDidacticos> getMaterialDidacticosList() {
        return materialDidacticosList;
    }

    public void setMaterialDidacticosList(List<MaterialDidacticos> materialDidacticosList) {
        this.materialDidacticosList = materialDidacticosList;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    @XmlTransient
    public List<NotaEstudiantes> getNotaEstudiantesList() {
        return notaEstudiantesList;
    }

    public void setNotaEstudiantesList(List<NotaEstudiantes> notaEstudiantesList) {
        this.notaEstudiantesList = notaEstudiantesList;
    }

    @XmlTransient
    public List<Tareas> getTareasList() {
        return tareasList;
    }

    public void setTareasList(List<Tareas> tareasList) {
        this.tareasList = tareasList;
    }

    @XmlTransient
    public List<Asistencias> getAsistenciasList() {
        return asistenciasList;
    }

    public void setAsistenciasList(List<Asistencias> asistenciasList) {
        this.asistenciasList = asistenciasList;
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
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Materias[ idMateria=" + idMateria + " ]";
    }
    
}
