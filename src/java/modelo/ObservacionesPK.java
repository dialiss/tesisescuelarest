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
public class ObservacionesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_docente")
    private int idDocente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estudiante")
    private int idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;

    public ObservacionesPK() {
    }

    public ObservacionesPK(int idDocente, int idEstudiante, Date fechaHoraRegistro) {
        this.idDocente = idDocente;
        this.idEstudiante = idEstudiante;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDocente;
        hash += (int) idEstudiante;
        hash += (fechaHoraRegistro != null ? fechaHoraRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacionesPK)) {
            return false;
        }
        ObservacionesPK other = (ObservacionesPK) object;
        if (this.idDocente != other.idDocente) {
            return false;
        }
        if (this.idEstudiante != other.idEstudiante) {
            return false;
        }
        if ((this.fechaHoraRegistro == null && other.fechaHoraRegistro != null) || (this.fechaHoraRegistro != null && !this.fechaHoraRegistro.equals(other.fechaHoraRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ObservacionesPK[ idDocente=" + idDocente + ", idEstudiante=" + idEstudiante + ", fechaHoraRegistro=" + fechaHoraRegistro + " ]";
    }
    
}
