<%-- 
    Document   : cambiarListaCant
    Created on : 24-10-2014, 18:47:19
    Author     : EdsonAlexander
--%>
<%@page import="modelo.*" session="true"%>
<%@page import="controlDb.*" session="true"%>
<jsp:useBean id="carroBean" scope="session" class="controlDb.Carro" />
<%
  
        HttpSession sesion=request.getSession();   
        int cantidad;
        int precioNew=0;
        int id;
        try{
            cantidad= Integer.parseInt(request.getParameter("Cantidad"));
            id= Integer.parseInt(request.getParameter("IdPro"));
        }
        catch(Exception exx)
        {
            cantidad=-1;
            id=-1;
        }   
        if(cantidad>0){
         precioNew=carroBean.modificarCantidad(id, cantidad);
        }
        
        
%>

<%= precioNew %>
