<%-- 
    Document   : ResAgregar
    Created on : 12-09-2014, 01:59:37 AM
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
        <title>JSP Page</title>
    </head>
    <%! 
        String id, nombre,detalle;
        int stock, precio;
    %>
    <% 
        HttpSession sesion= request.getSession();
        MantenedoraProductos productosWeb = new MantenedoraProductos();
        id=request.getParameter("txtId");
        nombre=request.getParameter("txtNombre");
        precio= Integer.parseInt(request.getParameter("txtPrecio"));
        stock=Integer.parseInt(request.getParameter("txtStock"));
        detalle=request.getParameter("txtDetalle");
        int idFoto=0;
        if(Integer.parseInt(id)>22)
        {
         idFoto=((int)(Math.random()*22-0)+0);
        }
        else
            idFoto=Integer.parseInt(id);
        Producto pro= new Producto(Integer.parseInt(id), nombre, "foto"+idFoto+".jpg", detalle, precio, stock);
        productosWeb.agregar(pro);
        response.sendRedirect("Admin.jsp");
    %>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
