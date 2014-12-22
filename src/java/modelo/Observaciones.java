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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Zozoranga
 */
@Entity
@Table(name = "observaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observaciones.findAll", query = "SELECT o FROM Observaciones o"),
    @NamedQuery(name = "Observaciones.findByIdDocente", query = "SELECT o FROM Observaciones o WHERE o.observacionesPK.idDocente = :idDocente"),
    @NamedQuery(name = "Observaciones.findByIdEstudiante", query = "SELECT o FROM Observaciones o WHERE o.observacionesPK.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Observaciones.findByObservacion", query = "SELECT o FROM Observaciones o WHERE o.observacion = :observacion"),
    @NamedQuery(name = "Observaciones.findByFecha", query = "SELECT o FROM Observaciones o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Observaciones.findByFechaHoraRegistro", query = "SELECT o FROM Observaciones o WHERE o.observacionesPK.fechaHoraRegistro = :fechaHoraRegistro")})
public class Observaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservacionesPK observacionesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_docente", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios1;

    public Observaciones() {
    }

    public Observaciones(ObservacionesPK observacionesPK) {
        this.observacionesPK = observacionesPK;
    }

    public Observaciones(ObservacionesPK observacionesPK, String observacion, Date fecha) {
        this.observacionesPK = observacionesPK;
        this.observacion = observacion;
        this.fecha = fecha;
    }

    public Observaciones(int idDocente, int idEstudiante, Date fechaHoraRegistro) {
        this.observacionesPK = new ObservacionesPK(idDocente, idEstudiante, fechaHoraRegistro);
    }

    public ObservacionesPK getObservacionesPK() {
        return observacionesPK;
    }

    public void setObservacionesPK(ObservacionesPK observacionesPK) {
        this.observacionesPK = observacionesPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observacionesPK != null ? observacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observaciones)) {
            return false;
        }
        Observaciones other = (Observaciones) object;
        if ((this.observacionesPK == null && other.observacionesPK != null) || (this.observacionesPK != null && !this.observacionesPK.equals(other.observacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Observaciones[ observacionesPK=" + observacionesPK + " ]";
    }
    
}
