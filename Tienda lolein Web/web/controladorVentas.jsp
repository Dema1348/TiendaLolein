<%-- 
    Document   : controladorVentas
    Created on : 12-09-2014, 2:27:40
    Author     : eds y ale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>

<%@ page import='java.util.Date' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="2;URL=outUser.jsp" >
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
        <jsp:useBean id="carroBean" scope="session" class="controlDb.Carro" />
        <title>Venta finalizada</title>
        <%
            
            int total=0, totalItems=0; 
            HttpSession sesion=request.getSession();
            total=Integer.parseInt(request.getParameter("Total"));
            Cliente cliente= (Cliente)sesion.getAttribute("usuario");
           if(sesion.getAttribute("Carro")!=null)
            {
            carroBean= (Carro)sesion.getAttribute("Carro");
            totalItems=carroBean.listar().size();
            }
           
           
            Date fecha = new Date();
            MantenedoraVentas ventas= new MantenedoraVentas();
            MantenedoraProductosVen productosVen= new MantenedoraProductosVen();
            MantenedoraProductos productosBodega= new MantenedoraProductos();
           Venta venta= new Venta((ventas.listar().size()+1), total, fecha,cliente);
           
           for(int i=0;i<totalItems;i++)
           {
             ProductosVendidos prodVen= new ProductosVendidos((productosVen.listar().size()+1),(ventas.listar().size()+1), carroBean.listar().get(i).getId(),carroBean.listar().get(i).getCantidad(), carroBean.listar().get(i).getPrecio());
             productosBodega.restarStock(carroBean.listar().get(i).getCantidad(), carroBean.listar().get(i).getId());
             productosVen.agregar(prodVen);
           }
         

            ventas.agregar(venta);
            
        %>
    </head>
    <body>
       
        <div class="cuerpo">
        <img src="img/lolein.png" alt="logo" class="lolein">
        <h2 class="carro">Carro de compras: <%=totalItems %></h2>
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
            <nav >
                <header>* LOLEIN, DUDE*</header>
                <ul >
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="tienda.jsp">Productos</a></li>
                    <li><a href="editarLista.jsp">Editar lista</a></li>
                    <li><a href="terminar.jsp">Finalizar Compra</a></li>
                    <li><a href="sobre.jsp">Sobre Nosotros</a></li>
                    <li><a href="ubicacion.jsp">Ubicacion</a></li>
                </ul>
            </nav>
        </div>
       
        <div class="contenido">
           
            <div class="productosWeb">
                <h2>* COMPRA EXITOSA  *</h2>
                <br/>
                <h3>Se ha registrado la venta  con folio N°: <%= venta.getId() %> correctamente. </h3>   
                <h3>Serás dirigido automáticamente en dos segundos. En caso contrario, puedes acceder haciendo click <a href="outUser.jsp">aquí</a></h3>
               
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
