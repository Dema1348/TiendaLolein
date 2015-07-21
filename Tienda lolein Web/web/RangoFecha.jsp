<%-- 
    Document   : RangoFecha
    Created on : 12-09-2014, 02:37:00 AM
    Author     : eds y ale
--%>

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
        <title>Buscar por fecha</title>
        <script >
            function llenarAnio()
            {
                var s1= document.getElementById("anios");
                var s12= document.getElementById("anios2");
                var index=0;
                for (i = 2014; i <= 2014; i++) 
                {
                    s1.options[index]= new Option(i,i);
                    s12.options[index]= new Option(i,i);
                    index++;
                };
               
                
            }
            
            function llenarDia()
            {
                var s2= document.getElementById("dia");
                var s22= document.getElementById("dia2");
                var index=0;
                for (i = 1; i < 31; i++) 
                {
                    s2.options[index]= new Option(i,i);
                    s22.options[index]= new Option(i,i);
                    index++;
                };
               
                
            }
            
            
           
            
            function llenarFechas(){
                llenarDia();
                llenarAnio();
            
                
            }
        </script>
    </head>
    <%
          
            HttpSession sesion=request.getSession();
            MantenedoraVentas ventasWeb=new MantenedoraVentas();
           
        %>
   <body onload="llenarFechas()">
   <div class="cuerpo" >
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
                <h2>* Buscar por Fecha *</h2>
                <form action="ReBusFecha2.jsp" method="post">
                    <div class="bloque">
                   <h3>Ingresar fecha Menor: </h3> 
                   <div class="fecha" >
                        <h3>Día</h3>
                        <select name="dia" id="dia" required>
                        </select>
                   </div>
                   
                   <div class="fecha" >
                            <h3>Mes</h3>
                            <select name="mes"  required>
                            <option value="0">Ene</option>
                            <option value="1">Feb</option>
                            <option value="2">Mar</option>
                            <option value="3">Abr</option>
                            <option value="4">May</option>
                            <option value="5">Jun</option>
                            <option value="6">Jul</option>
                            <option value="7">Agu</option>
                            <option value="8">Sep</option>
                            <option value="9">Oct</option>
                            <option value="10">Nov</option>
                            <option value="11">Dic</option>
                            </select>
                    </div>
  
                    <div  class="fecha" >
                        <h3>Año</h3>
                        <select name="anio"  id="anios" required>
                        </select>
                    </div>
                    </div>
                    <div class="bloque">
                    <h3>Ingresar fecha Mayor: </h3> 
                    <div class="fecha">
                        <h3>Día</h3>
                        <select name="dia2" id="dia2" required>
                        </select>
                   </div>
                   
                   <div class="fecha" >
                            <h3>Mes</h3>
                            <select name="mes2"  required>
                            <option value="0">Ene</option>
                            <option value="1">Feb</option>
                            <option value="2">Mar</option>
                            <option value="3">Abr</option>
                            <option value="4">May</option>
                            <option value="5">Jun</option>
                            <option value="6">Jul</option>
                            <option value="7">Agu</option>
                            <option value="8">Sep</option>
                            <option value="9">Oct</option>
                            <option value="10">Nov</option>
                            <option value="11">Dic</option>
                            </select>
                    </div>
  
                    <div class="fecha" >
                        <h3>Año</h3>
                        <select name="anio2"  id="anios2" required>
                        </select>
                    </div>
                    </div>
                    <br/>
                    <br/>
                    <input class="enviarEli" type="submit" value="Buscar">
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