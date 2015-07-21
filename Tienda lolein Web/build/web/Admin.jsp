<%-- 
    Document   : loginAdmin
    Created on : 11-09-2014, 10:56:34 PM
   Author     : eds y ale
--%>

<%@page import="controlDb.*"%>
<%@page import="modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
         <%! int indice=0;%>
         <%
          
            HttpSession sesion=request.getSession();
            try{
            indice=Integer.parseInt(request.getParameter("I"));
            }
            catch(Exception erro)
            {
                indice=0;
            }
           
        %>
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    </head>
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
                <h2>* MODIFICA TUS PRODUCTOS *</h2>
                <% 
                   MantenedoraProductos productosWeb= new MantenedoraProductos();
                    int aux=0;
                    if(productosWeb.listar().size()<indice+8 )
                    {
                        aux=productosWeb.listar().size();
                    }

                    else
                        aux=indice+8;
                    
                    for(int i=indice; i< aux;i++)
                    {
                        %>
                        
                        <article>
                            <img src="img/<%= productosWeb.listar().get(i).getFoto() %>" alt="Producto">
                        <div class="modificarD">
                        <form action="Modificar.jsp" method="post">
                            <h3>ID: </h3><input type="text" value="<%= productosWeb.listar().get(i).getId() %>" name="id" readonly><br/>
                            <h3>Nombre: </h3><input type="text" value="<%= productosWeb.listar().get(i).getNombreProducto() %>" name="nombre"><br/>
                            <h3>Precio: </h3><input type="text" value="<%= productosWeb.listar().get(i).getPrecio() %>" name="precio"><br/>
                            <h3>Stok: </h3><input type="text" value="<%= productosWeb.listar().get(i).getStock() %>" name="stock"><br/>
                            <h3>Detalle: </h3><input type="text" value="<%= productosWeb.listar().get(i).getDetalle() %>"  name="detalle"><br/>
                            <h3>Ruta: </h3><input type="text" value="<%= productosWeb.listar().get(i).getFoto() %>"  name="ruta" hidden=""><br/>
                        <input class="enviarM" type="submit" value="Modificar">
                        </form>
                        </div>
                        <a class="enviarEli" href="EliminarProducto.jsp?ID=<%= productosWeb.listar().get(i).getId() %>">Eliminar</a>
                        </article>
                        <%
                    }
                   
                    
                %>
                 <div class="botones">
            <% if(!(indice==0))
              {
            %>
           
            <a href="Admin.jsp?I=<%= indice-8 %>"> Anterior</a>
            <%
            } %>


             <% if(!(indice>productosWeb.listar().size()-8))
            {
                %>
                <a href="Admin.jsp?I=<%= indice+8 %>">Siguiente </a>
            
            <%
            } %>                 
              
                
            </div>
             <div class="divisor"></div>
        </div>
        
        
        <footer>
            <div class="direccion">
                <h4>Visitenos</h4>
                <h6>500 Terry Francois St. San Francisco, CA 94158Tel: 1-800-000-0000 Fax: 123-456-7890</h6>
            </div>

            <div class="ayuda">
                <h4>¿Necesita ayuda?</h4>
                <h6>Preguntenos y envienos un correo a 123test@gmailcom</h6>
            </div>

            <div class="moneda">
                <h4>Nosotros aceptamos</h4>
                <img src="img/tarjetas.png" alt="" class="tarjetas">
            </div>
            <h5 class="diseñador">© 20214 by Edson Pérez </h5>
        </footer>   
    </div>
    </body>
</html>
