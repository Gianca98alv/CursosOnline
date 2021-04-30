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
import java.sql.ResultSet;
import java.sql.SQLException;

public class HorarioDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public HorarioDAO() {
    }
    
    public Horario get(Integer seq) throws Exception {
        try{
            String sql = "SELECT * FROM Horario WHERE seq = %d";
            sql = String.format(sql, seq);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/horario/?=" + seq + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Horario horario) throws Exception {
        try {
            String sql = "INSERT INTO Horario(seq, dia, hora) "
                    + "VALUES('%d, %d, %d)";
            sql = String.format(sql, horario.getDia(), horario.getHora(), horario.getSeq());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer update(Horario horario) throws Exception {
        try{
            String sql="UPDATE Horario SET dia=%d, hora=%d WHERE seq=%d";
            sql=String.format(sql, horario.getDia(), horario.getHora(), horario.getSeq());
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("/Horario/{" + horario.getSeq() + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer seq) throws Exception {
        try{
            String sql="DELETE FROM Horario WHERE seq=%d";
            sql = String.format(sql, seq);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Horario/{" + seq + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Horario map(ResultSet rs) throws Exception{
        Integer seq = rs.getInt("seq");
        Integer dia = rs.getInt("dia");
        Integer hora = rs.getInt("hora");
        return new Horario(seq, dia, hora);
    }
}
