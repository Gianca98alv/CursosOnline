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
import com.example.cursosonline.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UsuarioDAO {
    
    private final ConnectionDB db = ConnectionDB.instance();

    public UsuarioDAO() {
    }
    
    public Usuario get(String id_usuario) throws Exception {
        try{
            String sql = "SELECT * FROM Usuario WHERE id_usuario = '%s'";
            sql = String.format(sql, id_usuario);
            ResultSet rs = db.executeQuery(sql);
            if(rs.next()) {
                return map(rs);
            }
            throw new SQLException("/usuario/?=" + id_usuario + " Does not exist in DataBase");
        } catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer add(Usuario usuario) throws Exception {
        try {
            String sql = "INSERT INTO Usuario(rol_id, clave, ultimo_aceso, activo) "
                    + "VALUES('%s',%d,'%s',%d)";
            sql = String.format(sql, usuario.getRol().getIdRol(), usuario.getClave(), usuario.getUltimoAceso(), usuario.getActivo());
            return db.executeInsert(sql);
        } catch(Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer update(Usuario usuario) throws Exception {
        try{
            String sql="UPDATE Usuario SET clave='%s', ultimo_aceso='%s', activo=%d WHERE id_usuario=%d";
            sql=String.format(sql, usuario.getClave(), usuario.getStringDate(), usuario.getActivo(), usuario.getIdUsuario());
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("/Usuario/{" + usuario.getIdUsuario() + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    public Integer delete(Integer usuario_id) throws Exception {
        try{
            String sql="DELETE FROM Usuario WHERE usuario_id=%d";
            sql = String.format(sql, usuario_id);
            int result = db.executeUpdate(sql);
            if(result == 0){
                throw new Exception("Usuario/{" + usuario_id + "} Does not exist in DataBase");
            }
            return result;
        }catch(Exception e){
            throw new Exception("Exception: " + e.getMessage());
        }
    }
    
    private Usuario map(ResultSet rs) throws Exception{
        String id_usuario = rs.getString("id_usuario");
        Integer rol_id = rs.getInt("rol_id");
        String clave = rs.getString("clave");
        Date ultimo_aceso = rs.getDate("ultimo_aceso");
        Integer activo = rs.getInt("activo");
        Usuario usuario = new Usuario(id_usuario, clave, ultimo_aceso, activo);
        RolDAO rolDAO = new RolDAO();
        Rol rol = rolDAO.get(rol_id);
        usuario.setRol(rol);
        
        return usuario;
    }
}
