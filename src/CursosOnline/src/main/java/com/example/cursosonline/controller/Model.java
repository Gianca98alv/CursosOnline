/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.controller;

import com.example.cursosonline.model.AreaTematica;
import com.example.cursosonline.model.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Model {
    
    private List<Curso> cursos;
    private List<AreaTematica> areastematicas;

    public Model() {
        this.cursos = new ArrayList();
        this.areastematicas = new ArrayList();
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<AreaTematica> getAreastematicas() {
        return areastematicas;
    }

    public void setAreastematicas(List<AreaTematica> areastematicas) {
        this.areastematicas = areastematicas;
    }
    
}
