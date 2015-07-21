<%-- 
    Document   : editarBorrar
    Created on : 14-09-2014, 23:12:51
    Author     : EdsonAlexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%

            HttpSession sesion=request.getSession();
            Carro carro;
            
            carro= (Carro)sesion.getAttribute("Carro");
            if(carro!=null)
            carro.eliminar(Integer.parseInt(request.getParameter("Id")));
            
            sesion.setAttribute("Carro",carro );
            
            response.sendRedirect("editarLista.jsp");
           
            
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>