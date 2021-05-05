/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.controller.login;

import com.example.cursosonline.model.Usuario;

/**
 *
 * @author User
 */
public class Model {
    
    private Usuario current;

    public Model() {
        this.current = new Usuario();
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }
    
    

}
