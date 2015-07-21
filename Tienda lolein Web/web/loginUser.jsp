<%-- 
    Document   : controlador
    Created on : 11-09-2014, 21:06:04
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
        MantenedoraClientes clientes=new MantenedoraClientes();
        HttpSession sesion=request.getSession();
        String usu, pass;
        Cliente aux= new Cliente();
        usu = request.getParameter("user");
        pass=request.getParameter("password");
        String msg="";
        
         if( sesion.getAttribute("usuario")==null)
         {
            
        try
        {
           
          
            
        for(int i=0;i<clientes.listar().size();i++)
            {
              if(usu.compareToIgnoreCase(clientes.listar().get(i).getRut())==0 && 
               pass.equals(clientes.listar().get(i).getPass()) )
               {  
                if(clientes.listar().get(i).getRut().equals("1-1") && clientes.listar().get(i).getPass().equals("1111"))
                    {
                        aux=clientes.listar().get(i);
                        sesion.setAttribute("usuario",aux );
                         response.sendRedirect("Admin.jsp");
                    }  
                  
                aux=clientes.listar().get(i);
                sesion.setAttribute("usuario",aux );
                response.sendRedirect("tienda.jsp");
             
                
                }
              

 
   
        }
        
         response.sendRedirect("index.jsp?Invalido=error");
        
        }catch(Exception ev)
        {
            msg=ev.getMessage();
        }
        }
         
         else
         {
             response.sendRedirect("errorConsulta.jsp");
         }
        %>
    </head>
    <body>
        <h1><%= aux.toString() %></h1>
    </body>
</html>
