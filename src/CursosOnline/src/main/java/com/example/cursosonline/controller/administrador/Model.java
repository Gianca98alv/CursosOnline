/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.controller.administrador;

import com.example.cursosonline.model.Administrador;

/**
 *
 * @author User
 */
public class Model {
    
    private Administrador administrador;

    public Model() {
        this.administrador = new Administrador();
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
        
}
