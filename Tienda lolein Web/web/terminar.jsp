<%-- 
    Document   : terminar
    Created on : 12-09-2014, 1:46:39
    Author     : EdsonAlexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="js/jquery-2.1.1.min.js"></script>
        <title>Terminar compra</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <jsp:useBean id="carroBean" scope="session" class="controlDb.Carro" />
          <%
          
            HttpSession sesion=request.getSession();
            int totalItems=0;
            carroBean= (Carro)sesion.getAttribute("Carro");
            if(sesion.getAttribute("Carro")!=null)
            {
            carroBean = (Carro)sesion.getAttribute("Carro");
            totalItems=carroBean.listar().size();
            }
           
            
        %>
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    </head>
    <body>
    <div class="cuerpo">
        <img src="img/lolein.png" alt="logo" class="lolein">
        <h2 class="carro">Carro de compras: <%= totalItems %></h2>
         <div id="datosProduc"> </div>
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
                <h3><a href="#"  class="publicar"> Devolver producto</a></h3>
                <form id="formulario" style="display:none;">
                     <h3> Codigo de boleta</h3>
                     <input type="text" placeholder="N° boleta" name="numero">
                     <input id="enviarBoleta" type="submit" value="Enviar" name="numero">
                     
                 </form>
                <form id="formulario2" style="display:none;">
                     <h3> Codigo de transaccion</h3>
                     <input type="text" placeholder="N° transaccion" name="numeroT">
                      <input type="text" placeholder="Cantidad de devolucion" name="numeroD">
                     <input id="enviaTransaccion" type="submit" value="Enviar" name="numeroT">
                     
                </form>   
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
                    <li><a href="editarLista.jsp">Editar lista</a></li>
                    <li><a href="terminar.jsp">Finalizar Compra</a></li>
                    <li><a href="sobre.jsp">Sobre Nosotros</a></li>
                    <li><a href="ubicacion.jsp">Ubicacion</a></li>
                </ul>
            </nav>
        </div>
         
        <%  if(sesion.getAttribute("usuario")!=null)
        {
            
        %>    
        <div class="contenido">
           
            <div class="detalleCompra">
                <h2>* GRACIAS POR PREFERIRNOS *</h2>
                <h2>Resumen de compra</h2>
                <%
                    int total=0;
                    int tamano;
                    if(carroBean==null)
                    {
                    tamano=0;
                    }
                    else
                        tamano= carroBean.listar().size();
                   for(int i=0; i< tamano;i++)
                   {
                      total+=carroBean.listar().get(i).getPrecio();
                      
                %>
                <div class="listaCompra">
                    <h3>Producto N°<%= i+1%></h3>
                    <h4>Nombre: <%= carroBean.listar().get(i).getNombreProducto() %></h4>
                    <h4>Costo: $<%= carroBean.listar().get(i).getPrecio() %></h4>
                    <h4>ID: <%= Integer.toString(carroBean.listar().get(i).getId()) %></h4>
                     <h4>Cantidad: <%= carroBean.listar().get(i).getCantidad() %></h4>
                </div>
                 <%
                    }
                 %>
                 <div class="total">
                     <h1> Precio final: $<%= total %></h1>
                 </div>
                     <% if(total!=0){
                     %>
                     <a href="controladorVentas.jsp?Total=<%= total %>">Comprar</a>
                     <%
                     }
                     %>
                 
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
        <%
                    
        } 
        
        else
        {
        %>
        <div class="contenido">
             <div class="productosWeb">
            <img class="sesionPlz" src="img/sinSesion.png" >
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
        
        <%
        }
        
        %>
        
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
      <script type="text/javascript">
            
       function cambiarDisplay()
            {
                $('#formulario').slideToggle();
                 $('#formulario2').slideUp();
                
            }
            function  capturarBoleta(ev)
            {
                ev.preventDefault();
                var idboleta= $('input[name=numero]').val();
                $('#formulario').slideToggle();
                console.log(idboleta);
                var conexion;
                conexion= new XMLHttpRequest();   
                conexion.open("GET","tablaAjax.jsp?Boleta="+idboleta,true);
                conexion.onreadystatechange= function ()
                {
                    if(conexion.readyState == 4 && conexion.status == 200)
                    {
                      document.getElementById("datosProduc").innerHTML=conexion.responseText;
                     
                    }
                    
                };
               

                $('#formulario2').slideDown(); 
                conexion.send();
               
                
                
             
                 
            }
       
         function capturarT(ev)
         {
               ev.preventDefault();
               var idT= $('input[name=numeroT]').val();
               var can= $('input[name=numeroD]').val();
               $('#formulario2').slideToggle();
                var conexion;
                conexion= new XMLHttpRequest();   
                conexion.open("GET","eliminarT.jsp?Trans="+idT+"&Can="+can,true);
                conexion.onreadystatechange= function ()
                {
                    if(conexion.readyState == 4 && conexion.status == 200)
                    {
                      document.getElementById("datosProduc").innerHTML=conexion.responseText;
                     
                    }
                    
                };
                
                 conexion.send();
         }
       
          $(function (){
              $('.publicar').on('click', cambiarDisplay);
              $('#enviarBoleta').on('click',capturarBoleta);
              $('#enviaTransaccion').on('click',capturarT);
              
          });
          
        
        </script>
    </body>
</html>