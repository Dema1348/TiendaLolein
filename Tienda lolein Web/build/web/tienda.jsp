<%-- 
    Document   : tienda
    Created on : 11-09-2014, 19:54:30
     Author     : eds y ale
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlDb.*" session="true"%>
<%@page import="modelo.*" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <script src="js/jquery-2.1.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <jsp:useBean id="carroBean" scope="session" class="controlDb.Carro" />
        <%! int indice=0;%>
          <%
          
            HttpSession sesion=request.getSession();
            int totalItems=0;
            if(sesion.getAttribute("Carro")!=null)
            {
            //carro= (Carro)sesion.getAttribute("Carro");
            totalItems=carroBean.listar().size();
            }
            else
            {
            //carro=new Carro();
            }
            
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
        <div class="contenedorMenuLogo" id="menuLogo">
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
           
            <div class="productosWeb">
                <h2>* ENCUENTRA LO QUE TU BUSCAS *</h2>
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
                        <h3>ID: <%= productosWeb.listar().get(i).getId() %> </h3>
                        <h3>Precio: $<%= productosWeb.listar().get(i).getPrecio() %></h3>
                        <h3>Stok: <%= productosWeb.listar().get(i).getStock() %></h3>
                        <a href="detalleProducto.jsp?Id=<%= productosWeb.listar().get(i).getId()%>">Agregar al carro</a>
                        </article>
                        <%
                    }
                                        

                   
                    
                    
                %>
                <div class="botones">
            <% if(!(indice==0))
              {
            %>
           
            <a href="tienda.jsp?I=<%= indice-8 %>"> Anterior</a>
            <%
            } %>


             <% if(!(indice>productosWeb.listar().size()-8))
            {
                %>
            <a href="tienda.jsp?I=<%= indice+8 %>">Siguiente </a>
            
            <%
            } %>                 
            </div>
              
                 
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
