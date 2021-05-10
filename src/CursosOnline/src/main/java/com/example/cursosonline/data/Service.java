/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.cursosonline.data;

import com.example.cursosonline.model.Curso;
import com.example.cursosonline.model.Estado;
import com.example.cursosonline.model.Grupo;
import com.example.cursosonline.model.Matricula;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Service {

    private static Service uniqueInstance;
    private final AdministradorDAO administrador_dao;
    private final AreaTematicaDAO area_tematica_dao;
    private final CursoDAO curso_dao;
    private final EspecialidadDAO especialidad_dao;
    private final EstadoDAO estado_dao;
    private final EstudianteDAO estudiante_dao;
    private final GrupoDAO grupo_dao;
    private final HorarioDAO horario_dao;
    private final MatriculaDAO matricula_dao;
    private final ProfesorDAO profesor_dao;
    private final RolDAO rol_dao;
    private final UsuarioDAO usuario_dao;

    public static Service instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }

    private Service() {
        this.administrador_dao = new AdministradorDAO();
        this.area_tematica_dao = new AreaTematicaDAO();
        this.curso_dao = new CursoDAO();
        this.especialidad_dao = new EspecialidadDAO();
        this.estado_dao = new EstadoDAO();
        this.estudiante_dao = new EstudianteDAO();
        this.grupo_dao = new GrupoDAO();
        this.horario_dao = new HorarioDAO();
        this.matricula_dao = new MatriculaDAO();
        this.profesor_dao = new ProfesorDAO();
        this.rol_dao = new RolDAO();
        this.usuario_dao = new UsuarioDAO();
    }

    // Metodos de Administrador
    
    // Metodos de Area Tematica
    
    // Metodos de Curso
    
    public Curso getCurso(Integer curso_id) throws Exception {
        return this.curso_dao.get(curso_id);
    }
    
    public List<Curso> getAllCurses() {
        try {
            return curso_dao.getAll();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public List<Curso> filterCursos(String nombre_curso, String nombre_area) {
        try {
            return curso_dao.filterCursos(nombre_curso, nombre_area);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public List<Grupo> findGruposByCurso(int curso_id) {
        try {
            return grupo_dao.getByCurso(curso_id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    // Metodos de Especialidad
    
    // Metodos de Estado
    
    
    public Estado getEstado(Integer id_estado) throws Exception {
        return this.estado_dao.get(id_estado);
    }
    
    // Metodos de Estudiante
    
    // Metodos de Grupo
    
    public Grupo getGrupo(Integer id_grupo) throws Exception {
        return this.grupo_dao.get(id_grupo);
    }
    
    public List<Grupo> getGruposByProfesor(Integer profesor_id) throws Exception {
        return this.grupo_dao.getByProfesor(profesor_id);
    }
    
    // Metodos de Horario
    
    // Metodos de Matricula
    
    public void registrarMatricula(Matricula matricula) throws Exception {
        if(this.matricula_dao.findMatriculaByEstudianteCurso(
                matricula.getEstudiante().getIdEstudiante(), 
                matricula.getGrupo().getCurso().getIdCurso()) == null){
            this.matricula_dao.add(matricula);
        } else {
            throw new Exception("Ya se encuentra matriculado en este curso");
        }
    }
    
    public List<Matricula> findMatriculasByEstudiante(Integer estudiante_id) {
        try {
            return this.matricula_dao.getByEstudiante(estudiante_id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }
    // Metodos de Profesor
    
    // Metodos de Rol
    
    // Metodos de Usuario

}
