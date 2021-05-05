/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.controller.estudiante;

import com.example.cursosonline.model.Estudiante;

/**
 *
 * @author User
 */
public class Model {
    
    private Estudiante estudiante;

    public Model() {
        this.estudiante = new Estudiante();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
        
}
