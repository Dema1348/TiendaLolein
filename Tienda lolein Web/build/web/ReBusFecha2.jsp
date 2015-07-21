<%-- 
    Document   : ReBusFecha2
    Created on : 12-09-2014, 02:39:30 AM
    Author     : eds y ale
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlDb.*"%>
<%@page import="modelo.*"%>
<%@page import="java.util.*" session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
        <title>Búsqueda por Fecha</title>
    </head>
    <%
          
            HttpSession sesion=request.getSession();
            MantenedoraVentas ventasWeb=new MantenedoraVentas();
           
        %>
    <body>
   <div class="cuerpo">
        <img src="img/lolein.png" alt="logo" class="lolein">
        <h2 class="carro">Modo administrador</h2>
       <% if(sesion.getAttribute("usuario")==null){
        %>
        <div class="logeo">
                <h5 class="bienvenido">Bienvenido/a, </h5>
                <a class="registracion" href="#">Regístrate aquí</a>
                <form action="loginUser.jsp" method="POST" >
                    <% if((Integer)sesion.getAttribute("intento")<3){ %>
                    <input type="text" name="user"  required placeholder="Usuario" >
                    <input type="password" name="password"  required placeholder="contraseña">
                    <input class="entrar" type="submit" name="entrar" value="Enviar">

                    <%} 
                    else
                    {
                    %>
                    <input type="text" name="user"  required placeholder="Usuario" readonly>
                    <input type="password" name="password"  required placeholder="contraseña" readonly>
                    <input class="entrar" type="submit" name="entrar" value="Enviar" readonly>
                    Usuario bloqueado por 24 horas
                    <%
                    }
                    %>
                </form>
        </div>
        <%
        }    
        else {
            Cliente usuario= (Cliente)sesion.getAttribute("usuario");
        %>
        <div class="logeo">
                <h5 class="bienvenido">Bienvenido/a, <%= usuario.getNombre() %></h5>
                <a href="outUser.jsp" class="entrar" >Salir </a>

        </div>
        <%!
        Date nuevaFecha, nuevaFecha2;
        int dia, mes , anio,dia2,mes2,anio2;
        List<Venta> ven;
                %>
        <%
        }
            dia=Integer.parseInt(request.getParameter("dia"));
            mes=Integer.parseInt(request.getParameter("mes"));
            anio=Integer.parseInt(request.getParameter("anio"));
            dia2=Integer.parseInt(request.getParameter("dia2"));
            mes2=Integer.parseInt(request.getParameter("mes2"));
            anio2=Integer.parseInt(request.getParameter("anio2"));
            Calendar nuevaFecha= new GregorianCalendar(anio, mes, dia);
            Calendar nuevaFecha2= new GregorianCalendar(anio2, mes2, dia2);
            ven=ventasWeb.buscarPorFecha2(nuevaFecha, nuevaFecha2);
        %>
        <div class="contenedorMenuLogo">
            <nav>
                <header>* LOLEIN, DUDE*</header>
                <ul>
                    <li><a href="Admin.jsp">Modificar</a></li>
                    <li><a href="Buscar.jsp">Buscar por ID</a></li>
                    <li><a href="Fecha.jsp">Buscar Venta por Fecha</a></li>
                    <li><a href="RangoFecha.jsp">Buscar Venta por Rango de Fecha</a></li>
                    <li><a href="Agregar.jsp">Agregar</a></li>
                </ul>
            </nav>
        </div>

        <div class="contenido">
           <% 
            if( !ven.isEmpty())
            {
            %>
             <div class="productosWeb">
                <h2>* RESULTADO *</h2>
                <% for(int i=0; i<ven.size();i++)
                
                {%>
                        <div class="detalles">
                            <article>
                            <h3>ID Folio: <%= ven.get(i).getId() %> </h3>
                            <h3>Total: $<%= ven.get(i).getTotal() %></h3>
                            <h3>RUT Cliente: <%= ven.get(i).getRutCliente() %></h3>
                            <h3>Fecha: <%= ven.get(i).getFecha() %></h3>  
                            </article>
                        </div>
                    <% }%>        
                       
                        
                            
            </div>
            
            <%
            }
            
            else
            {
            %>
            <img src="img/sinVentas.png" alt="Venta">
            <%
            }
                %>
        </div>
   
        
        <footer>
                <div class="direccion">
                        <h4>Visitenos</h4>
                        <h6>Covadonga 634, San Bernardo, Región Metropolitana Tel: 1-800-000-0000 Fax: 123-456-7890</h6>
                </div>

                <div class="ayuda">
                        <h4>¿Necesita ayuda?</h4>
                        <h6>Preguntenos y envienos un correo a tiendaLolein@gmail.com</h6>
                </div>

                <div class="moneda">
                        <h4>Nosotros aceptamos</h4>
                        <img src="img/tarjetas.png" alt="" class="tarjetas">
                </div>
                <h5 class="diseñador">© 2014 by Edson Pérez and Alejandro Soto </h5>
        </footer>	
    </div>
    </body>
</html>

