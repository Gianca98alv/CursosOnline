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
import com.example.cursosonline.model.Estudiante;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudianteDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public EstudianteDAO() {
    }
    
    public Estudiante get(Integer usuario_id) throws Exception {
        try{
            String sql = "SELECT * FROM Estudiante WHERE usuario_id = %d";
            sql = String.format(sql, usuario_id);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/estudiante/?=" + usuario_id + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Estudiante estudiante) throws Exception {
        try {
            String sql = "INSERT INTO Estudiante(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) "
                    + "VALUES('%s','%s','%s','%s','%s','%s')";
            sql = String.format(sql, estudiante.getUsuario().getIdUsuario(), estudiante.getApellido1(), estudiante.getApellido2(), estudiante.getNombre(), estudiante.getTelefono(), estudiante.getEMail());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer update(Estudiante estudiante) throws Exception {
        try{
            String sql="UPDATE Estudiante SET apellido1='%s', apellido2='%s', nombre='%s', telefono='%s', e_mail='%s' WHERE id_estudiante=%d";
            sql=String.format(sql, estudiante.getApellido1(), estudiante.getApellido2(), estudiante.getNombre(), estudiante.getTelefono(), estudiante.getEMail(), estudiante.getIdEstudiante());
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("/Estudiante/{" + estudiante.getIdEstudiante() + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer usuario_id) throws Exception {
        try{
            String sql="DELETE FROM Estudiante WHERE usuario_id=%d";
            sql = String.format(sql, usuario_id);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Estudiante/{" + usuario_id + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Estudiante map(ResultSet rs) throws Exception{
        Integer id_estudiante = rs.getInt("id_estudiante");
        //String usuario_id = rs.getString("usuario_id");
        String apellido1 = rs.getString("apellido1");
        String apellido2 = rs.getString("apellido2");
        String nombre = rs.getString("nombre");
        String telefono = rs.getString("telefono");
        String e_mail = rs.getString("e_mail");
        return new Estudiante(id_estudiante, apellido1, apellido2, nombre, telefono, e_mail);
    }
}
