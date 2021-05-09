<%@page import="com.example.cursosonline.model.Grupo"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.example.cursosonline.model.Curso"%>
<%@page import="com.example.cursosonline.controller.Model"%>
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
        <h2>Lista de Grupos del curso <%=model.getCursoActual().getDescripcion() %> </h2>
        <table>
            <thead>
                <tr>
                    <th> Numero de Grupo  </th>
                    <th> Horario     </th>
                    <th> Profesor </th>
                    <th> Cupo </th>
                    <th>  </th>
                </tr>
            </thead>
            <tbody>
                <%for(Grupo g : model.getGrupos()){ %>
                <tr>
                    <td>
                        <%= g.getNumGrupo()  %>
                    </td>
                    <td>
                        <%= g.getHorario().toString() %>
                    </td>
                    <td>
                        <%= g.getProfesor().getNombre()%>  <%=g.getProfesor().getApellido1() %> <%=g.getProfesor().getApellido2() %>
                    </td >
                     <td>
                        <%= g.getCupo() %>
                    </td >
                    <td> 
                        <form name="form" action="/CursosOnline/estudiante/matricular" method="post">
                            <input type="hidden" name="num_grupo" value="<%= g.getNumGrupo() %>">
                            <input class="button" type="submit" value="Matricular">
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
    <%@ include file="/pages/Footer.jsp" %>
</body>
</html>