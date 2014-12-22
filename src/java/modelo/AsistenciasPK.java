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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Luis Zozoranga
 */
@Embeddable
public class AsistenciasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estudiante")
    private int idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia")
    private int idMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_docente")
    private int idDocente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public AsistenciasPK() {
    }

    public AsistenciasPK(int idEstudiante, int idMateria, int idDocente, Date fecha) {
        this.idEstudiante = idEstudiante;
        this.idMateria = idMateria;
        this.idDocente = idDocente;
        this.fecha = fecha;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEstudiante;
        hash += (int) idMateria;
        hash += (int) idDocente;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciasPK)) {
            return false;
        }
        AsistenciasPK other = (AsistenciasPK) object;
        if (this.idEstudiante != other.idEstudiante) {
            return false;
        }
        if (this.idMateria != other.idMateria) {
            return false;
        }
        if (this.idDocente != other.idDocente) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsistenciasPK[ idEstudiante=" + idEstudiante + ", idMateria=" + idMateria + ", idDocente=" + idDocente + ", fecha=" + fecha + " ]";
    }
    
}
