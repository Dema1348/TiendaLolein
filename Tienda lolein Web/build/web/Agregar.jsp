<%-- 
    Document   : Agregar
    Created on : 12-09-2014, 01:45:39 AM
    Author     : eds y ale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>
<%@page import="java.util.*" session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
        <title>Agregar</title>
    </head>
    <%
        HttpSession sesion= request.getSession();
        MantenedoraProductos productos= new MantenedoraProductos();
    %>
    <body>
	<div class="cuerpo">
		<img src="img/lolein.png" alt="logo" class="lolein">
		<h2 class="carro">Carro de compras: 0</h2>
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
                <%
                }
                    
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
           <div class="productosWeb">
                <h2>* AGREGA TUS PRODUCTOS *</h2>
                <form action="ResAgregar.jsp" method="post">
                    <table>
                        <tr>
                            <td>
                                <h3>ID:</h3>
                            </td>
                            <td>
                                <input type="number" min="<%=productos.listar().size()+1 %>" name="txtId" required >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h3>Nombre:</h3>
                            </td>
                            <td>
                                 <input type="text" name="txtNombre" required >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h3>Precio:</h3>
                            </td>
                            <td>
                                <input type="number" min="0" name="txtPrecio" required >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h3>Stock:</h3>
                            </td>
                            <td>
                                 <input type="number" min="0" name="txtStock" required >
                            </td>
                        </tr>
                         <tr>
                            <td>
                                <h3>Detalle:</h3>
                            </td>
                            <td>
                                 <input type="text" name="txtDetalle" required >
                            </td>
                        </tr>
                    </table>
                    <input class="enviarEli" type="submit" value="Agregar">
                    <input class="enviarEli" type="reset" value="Cancelar">
                </form>
                
              
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
