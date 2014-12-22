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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "calendario_general")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarioGeneral.findAll", query = "SELECT c FROM CalendarioGeneral c"),
    @NamedQuery(name = "CalendarioGeneral.findByIdCalendarioGeneral", query = "SELECT c FROM CalendarioGeneral c WHERE c.idCalendarioGeneral = :idCalendarioGeneral"),
    @NamedQuery(name = "CalendarioGeneral.findByIdUsuario", query = "SELECT c FROM CalendarioGeneral c WHERE c.idUsuario = :idUsuario"),
    @NamedQuery(name = "CalendarioGeneral.findByFecha", query = "SELECT c FROM CalendarioGeneral c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CalendarioGeneral.findByActividad", query = "SELECT c FROM CalendarioGeneral c WHERE c.actividad = :actividad"),
    @NamedQuery(name = "CalendarioGeneral.findByFechaHoraRegistro", query = "SELECT c FROM CalendarioGeneral c WHERE c.fechaHoraRegistro = :fechaHoraRegistro")})
public class CalendarioGeneral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calendario_general")
    private Integer idCalendarioGeneral;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "actividad")
    private String actividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @JoinColumn(name = "id_calendario_general", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public CalendarioGeneral() {
    }

    public CalendarioGeneral(Integer idCalendarioGeneral) {
        this.idCalendarioGeneral = idCalendarioGeneral;
    }

    public CalendarioGeneral(Integer idCalendarioGeneral, int idUsuario, String fecha, String actividad, Date fechaHoraRegistro) {
        this.idCalendarioGeneral = idCalendarioGeneral;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.actividad = actividad;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Integer getIdCalendarioGeneral() {
        return idCalendarioGeneral;
    }

    public void setIdCalendarioGeneral(Integer idCalendarioGeneral) {
        this.idCalendarioGeneral = idCalendarioGeneral;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalendarioGeneral != null ? idCalendarioGeneral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarioGeneral)) {
            return false;
        }
        CalendarioGeneral other = (CalendarioGeneral) object;
        if ((this.idCalendarioGeneral == null && other.idCalendarioGeneral != null) || (this.idCalendarioGeneral != null && !this.idCalendarioGeneral.equals(other.idCalendarioGeneral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CalendarioGeneral[ idCalendarioGeneral=" + idCalendarioGeneral + " ]";
    }
    
}
