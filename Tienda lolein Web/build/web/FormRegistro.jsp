<%-- 
    Document   : FormRegistro
    Created on : 12-09-2014, 02:24:16 PM
    Author     : eds y ale
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*"%>
<%@page import="controlDb.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="5;URL=index.jsp" >
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
        
        <title>Termino de registro</title>
        <%! 
            String nombre, pass, rut, correo, dia, mes,anio;
           
        
            Date nuevaFecha = null;
        %>
        <% 
            HttpSession sesion=request.getSession();
            MantenedoraClientes dato=new MantenedoraClientes();
            try
            {
                nombre=request.getParameter("txtNombre");
                rut= request.getParameter("txtRut");
                pass= request.getParameter("txtPass");
                correo= request.getParameter("txtCorreo");
                dia=request.getParameter("dia");
                mes=request.getParameter("mes");
                anio=request.getParameter("anio");
                Calendar calendario= Calendar.getInstance();
                calendario.set(Integer.parseInt(anio), Integer.parseInt(mes),Integer.parseInt(dia));
                Date fecha= calendario.getTime();
                Cliente cliente= new Cliente(rut, nombre, correo, fecha,pass);
                dato.agregar(cliente);
               
            }catch(Exception e){}
        %>
    </head>
    <body >
        <div class="cuerpo">
        <img src="img/lolein.png" alt="logo" class="lolein">
        <h2 class="carro">Carro de compras: 0</h2>
       <% if(sesion.getAttribute("usuario")==null){
        %>
        <div class="logeo">
                <h5 class="bienvenido">Bienvenido/a, </h5>
                <a class="registracion" href="Registro.jsp">Regístrate aquí</a>
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
        <%
        }

        %>
        <div class="contenedorMenuLogo">
            <nav>
                <header>* LOLEIN, DUDE*</header>
                <ul>
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="tienda.jsp">Productos</a></li>
                    <li><a href="terminar.jsp">Finalizar Compra</a></li>
                    <li><a href="">Sobre Nosotros</a></li>
                    <li><a href="">Ubicacion</a></li>
                </ul>
            </nav>
        </div>
       
        <div class="contenido">
           
            <div class="productosWeb">
                <h2>* REGISTRO EXITOSO  *</h2>
                <br/>
                <h3>Se ha enviado un Email a: <%= correo %> con los detalle de la información registrada. </h3>   
                <h3>Serás dirigido automáticamente en cinco segundos. En caso contrario, puedes acceder haciendo click <a href="index.jsp">aquí</a></h3>
               
                <img  src="img/mejoLugar.png" alt="logo">   
                <div class="divisor"></div>
            </div>
           
            <div class="mensaje">
                <h2 class="frase">¿PORQUE COMPRAR EN LA TIENDA LOLEIN?</h2>
                <div class="frases">
                    <p>LOS MEJORES PRECIOS- GARANTIZADO!</p>
                    <p>10 AÑOS DE EXPERIENCIA</p>
                    <p>VARIEDAD DE PRODUCTOS</p>
                    <p>FEEDBACK PERMANENTE CON NUESTROS COMPRADORES</p>
                </div>
            </div>
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

