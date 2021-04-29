package com.example.cursosonline.data;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author luisd
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            ConnectionDB cd = ConnectionDB.instance();
            System.out.println("Conexion exitosa con la base de datos");
            System.out.println(cd.executeQuery("select * from usuario;"));
        }catch(Exception e){
            System.out.println("Conexion erronea con la base de datos");
            System.out.println(e.getMessage());
        }
    }
    
}
