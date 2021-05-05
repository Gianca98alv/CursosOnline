package com.example.cursosonline.controller.estudiante;

import com.example.cursosonline.data.EstudianteDAO;
import com.example.cursosonline.model.Estudiante;
import com.example.cursosonline.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EstudianteController", urlPatterns = {"/estudiante/home"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
        String viewUrl;
        switch(request.getServletPath()){
            case "/estudiante/home": viewUrl = this.show(request); break;
            default: viewUrl = "/pages/Error.jsp"; break;          
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    private String show(HttpServletRequest request) {
        Model model= (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true);
        try {
            model.setEstudiante( (Estudiante) session.getAttribute("estudiante"));
            return "/pages/estudiante/View.jsp;";
        } catch (Exception ex) {
            return "/pages/Error.jsp"; 
        }
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