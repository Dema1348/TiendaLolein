<%-- 
    Document   : controladorCarro
    Created on : 11-09-2014, 23:49:59
    Author     : EdsonAlexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="carroBean" scope="session" class="controlDb.Carro" />
        <title>JSP Page</title>
        <%

            HttpSession sesion=request.getSession();
            MantenedoraProductos productos= new MantenedoraProductos();
            Producto item;
            int cantidad=0;
            item= productos.buscar(Integer.parseInt(request.getParameter("Id")));
            //Carro carro;
            //carro=(Carro)sesion.getAttribute("Carro");
            
            if(carroBean!=null){
            cantidad=Integer.parseInt(request.getParameter("cantidad"));
            ProductoCarro procLista= new ProductoCarro(item.getId() , item.getNombreProducto() ,  item.getFoto() , item.getDetalle() , item.getPrecio()*cantidad, cantidad);
            carroBean.agregar(procLista);
            }
            else
            {
            //carro= new Carro();
            cantidad=Integer.parseInt(request.getParameter("cantidad"));
            ProductoCarro procLista= new ProductoCarro(item.getId() , item.getNombreProducto() ,  item.getFoto() , item.getDetalle() , item.getPrecio()*cantidad, cantidad);
            carroBean.agregar(procLista);
            }
            
            sesion.setAttribute("Carro",carroBean);
            
            response.sendRedirect("tienda.jsp");
           
            
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
