<%-- 
    Document   : outUser
    Created on : 11-09-2014, 21:12:08
    Author     : EdsonAlexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%  
            
        HttpSession sesion=request.getSession();
       
               
        if(session!=null) 
        {
            Cliente aux= new Cliente();
            sesion.setAttribute("usuario",aux);
            Carro carro= new Carro();
            carro.vaciarCarro();
            session.invalidate();
            
            response.sendRedirect("index.jsp");
        }
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
