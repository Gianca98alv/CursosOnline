/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.data;

/**
 *
 * @author User
 */
import com.example.cursosonline.model.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesorDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public ProfesorDAO() {
    }
    
    public Profesor get(Integer usuario_id) throws Exception {
        try{
            String sql = "SELECT * FROM Profesor WHERE usuario_id = %d";
            sql = String.format(sql, usuario_id);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/profesor/?=" + usuario_id + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Profesor profesor) throws Exception {
        try {
            String sql = "INSERT INTO Profesor(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) "
                    + "VALUES('%s','%s','%s','%s','%s','%s')";
            sql = String.format(sql, profesor.getUsuario().getIdUsuario(), profesor.getApellido1(), profesor.getApellido2(), profesor.getNombre(), profesor.getTelefono(), profesor.getEMail());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer update(Profesor profesor) throws Exception {
        try{
            String sql="UPDATE Profesor SET apellido1='%s', apellido2='%s', nombre='%s', telefono='%s', e_mail='%s' WHERE id_profesor=%d";
            sql=String.format(sql, profesor.getApellido1(), profesor.getApellido2(), profesor.getNombre(), profesor.getTelefono(), profesor.getEMail(), profesor.getIdProfesor());
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("/Profesor/{" + profesor.getIdProfesor() + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer usuario_id) throws Exception {
        try{
            String sql="DELETE FROM Profesor WHERE usuario_id=%d";
            sql = String.format(sql, usuario_id);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Profesor/{" + usuario_id + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Profesor map(ResultSet rs) throws Exception{
        Integer id_profesor = rs.getInt("id_profesor");
        //String usuario_id = rs.getString("usuario_id");
        String apellido1 = rs.getString("apellido1");
        String apellido2 = rs.getString("apellido2");
        String nombre = rs.getString("nombre");
        String telefono = rs.getString("telefono");
        String e_mail = rs.getString("e_mail");
        return new Profesor(id_profesor, apellido1, apellido2, nombre, telefono, e_mail);
    }
}
