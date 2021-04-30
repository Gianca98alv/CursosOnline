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
import com.example.cursosonline.model.Estado;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public EstadoDAO() {
    }
    
    public Estado get(Integer id_estado) throws Exception {
        try{
            String sql = "SELECT * FROM Estado WHERE id_estado = %d";
            sql = String.format(sql, id_estado);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/estado/?=" + id_estado + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Estado estado) throws Exception {
        try {
            String sql = "INSERT INTO Estado (descripcion) VALUES('%s')";
            sql = String.format(sql, estado.getDescripcion());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer id_estado) throws Exception {
        try{
            String sql="DELETE FROM Estado WHERE id_estado=%d";
            sql = String.format(sql, id_estado);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Estado/{" + id_estado + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Estado map(ResultSet rs) throws Exception{
        Integer id_estado = rs.getInt("id_estado");
        String descripcion = rs.getString("descripcion");
        return new Estado(id_estado, descripcion);
    }
}
