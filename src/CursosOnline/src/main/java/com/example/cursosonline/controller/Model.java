/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.controller;

import com.example.cursosonline.model.Curso;
import com.example.cursosonline.model.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Model {
    
    private List<Curso> cursos;
    private Curso curso_actual;
    private List<Grupo> grupos;

    public Model() {
        this.cursos = new ArrayList();
        this.grupos = new ArrayList();
        this.curso_actual = new Curso();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Curso getCursoActual() {
        return curso_actual;
    }

    public void setCursoActual(Curso actual) {
        this.curso_actual = actual;
    } 
    
}
