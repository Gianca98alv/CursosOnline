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
import com.example.cursosonline.model.Horario;
import com.example.cursosonline.model.Profesor;
import com.example.cursosonline.model.Especialidad;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecialidadDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public EspecialidadDAO() {
    }
    
    public Especialidad get(Integer id_especialidad) throws Exception {
        try{
            String sql = "SELECT * FROM Especialidad WHERE id_especialidad = %d";
            sql = String.format(sql, id_especialidad);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/especialidad/?=" + id_especialidad + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Especialidad especialidad) throws Exception {
        try {
            String sql = "INSERT INTO Especialidad(profesor_id, area_tematica_id) VALUES(%d,%d)";
            sql = String.format(sql, especialidad.getProfesor().getIdProfesor(), especialidad.getAreaTematica().getIdArea());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer id_especialidad) throws Exception {
        try{
            String sql="DELETE FROM Especialidad WHERE id_especialidad=%d";
            sql = String.format(sql, id_especialidad);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Especialidad/{" + id_especialidad + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Especialidad map(ResultSet rs) throws Exception{
        Integer profesor_id = rs.getInt("profesor_id");
        Integer area_tematica_id = rs.getInt("area_tematica_id");
        Integer id_especialidad = rs.getInt("id_especialidad");
        
        Especialidad especialidad = new Especialidad(id_especialidad);
        
        ProfesorDAO profesorDAO = new ProfesorDAO();
        Profesor profesor = profesorDAO.get(profesor_id);
        especialidad.setProfesor(profesor);
        
        AreaTematicaDAO areaTematicaDAO = new AreaTematicaDAO();
        AreaTematica areaTematica = areaTematicaDAO.get(area_tematica_id);
        especialidad.setAreaTematica(areaTematica);
        
        return especialidad;
    }
}
