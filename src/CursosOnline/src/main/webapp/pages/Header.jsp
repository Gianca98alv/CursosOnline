<%@page import="com.example.cursosonline.model.Rol"%>
<%@page import="com.example.cursosonline.model.Usuario"%>
<%@page import="com.example.cursosonline.model.Administrador"%>
<%@page import="com.example.cursosonline.model.Profesor"%>
<%@page import="com.example.cursosonline.model.Estudiante"%>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<header>
    <ul>
        <li>
            <img class="logo" src="${pageContext.request.contextPath}/images/logo.png" alt="Logo Principal"/>
        </li>
        <li>
            <a class="title">Cursos Online</a>
        </li>
    </ul>
    <div class="menu">
        <ul class="nav"> 
            <li> <a href="/CursosOnline/index">Busqueda Cursos</a> </li>
            <% if(usuario == null){ %>
                <li><a href="/CursosOnline/login/show">Iniciar Sesión</a></li>         
            <% } %>
            <% if( usuario != null){ %>
            <% if(usuario.getRol().getDescripcion().equals("Administrador")){ %>
                    <% Administrador administrador = (Administrador) session.getAttribute("adminitrador"); %>
                    <li><a href="/CursosOnline/administrador/registro-cursos">Listado y Registro de cursos</a></li>
                    <li><a href="/CursosOnline/administrador/registro-profesores">Listado y Registro de profesores</a></li>
                    <li><a class="disabled" href=""> Bienvenido <%= administrador.getNombre() + " " +  administrador.getApellido1() + " "  + administrador.getApellido2()%> </a></li>
                <%}%>
                <%if(usuario.getRol().getDescripcion().equals("Profesor")){ %>
                    <% Profesor profesor = (Profesor) session.getAttribute("profesor"); %>
                    <li><a href="/CursosOnline/profesor/grupos">Carga asignada</a></li>
                    <li><a class="disabled" href=""> Bienvenido <%= profesor.getNombre() + " " + profesor.getApellido1() + " " + profesor.getApellido2()%> </a></li>                
                <%} %>
                <%if(usuario.getRol().getDescripcion().equals("Estudiante")){ %>
                    <% Estudiante estudiante = (Estudiante) session.getAttribute("estudiante"); %>
                    <li><a href="/CursosOnline/estudiante/home">Historial</a></li>
                    <li><a class="disabled" href=""> Bienvenido <%= estudiante.getNombre() + " " + estudiante.getApellido1() + " " + estudiante.getApellido2()%> </a></li>
                <%} %>
                <li><a href="/CursosOnline/login/logout">Cerrar Sesión</a></li>
            <% } %>
        </ul>
    </div>
</header>
