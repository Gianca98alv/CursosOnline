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
import com.example.cursosonline.model.Rol;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public RolDAO() {
    }
    
    public Rol get(Integer id_rol) throws Exception {
        try{
            String sql = "SELECT * FROM Rol WHERE id_rol = %d";
            sql = String.format(sql, id_rol);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/rol/?=" + id_rol + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Rol rol) throws Exception {
        try {
            String sql = "INSERT INTO Rol (descripcion) VALUES('%s')";
            sql = String.format(sql, rol.getDescripcion());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer id_rol) throws Exception {
        try{
            String sql="DELETE FROM Rol WHERE id_rol=%d";
            sql = String.format(sql, id_rol);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Rol/{" + id_rol + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Rol map(ResultSet rs) throws Exception{
        Integer id_rol = rs.getInt("id_rol");
        String descripcion = rs.getString("descripcion");
        return new Rol(id_rol, descripcion);
    }
}
