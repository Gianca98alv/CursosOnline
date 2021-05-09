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
import com.example.cursosonline.model.Horario;
import com.example.cursosonline.model.Profesor;
import com.example.cursosonline.model.Curso;
import com.example.cursosonline.model.Grupo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO {

    private final ConnectionDB db = ConnectionDB.instance();

    public GrupoDAO() {
    }

    public Grupo get(Integer num_grupo) throws Exception {
        try {
            String sql = "SELECT * FROM Grupo WHERE num_grupo = %d";
            sql = String.format(sql, num_grupo);
            ResultSet rs = db.executeQuery(sql);
            if (rs.next()) {
                return map(rs);
            }
            throw new SQLException("/grupo/?=" + num_grupo + " Does not exist in DataBase");
        } catch (Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }

     public List<Grupo> getByCurso(int curso_id) throws Exception {
        List<Grupo> grupos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Grupo WHERE curso_id = %d";
            sql = String.format(sql, curso_id);
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                grupos.add(map(rs));
            }
            return grupos;
        } catch (Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }

    public List<Grupo> getAll() throws Exception {
        List<Grupo> grupos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Grupo";
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                grupos.add(map(rs));
            }
            return grupos;
        } catch (Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }

    public Integer add(Grupo grupo) throws Exception {
        try {
            String sql = "INSERT INTO Grupo(curso_id, profesor_id, horario_id, cupo) "
                    + "VALUES(%d,%d,%d, %d)";
            sql = String.format(sql, grupo.getCurso().getIdCurso(), grupo.getProfesor().getIdProfesor(), grupo.getHorario().getSeq(), grupo.getCupo());
            return db.executeInsert(sql);
        } catch (Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }

    public Integer delete(Integer num_grupo) throws Exception {
        try {
            String sql = "DELETE FROM Grupo WHERE num_grupo=%d";
            sql = String.format(sql, num_grupo);
            int result = db.executeUpdate(sql);
            if (result == 0) {
                throw new Exception("Grupo/{" + num_grupo + "} Does not exist in DataBase");
            }
            return result;
        } catch (Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }

    private Grupo map(ResultSet rs) throws Exception {
        Integer num_grupo = rs.getInt("num_grupo");
        Integer curso_id = rs.getInt("curso_id");
        Integer profesor_id = rs.getInt("profesor_id");
        Integer horario_seq = rs.getInt("horario_seq");
        Integer cupo = rs.getInt("cupo");
        Grupo grupo = new Grupo(num_grupo, cupo);

        CursoDAO cursoDAO = new CursoDAO();
        Curso curso = cursoDAO.get(curso_id);
        grupo.setCurso(curso);

        ProfesorDAO profesorDAO = new ProfesorDAO();
        Profesor profesor = profesorDAO.getById(profesor_id);
        grupo.setProfesor(profesor);

        HorarioDAO horarioDAO = new HorarioDAO();
        Horario horario = horarioDAO.get(horario_seq);
        grupo.setHorario(horario);

        return grupo;
    }
}
