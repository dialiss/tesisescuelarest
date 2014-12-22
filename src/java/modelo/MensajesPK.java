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
public class MensajesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_envia")
    private int idEnvia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_recibe")
    private int idRecibe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEnvio;

    public MensajesPK() {
    }

    public MensajesPK(int idEnvia, int idRecibe, Date fechaHoraEnvio) {
        this.idEnvia = idEnvia;
        this.idRecibe = idRecibe;
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    public int getIdEnvia() {
        return idEnvia;
    }

    public void setIdEnvia(int idEnvia) {
        this.idEnvia = idEnvia;
    }

    public int getIdRecibe() {
        return idRecibe;
    }

    public void setIdRecibe(int idRecibe) {
        this.idRecibe = idRecibe;
    }

    public Date getFechaHoraEnvio() {
        return fechaHoraEnvio;
    }

    public void setFechaHoraEnvio(Date fechaHoraEnvio) {
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEnvia;
        hash += (int) idRecibe;
        hash += (fechaHoraEnvio != null ? fechaHoraEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MensajesPK)) {
            return false;
        }
        MensajesPK other = (MensajesPK) object;
        if (this.idEnvia != other.idEnvia) {
            return false;
        }
        if (this.idRecibe != other.idRecibe) {
            return false;
        }
        if ((this.fechaHoraEnvio == null && other.fechaHoraEnvio != null) || (this.fechaHoraEnvio != null && !this.fechaHoraEnvio.equals(other.fechaHoraEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MensajesPK[ idEnvia=" + idEnvia + ", idRecibe=" + idRecibe + ", fechaHoraEnvio=" + fechaHoraEnvio + " ]";
    }
    
}
