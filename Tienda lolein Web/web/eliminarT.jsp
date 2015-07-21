<%-- 
    Document   : eliminarT
    Created on : 24-10-2014, 12:48:11
    Author     : EdsonAlexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>
<%! MantenedoraProductosVen productosVen= new MantenedoraProductosVen(); MantenedoraVentas venta= new MantenedoraVentas(); boolean token=true; %>
  
<%
    int idTran;
    int cant;
    try{
    idTran= Integer.parseInt(request.getParameter("Trans"));
    cant= Integer.parseInt(request.getParameter("Can"));
    }
    catch(Exception exx)
    {
    idTran=-1;
    cant=-1;
    }
    
    
    if(productosVen.rollback(idTran, cant)){
        %>
        <h3>Elimando correctamente</h3>   
<%
    }
    else
    {
    %>
        <h3>Sin exito al eliminar</h3>  
        <%
    }
%>

