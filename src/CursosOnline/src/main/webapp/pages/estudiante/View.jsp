<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.example.cursosonline.model.Matricula"%>
<%@page import="com.example.cursosonline.controller.estudiante.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Model model = (Model) request.getAttribute("model"); %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cursos Online</title> 
        <%@ include file="/pages/Head.jsp" %>
    </head>
<body >
    <%@ include file="/pages/Header.jsp" %>
    <div class="container  ml-3">
        <h2>Lista de Matriculas</h2>
        <table>
            <thead>
                <tr>
                    <th> Estado </th>
                    <th> Curso  </th>
                    <th> Numero Grupo </th>
                    <th> Horario </th>
                    <th> Profesor </th>
                    <th> Nota </th>
                </tr>
            </thead>
            <tbody>
                <%for(Matricula m : model.getMatriculas()){ %>
                <tr>
                    <td>
                        <%= m.getEstado().getDescripcion() %>
                    </td>
                    <td>
                        <%= m.getGrupo().getCurso().getDescripcion() %>
                    </td>
                    <td>
                        <%= m.getGrupo().getNumGrupo() %>
                    </td>
                    <td>
                        <%= m.getGrupo().getHorario().toString() %>
                    </td>
                    <td>
                        <%= m.getGrupo().getProfesor().getNombre()%>  <%=m.getGrupo().getProfesor().getApellido1() %> <%=m.getGrupo().getProfesor().getApellido2() %>
                    </td >
                    <td>
                        <%= m.getNota() %>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
    <%@ include file="/pages/Footer.jsp" %>
</body>
</html>