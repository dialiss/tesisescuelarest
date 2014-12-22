/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "material_didacticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialDidacticos.findAll", query = "SELECT m FROM MaterialDidacticos m"),
    @NamedQuery(name = "MaterialDidacticos.findByIdMaterialDidactico", query = "SELECT m FROM MaterialDidacticos m WHERE m.idMaterialDidactico = :idMaterialDidactico"),
    @NamedQuery(name = "MaterialDidacticos.findByMaterial", query = "SELECT m FROM MaterialDidacticos m WHERE m.material = :material"),
    @NamedQuery(name = "MaterialDidacticos.findByArchivoMaterial", query = "SELECT m FROM MaterialDidacticos m WHERE m.archivoMaterial = :archivoMaterial")})
public class MaterialDidacticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material_didactico")
    private Integer idMaterialDidactico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "material")
    private String material;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "archivo_material")
    private String archivoMaterial;
    @JoinColumn(name = "id_docente", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idDocente;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne(optional = false)
    private Materias idMateria;

    public MaterialDidacticos() {
    }

    public MaterialDidacticos(Integer idMaterialDidactico) {
        this.idMaterialDidactico = idMaterialDidactico;
    }

    public MaterialDidacticos(Integer idMaterialDidactico, String material, String archivoMaterial) {
        this.idMaterialDidactico = idMaterialDidactico;
        this.material = material;
        this.archivoMaterial = archivoMaterial;
    }

    public Integer getIdMaterialDidactico() {
        return idMaterialDidactico;
    }

    public void setIdMaterialDidactico(Integer idMaterialDidactico) {
        this.idMaterialDidactico = idMaterialDidactico;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getArchivoMaterial() {
        return archivoMaterial;
    }

    public void setArchivoMaterial(String archivoMaterial) {
        this.archivoMaterial = archivoMaterial;
    }

    public Usuarios getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Usuarios idDocente) {
        this.idDocente = idDocente;
    }

    public Materias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materias idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterialDidactico != null ? idMaterialDidactico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialDidacticos)) {
            return false;
        }
        MaterialDidacticos other = (MaterialDidacticos) object;
        if ((this.idMaterialDidactico == null && other.idMaterialDidactico != null) || (this.idMaterialDidactico != null && !this.idMaterialDidactico.equals(other.idMaterialDidactico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MaterialDidacticos[ idMaterialDidactico=" + idMaterialDidactico + " ]";
    }
    
}
