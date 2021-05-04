<%@page import="com.example.cursosonline.model.Usuario"%>
<% Usuario user = (Usuario) session.getAttribute("user"); %>
<header>
    <img src="../images/banco.png" alt=""/>
    <a>Banco Estatal</a>
    <div class="menu">
        <ul class="nav"> 
            <li>
                <a href="/pages/Index.jsp">Principal</a>
            </li>
            <% if(user==null){ %>
                <li><a href="/pages/login/show">Iniciar Sesion</a></li>         
            <% } %>
            <% if(user!=null){ %>
                <li><a href="/Banco_PIV/pages/client/data/show">Usuario: <%=user.getIdUsuario()%></a></li>
                <% if(user.getRol().getDescripcion() == "administrador"){ %>
                    <li><a href="/Banco_PIV/pages/cashier/accounts/open/show">Abrir Cuenta</a></li>
                    <li><a href="/Banco_PIV/pages/Index.jsp">Movimientos</a>
                    <ul>
			<li><a href="/Banco_PIV/pages/cashier/movements/d_wd/show">Deposito o Retiro</a></li>
			<li><a href="/Banco_PIV/pages/cashier/movements/transfer/show">Tranferencia</a></li>
                    </ul>
                    </li>
                    <li>
                        <a href="/Banco_PIV/pages/cashier/accounts/interests/show">Acreditar Intereses</a>
                    </li>
                <%}%>
                <%if(user.getRol().getDescripcion() != "administrador"){ %>
                    <li><a href="/Banco_PIV/pages/client/accounts/show">Mis Cuentas</a></li>
                    <li><a href="/Banco_PIV/pages/client/accountsLinked/show">Cuentas Vinculadas</a></li>
                    <li><a href="/Banco_PIV/pages/client/transfers/show">Transferencias</a></li>
                <%} %>
                <li><a href="/Banco_PIV/pages/logout/show">Cerrar Sesion</a></li>
            <% } %>
        </ul>
    </div>
</header>
