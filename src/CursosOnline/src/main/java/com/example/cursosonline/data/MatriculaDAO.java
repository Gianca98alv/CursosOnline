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
import com.example.cursosonline.model.Estudiante;
import com.example.cursosonline.model.Grupo;
import com.example.cursosonline.model.Matricula;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public MatriculaDAO() {
    }
    
    public List<Matricula> getByEstudiante(Integer estudiante_id) throws Exception {
        List<Matricula> matriculas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Matricula WHERE estudiante_id = %d";
            sql = String.format(sql, estudiante_id);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                matriculas.add(map(rs));
            }
            return matriculas;
        } catch (Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Matricula get(Integer matricula_id) throws Exception {
        try{
            String sql = "SELECT * FROM Matricula WHERE matricula_id = %d";
            sql = String.format(sql, matricula_id);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/matricula/?=" + matricula_id + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    Matricula findMatriculaByEstudianteCurso(Integer idEstudiante, Integer idCurso) throws Exception {
        try{
            String sql = "SELECT m.matricula_id, m.estudiante_id, m.grupo_num, m.estado_id, m.nota "
                    + "FROM Matricula m inner join Grupo g "
                    + "WHERE m.grupo_num = g.num_grupo AND m.estudiante_id = %d AND g.curso_id = %d";
            sql = String.format(sql, idEstudiante, idCurso);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            return null;
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Matricula matricula) throws Exception {
        try {
            String sql = "INSERT INTO Matricula(estudiante_id, grupo_num, estado_id, nota) "
                    + "VALUES(%d,%d,%d,%d)";
            sql = String.format(sql, matricula.getEstudiante().getIdEstudiante(), matricula.getGrupo().getNumGrupo(), matricula.getEstado().getIdEstado(), matricula.getNota());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer update(Matricula matricula) throws Exception {
        try{
            String sql="UPDATE Matricula SET estado=%d, nota=%d WHERE matricula_id=%d";
            sql=String.format(sql, matricula.getEstado().getIdEstado(), matricula.getNota());
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("/Matricula/{" + matricula.getMatriculaId() + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer matricula_id) throws Exception {
        try{
            String sql="DELETE FROM Matricula WHERE matricula_id=%d";
            sql = String.format(sql, matricula_id);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Matricula/{" + matricula_id + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Matricula map(ResultSet rs) throws Exception{
        Integer matricula_id = rs.getInt("matricula_id");
        Integer estudiante_id = rs.getInt("estudiante_id");
        Integer grupo_num = rs.getInt("grupo_num");
        Integer estado_id = rs.getInt("estado_id");
        Integer nota = rs.getInt("nota");
        
        Matricula matricula = new Matricula(matricula_id, nota);
        
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        Estudiante estudiante = estudianteDAO.getById(estudiante_id);
        matricula.setEstudiante(estudiante);
        
        GrupoDAO grupoDAO = new GrupoDAO();
        Grupo grupo = grupoDAO.get(grupo_num);
        matricula.setGrupo(grupo);
        
        EstadoDAO estadoDAO = new EstadoDAO();
        Estado estado = estadoDAO.get(estado_id);
        matricula.setEstado(estado);
                
        return matricula;
    }
   
}
