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
        <h2>Busqueda de Cursos</h2>
        <table>
            <thead>
                <form name="form" action="/CursosOnline/index/search-curses" method="post">
                 <td> Nombre </td>
                 <td> 
                    <input type="text" name="nombreCurso">
                 </td>
                 <td> Tematica </td>
                 <td> <input type="text" name="nombreTematica" placeholder=""> </td>
                 <td> <input class="button" type="submit" value="Buscar"> </td>
                </form>
            </thead>
        </table>
        <table>
            <thead>
                <tr>
                    <th> Id     </th>
                    <th> Nombre </th>
                    <th> Area Tematica </th>
                </tr>
            </thead>
            <tbody>
                <%for(Curso c : model.getCursos()){ %>
                <tr>
                    <td>
                        <%= c.getIdCurso() %>
                    </td>
                    <td>
                        <%= c.getDescripcion() %>
                    </td >
                    <td>
                        <%= c.getAreaTematica().getDescripcion() %>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
    <%@ include file="/pages/Footer.jsp" %>
</body>
</html>