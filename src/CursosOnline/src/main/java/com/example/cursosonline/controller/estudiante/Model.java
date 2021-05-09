/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.controller.estudiante;

import com.example.cursosonline.model.Estudiante;
import com.example.cursosonline.model.Matricula;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Model {
    
    private Estudiante estudiante;
    private List<Matricula> matriculas;

    public Model() {
        this.estudiante = new Estudiante();
        this.matriculas = new ArrayList<>();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
        
}
