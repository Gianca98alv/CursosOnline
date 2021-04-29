/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author luisd
 */
@Entity
@Table(name = "grupo")
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_grupo")
    private Integer numGrupo;
    @JoinColumn(name = "curso_id", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "horario_seq", referencedColumnName = "seq")
    @ManyToOne(optional = false)
    private Horario horario;
    @JoinColumn(name = "profesor_id", referencedColumnName = "id_profesor")
    @ManyToOne(optional = false)
    private Profesor profesor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "grupo")
    private Matricula matricula;

    public Grupo() {
    }

    public Grupo(Integer numGrupo) {
        this.numGrupo = numGrupo;
    }

    public Integer getNumGrupo() {
        return numGrupo;
    }

    public void setNumGrupo(Integer numGrupo) {
        this.numGrupo = numGrupo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numGrupo != null ? numGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.numGrupo == null && other.numGrupo != null) || (this.numGrupo != null && !this.numGrupo.equals(other.numGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.cursosonline.model.Grupo[ numGrupo=" + numGrupo + " ]";
    }
    
}
