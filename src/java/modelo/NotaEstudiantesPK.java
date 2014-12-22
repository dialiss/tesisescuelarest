/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Luis Zozoranga
 */
@Embeddable
public class NotaEstudiantesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estudiante")
    private int idEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia")
    private int idMateria;

    public NotaEstudiantesPK() {
    }

    public NotaEstudiantesPK(int idEstudiante, int idMateria) {
        this.idEstudiante = idEstudiante;
        this.idMateria = idMateria;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEstudiante;
        hash += (int) idMateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaEstudiantesPK)) {
            return false;
        }
        NotaEstudiantesPK other = (NotaEstudiantesPK) object;
        if (this.idEstudiante != other.idEstudiante) {
            return false;
        }
        if (this.idMateria != other.idMateria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.NotaEstudiantesPK[ idEstudiante=" + idEstudiante + ", idMateria=" + idMateria + " ]";
    }
    
}
