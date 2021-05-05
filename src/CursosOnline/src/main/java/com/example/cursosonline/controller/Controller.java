package com.example.cursosonline.controller;

import com.example.cursosonline.data.CursoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IndexController", urlPatterns = {"/index", "/index/search-curses"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
        String viewUrl;
        switch(request.getServletPath()){
            case "/index": viewUrl = this.show(request); break;
            case "/index/search-curses": viewUrl = this.searchCurse(request); break;
            default: viewUrl = "/pages/Error.jsp"; break;          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    private String show(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        try{
            model.setCursos(new CursoDAO().getAll());
        }catch(Exception e){
            System.out.println(e);
        }
        return "/pages/Index.jsp";
    }

    private String searchCurse(HttpServletRequest request){
        Model model = (Model) request.getAttribute("model");
        try{
            String nombre_curso = (String) request.getParameter("nombreCurso");
            String nombre_area = (String) request.getParameter("nombreTematica");
            model.setCursos(new CursoDAO().searchCurso(nombre_curso, nombre_area));
        }catch(Exception e){
            return "/pages/Error.jsp";
        }
        return "/pages/Index.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}