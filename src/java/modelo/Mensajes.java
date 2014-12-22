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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Zozoranga
 */
@Entity
@Table(name = "mensajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m"),
    @NamedQuery(name = "Mensajes.findByIdEnvia", query = "SELECT m FROM Mensajes m WHERE m.mensajesPK.idEnvia = :idEnvia"),
    @NamedQuery(name = "Mensajes.findByIdRecibe", query = "SELECT m FROM Mensajes m WHERE m.mensajesPK.idRecibe = :idRecibe"),
    @NamedQuery(name = "Mensajes.findByMensaje", query = "SELECT m FROM Mensajes m WHERE m.mensaje = :mensaje"),
    @NamedQuery(name = "Mensajes.findByFechaHoraEnvio", query = "SELECT m FROM Mensajes m WHERE m.mensajesPK.fechaHoraEnvio = :fechaHoraEnvio")})
public class Mensajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MensajesPK mensajesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mensaje")
    private String mensaje;
    @JoinColumn(name = "id_envia", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "id_recibe", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios1;

    public Mensajes() {
    }

    public Mensajes(MensajesPK mensajesPK) {
        this.mensajesPK = mensajesPK;
    }

    public Mensajes(MensajesPK mensajesPK, String mensaje) {
        this.mensajesPK = mensajesPK;
        this.mensaje = mensaje;
    }

    public Mensajes(int idEnvia, int idRecibe, Date fechaHoraEnvio) {
        this.mensajesPK = new MensajesPK(idEnvia, idRecibe, fechaHoraEnvio);
    }

    public MensajesPK getMensajesPK() {
        return mensajesPK;
    }

    public void setMensajesPK(MensajesPK mensajesPK) {
        this.mensajesPK = mensajesPK;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        hash += (mensajesPK != null ? mensajesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.mensajesPK == null && other.mensajesPK != null) || (this.mensajesPK != null && !this.mensajesPK.equals(other.mensajesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Mensajes[ mensajesPK=" + mensajesPK + " ]";
    }
    
}
