package com.example.cursosonline.controller.estudiante;

import com.example.cursosonline.data.Service;
import com.example.cursosonline.model.Estudiante;
import com.example.cursosonline.model.Matricula;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EstudianteController", urlPatterns = {"/estudiante/home", "/estudiante/matricular"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());
        String viewUrl;
        switch (request.getServletPath()) {
            case "/estudiante/home":
                viewUrl = this.show(request);
                break;
            case "/estudiante/matricular":
                viewUrl = this.matricular(request);
                break;
            default:
                viewUrl = "/pages/Error.jsp";
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String show(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true);
        try {
            model.setEstudiante((Estudiante) session.getAttribute("estudiante"));
            model.setMatriculas(Service.instance().findMatriculasByEstudiante(model.getEstudiante().getIdEstudiante()));
            return "/pages/estudiante/View.jsp;";
        } catch (Exception ex) {
            return "/pages/Error.jsp";
        }
    }

    private String matricular(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        try {
            if (session.getAttribute("estudiante") != null) {
                String num_grupo = (String) request.getParameter("num_grupo");
                Estudiante e = (Estudiante) session.getAttribute("estudiante");
                Matricula matricula = new Matricula();
                matricula.setEstado(Service.instance().getEstado(1));
                matricula.setEstudiante(e);
                matricula.setGrupo(Service.instance().getGrupo(Integer.valueOf(num_grupo)));
                Service.instance().registrarMatricula(matricula);
                return "/estudiante/home";
            } else {
                return "/login/show";
            }
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
