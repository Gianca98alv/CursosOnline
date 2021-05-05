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
import com.example.cursosonline.model.AreaTematica;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaTematicaDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public AreaTematicaDAO() {
    }
    
    public AreaTematica get(Integer id_area) throws Exception {
        try{
            String sql = "SELECT * FROM area_tematica WHERE id_area = %d";
            sql = String.format(sql, id_area);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/area_tematica/?=" + id_area + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(AreaTematica rol) throws Exception {
        try {
            String sql = "INSERT INTO area_tematica (descripcion) VALUES('%s')";
            sql = String.format(sql, rol.getDescripcion());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer id_area) throws Exception {
        try{
            String sql="DELETE FROM area_tematica WHERE id_area=%d";
            sql = String.format(sql, id_area);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("area_tematica/{" + id_area + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private AreaTematica map(ResultSet rs) throws Exception{
        Integer id_area = rs.getInt("id_area");
        String descripcion = rs.getString("descripcion");
        return new AreaTematica(id_area, descripcion);
    }
}
