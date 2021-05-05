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
import com.example.cursosonline.model.Administrador;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public AdministradorDAO() {
    }
    
    public Administrador get(String usuario_id) throws Exception {
        try{
            String sql = "SELECT * FROM Administrador WHERE usuario_id = '%s'";
            sql = String.format(sql, usuario_id);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/administrador/?=" + usuario_id + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Administrador administrador) throws Exception {
        try {
            String sql = "INSERT INTO Administrador(usuario_id, apellido1, apellido2, nombre, telefono, e_mail) "
                    + "VALUES('%s','%s','%s','%s','%s','%s')";
            sql = String.format(sql, administrador.getUsuario().getIdUsuario(), administrador.getApellido1(), administrador.getApellido2(), administrador.getNombre(), administrador.getTelefono(), administrador.getEMail());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer update(Administrador administrador) throws Exception {
        try{
            String sql="UPDATE Administrador SET apellido1='%s', apellido2='%s', nombre='%s', telefono='%s', e_mail='%s' WHERE id_administrador=%d";
            sql=String.format(sql, administrador.getApellido1(), administrador.getApellido2(), administrador.getNombre(), administrador.getTelefono(), administrador.getEMail(), administrador.getIdAdministrador());
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("/Administrador/{" + administrador.getIdAdministrador() + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer usuario_id) throws Exception {
        try{
            String sql="DELETE FROM Administrador WHERE usuario_id=%d";
            sql = String.format(sql, usuario_id);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Administrador/{" + usuario_id + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Administrador map(ResultSet rs) throws Exception{
        Integer id_administrador = rs.getInt("id_administrador");
        //String usuario_id = rs.getString("usuario_id");
        String apellido1 = rs.getString("apellido1");
        String apellido2 = rs.getString("apellido2");
        String nombre = rs.getString("nombre");
        String telefono = rs.getString("telefono");
        String e_mail = rs.getString("e_mail");
        return new Administrador(id_administrador, apellido1, apellido2, nombre, telefono, e_mail);
    }
}
