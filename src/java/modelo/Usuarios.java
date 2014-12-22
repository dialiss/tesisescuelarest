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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarios.findByCedula", query = "SELECT u FROM Usuarios u WHERE u.cedula = :cedula"),
    @NamedQuery(name = "Usuarios.findByClave", query = "SELECT u FROM Usuarios u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuarios.findByCelular", query = "SELECT u FROM Usuarios u WHERE u.celular = :celular"),
    @NamedQuery(name = "Usuarios.findByTelfConv", query = "SELECT u FROM Usuarios u WHERE u.telfConv = :telfConv"),
    @NamedQuery(name = "Usuarios.findByBloqueado", query = "SELECT u FROM Usuarios u WHERE u.bloqueado = :bloqueado")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telf_conv")
    private String telfConv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bloqueado")
    private int bloqueado;
    @JoinTable(name = "pf_estudiantes", joinColumns = {
        @JoinColumn(name = "id_estudiante", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_pf", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuarios> usuariosList;
    @ManyToMany(mappedBy = "usuariosList")
    private List<Usuarios> usuariosList1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private CalendarioGeneral calendarioGeneral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocente")
    private List<MaterialDidacticos> materialDidacticosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Mensajes> mensajesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios1")
    private List<Mensajes> mensajesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Observaciones> observacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios1")
    private List<Observaciones> observacionesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocente")
    private List<Actividades> actividadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocente")
    private List<NotaEstudiantes> notaEstudiantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<NotaEstudiantes> notaEstudiantesList1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private Tareas tareas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstudiante")
    private List<Tareas> tareasList;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Roles idRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Asistencias> asistenciasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios1")
    private List<Asistencias> asistenciasList1;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String cedula, String clave, String nombres, String apellidos, String correo, String celular, String telfConv, int bloqueado) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.telfConv = telfConv;
        this.bloqueado = bloqueado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelfConv() {
        return telfConv;
    }

    public void setTelfConv(String telfConv) {
        this.telfConv = telfConv;
    }

    public int getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(int bloqueado) {
        this.bloqueado = bloqueado;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList1() {
        return usuariosList1;
    }

    public void setUsuariosList1(List<Usuarios> usuariosList1) {
        this.usuariosList1 = usuariosList1;
    }

    public CalendarioGeneral getCalendarioGeneral() {
        return calendarioGeneral;
    }

    public void setCalendarioGeneral(CalendarioGeneral calendarioGeneral) {
        this.calendarioGeneral = calendarioGeneral;
    }

    @XmlTransient
    public List<MaterialDidacticos> getMaterialDidacticosList() {
        return materialDidacticosList;
    }

    public void setMaterialDidacticosList(List<MaterialDidacticos> materialDidacticosList) {
        this.materialDidacticosList = materialDidacticosList;
    }

    @XmlTransient
    public List<Mensajes> getMensajesList() {
        return mensajesList;
    }

    public void setMensajesList(List<Mensajes> mensajesList) {
        this.mensajesList = mensajesList;
    }

    @XmlTransient
    public List<Mensajes> getMensajesList1() {
        return mensajesList1;
    }

    public void setMensajesList1(List<Mensajes> mensajesList1) {
        this.mensajesList1 = mensajesList1;
    }

    @XmlTransient
    public List<Observaciones> getObservacionesList() {
        return observacionesList;
    }

    public void setObservacionesList(List<Observaciones> observacionesList) {
        this.observacionesList = observacionesList;
    }

    @XmlTransient
    public List<Observaciones> getObservacionesList1() {
        return observacionesList1;
    }

    public void setObservacionesList1(List<Observaciones> observacionesList1) {
        this.observacionesList1 = observacionesList1;
    }

    @XmlTransient
    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }

    @XmlTransient
    public List<NotaEstudiantes> getNotaEstudiantesList() {
        return notaEstudiantesList;
    }

    public void setNotaEstudiantesList(List<NotaEstudiantes> notaEstudiantesList) {
        this.notaEstudiantesList = notaEstudiantesList;
    }

    @XmlTransient
    public List<NotaEstudiantes> getNotaEstudiantesList1() {
        return notaEstudiantesList1;
    }

    public void setNotaEstudiantesList1(List<NotaEstudiantes> notaEstudiantesList1) {
        this.notaEstudiantesList1 = notaEstudiantesList1;
    }

    public Tareas getTareas() {
        return tareas;
    }

    public void setTareas(Tareas tareas) {
        this.tareas = tareas;
    }

    @XmlTransient
    public List<Tareas> getTareasList() {
        return tareasList;
    }

    public void setTareasList(List<Tareas> tareasList) {
        this.tareasList = tareasList;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public List<Asistencias> getAsistenciasList() {
        return asistenciasList;
    }

    public void setAsistenciasList(List<Asistencias> asistenciasList) {
        this.asistenciasList = asistenciasList;
    }

    @XmlTransient
    public List<Asistencias> getAsistenciasList1() {
        return asistenciasList1;
    }

    public void setAsistenciasList1(List<Asistencias> asistenciasList1) {
        this.asistenciasList1 = asistenciasList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
