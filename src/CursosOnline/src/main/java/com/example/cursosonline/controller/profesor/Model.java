/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.controller.profesor;

import com.example.cursosonline.model.Estudiante;
import com.example.cursosonline.model.Grupo;
import com.example.cursosonline.model.Profesor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Model {
    
    private Profesor profesor;
    private List<Grupo> grupos;
    private Grupo actual;
    private List<Estudiante> estudiantes;
    

    public Model() {
        this.profesor = new Profesor();
        this.grupos = new ArrayList<Grupo>();
        this.estudiantes = new ArrayList<Estudiante>();
        this.actual = new Grupo();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Grupo getActual() {
        return actual;
    }

    public void setActual(Grupo actual) {
        this.actual = actual;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
       
    
}
