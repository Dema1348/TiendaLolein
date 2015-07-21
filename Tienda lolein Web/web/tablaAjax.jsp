<%-- 
    Document   : tablaAjax
    Created on : 24-10-2014, 0:09:33
    Author     : EdsonAlexander
--%>


<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>
        <%! MantenedoraProductosVen productosVen= new MantenedoraProductosVen(); MantenedoraVentas venta= new MantenedoraVentas(); boolean token=true; %>
        <%
          HttpSession sesion=request.getSession();   
          int boleta;
          try{
         boleta= Integer.parseInt(request.getParameter("Boleta"));
          }
          catch(Exception exx)
          {
          boleta=-1;
          }
         Cliente usuario= (Cliente)sesion.getAttribute("usuario");
         Venta ventaUser;
         ventaUser=venta.buscar(boleta);
         if(ventaUser==null)
             ventaUser= new Venta();
         
         %>
         <div class="contenido">
             <div class="detalleCompra" style="width: 900px;">
         <%
         token=true;
         for(int i=0; i<productosVen.listar().size();i++ )
         {
             if(productosVen.listar().get(i).getIdVenta()==boleta && ventaUser.getRutCliente().getRut().equals(usuario.getRut()) && productosVen.listar().get(i).getPrecio()!=0 ){
         %>
         <div class="listaCompra" id="listaBorrar" > 
                    <h4>ID transacción: <%= productosVen.listar().get(i).getId() %></h4>
                    <h4>ID producto: <%= productosVen.listar().get(i).getIdproducto() %></h4>
                    <h4>Precio: $<%= productosVen.listar().get(i).getPrecio() %></h4>
                    <h4>Cantidad: <%= productosVen.listar().get(i).getCantidad() %></h4>      
                 <%--    <a class="editarCarro" id="borraProducto" href="#" >Devolver producto/s </a>     --%>   
                </div>
        <%
            token=false;
             }
         }
         
         if(token)
         {
         %>
         <h3>Sin registro de ventas</h3>
         <%
         }
        %>
         </div>
         </div>
         
     