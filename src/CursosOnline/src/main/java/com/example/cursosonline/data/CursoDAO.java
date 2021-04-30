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
import com.example.cursosonline.model.Rol;
import com.example.cursosonline.model.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CursoDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public CursoDAO() {
    }
    
    public Curso get(Integer id_curso) throws Exception {
        try{
            String sql = "SELECT * FROM Curso WHERE id_curso = %d";
            sql = String.format(sql, id_curso);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/curso/?=" + id_curso + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Curso curso) throws Exception {
        try {
            String sql = "INSERT INTO Curso(descripcion, area_tematica_id) "
                    + "VALUES('%s',%d)";
            sql = String.format(sql, curso.getDescripcion(), curso.getAreaTematica().getIdArea());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer update(Curso curso) throws Exception {
        try{
            String sql="UPDATE Curso SET descripcion='%s' WHERE id_curso=%d";
            sql=String.format(sql, curso.getDescripcion(), curso.getIdCurso());
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("/Curso/{" + curso.getIdCurso() + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer id_curso) throws Exception {
        try{
            String sql="DELETE FROM Curso WHERE id_curso=%d";
            sql = String.format(sql, id_curso);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Curso/{" + id_curso + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Curso map(ResultSet rs) throws Exception{
        Integer id_curso = rs.getInt("id_curso");
        String descripcion = rs.getString("descripcion");
        Integer area_tematica_id = rs.getInt("area_tematica_id");
        Curso curso = new Curso(id_curso, descripcion);
        AreaTematicaDAO areaTematicaDAO = new AreaTematicaDAO();
        AreaTematica areaTematica = areaTematicaDAO.get(area_tematica_id);
        curso.setAreaTematica(areaTematica);
        
        return curso;
    }
}
