/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.controller.profesor;

import com.example.cursosonline.model.Profesor;

/**
 *
 * @author User
 */
public class Model {
    
    private Profesor profesor;

    public Model() {
        this.profesor = new Profesor();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
        
}
