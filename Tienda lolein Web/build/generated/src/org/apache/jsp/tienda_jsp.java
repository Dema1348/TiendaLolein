package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controlDb.*;
import modelo.*;

public final class tienda_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int indice=0;
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Productos</title>\n");
      out.write("        <script src=\"js/jquery-2.1.1.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilo.css\">\n");
      out.write("        ");
      controlDb.Carro carroBean = null;
      synchronized (session) {
        carroBean = (controlDb.Carro) _jspx_page_context.getAttribute("carroBean", PageContext.SESSION_SCOPE);
        if (carroBean == null){
          carroBean = new controlDb.Carro();
          _jspx_page_context.setAttribute("carroBean", carroBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("          ");

          
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
           
        
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/normalize.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <div class=\"cuerpo\">\n");
      out.write("        <img src=\"img/lolein.png\" alt=\"logo\" class=\"lolein\">\n");
      out.write("        <h2 class=\"carro\">Carro de compras: ");
      out.print( totalItems );
      out.write("</h2>\n");
      out.write("         <div id=\"datosProduc\"> </div>\n");
      out.write("       \n");
      out.write("       ");
 if(sesion.getAttribute("usuario")==null){
        
      out.write("\n");
      out.write("        <div class=\"logeo\">\n");
      out.write("                <h5 class=\"bienvenido\">Bienvenido/a, </h5>\n");
      out.write("                <a class=\"registracion\" href=\"Registro.jsp\">Regístrate aquí</a>\n");
      out.write("                <form action=\"loginUser.jsp\" method=\"POST\" >\n");
      out.write("                    ");
 if((Integer)sesion.getAttribute("intento")<3){ 
      out.write("\n");
      out.write("                    <input type=\"text\" name=\"user\"  required placeholder=\"Usuario\" >\n");
      out.write("                    <input type=\"password\" name=\"password\"  required placeholder=\"contraseña\">\n");
      out.write("                    <input class=\"entrar\" type=\"submit\" name=\"entrar\" value=\"Enviar\">\n");
      out.write("\n");
      out.write("                    ");
} 
                    else
                    {
                    
      out.write("\n");
      out.write("                    <input type=\"text\" name=\"user\"  required placeholder=\"Usuario\" readonly>\n");
      out.write("                    <input type=\"password\" name=\"password\"  required placeholder=\"contraseña\" readonly>\n");
      out.write("                    <input class=\"entrar\" type=\"submit\" name=\"entrar\" value=\"Enviar\" readonly>\n");
      out.write("                    Usuario bloqueado por 24 horas\n");
      out.write("                    ");

                    }
                    
      out.write("\n");
      out.write("                </form>\n");
      out.write("        </div>\n");
      out.write("        ");

        }    
        else {
            Cliente usuario= (Cliente)sesion.getAttribute("usuario");
        
      out.write("\n");
      out.write("        <div class=\"logeo\">\n");
      out.write("                <h5 class=\"bienvenido\">Bienvenido/a, ");
      out.print( usuario.getNombre() );
      out.write("</h5>\n");
      out.write("                <a href=\"outUser.jsp\" class=\"entrar\" >Salir </a>\n");
      out.write("                <h3><a href=\"#\"  class=\"publicar\"> Devolver producto</a></h3>\n");
      out.write("                <form id=\"formulario\" style=\"display:none;\">\n");
      out.write("                     <h3> Codigo de boleta</h3>\n");
      out.write("                     <input type=\"text\" placeholder=\"N° boleta\" name=\"numero\">\n");
      out.write("                     <input id=\"enviarBoleta\" type=\"submit\" value=\"Enviar\" name=\"numero\">\n");
      out.write("                     \n");
      out.write("                 </form>\n");
      out.write("                <form id=\"formulario2\" style=\"display:none;\">\n");
      out.write("                     <h3> Codigo de transaccion</h3>\n");
      out.write("                     <input type=\"text\" placeholder=\"N° transaccion\" name=\"numeroT\">\n");
      out.write("                      <input type=\"text\" placeholder=\"Cantidad de devolucion\" name=\"numeroD\">\n");
      out.write("                     <input id=\"enviaTransaccion\" type=\"submit\" value=\"Enviar\" name=\"numeroT\">\n");
      out.write("                     \n");
      out.write("                 </form>\n");
      out.write("               \n");
      out.write("        </div>\n");
      out.write("        ");

        }

        
      out.write("\n");
      out.write("        <div class=\"contenedorMenuLogo\" id=\"menuLogo\">\n");
      out.write("            <nav>\n");
      out.write("                <header>* LOLEIN, DUDE*</header>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"index.jsp\">Inicio</a></li>\n");
      out.write("                    <li><a href=\"tienda.jsp\">Productos</a></li>\n");
      out.write("                    <li><a href=\"editarLista.jsp\">Editar lista</a></li>\n");
      out.write("                    <li><a href=\"terminar.jsp\">Finalizar Compra</a></li>\n");
      out.write("                    <li><a href=\"sobre.jsp\">Sobre Nosotros</a></li>\n");
      out.write("                    <li><a href=\"ubicacion.jsp\">Ubicacion</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("         \n");
      out.write("        ");
  if(sesion.getAttribute("usuario")!=null)
        {
            
        
      out.write("    \n");
      out.write("        <div class=\"contenido\">\n");
      out.write("           \n");
      out.write("            <div class=\"productosWeb\">\n");
      out.write("                <h2>* ENCUENTRA LO QUE TU BUSCAS *</h2>\n");
      out.write("                ");
 
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
                        
      out.write("\n");
      out.write("                        <article>\n");
      out.write("                            \n");
      out.write("                        <img src=\"img/");
      out.print( productosWeb.listar().get(i).getFoto() );
      out.write("\" alt=\"Producto\"> \n");
      out.write("                        <h3>ID: ");
      out.print( productosWeb.listar().get(i).getId() );
      out.write(" </h3>\n");
      out.write("                        <h3>Precio: $");
      out.print( productosWeb.listar().get(i).getPrecio() );
      out.write("</h3>\n");
      out.write("                        <h3>Stok: ");
      out.print( productosWeb.listar().get(i).getStock() );
      out.write("</h3>\n");
      out.write("                        <a href=\"detalleProducto.jsp?Id=");
      out.print( productosWeb.listar().get(i).getId());
      out.write("\">Agregar al carro</a>\n");
      out.write("                        </article>\n");
      out.write("                        ");

                    }
                                        

                   
                    
                    
                
      out.write("\n");
      out.write("                <div class=\"botones\">\n");
      out.write("            ");
 if(!(indice==0))
              {
            
      out.write("\n");
      out.write("           \n");
      out.write("            <a href=\"tienda.jsp?I=");
      out.print( indice-8 );
      out.write("\"> Anterior</a>\n");
      out.write("            ");

            } 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("             ");
 if(!(indice>productosWeb.listar().size()-8))
            {
                
      out.write("\n");
      out.write("            <a href=\"tienda.jsp?I=");
      out.print( indice+8 );
      out.write("\">Siguiente </a>\n");
      out.write("            \n");
      out.write("            ");

            } 
      out.write("                 \n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("                 \n");
      out.write("                  <div class=\"divisor\"></div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("           \n");
      out.write("           \n");
      out.write("            <div class=\"mensaje\">\n");
      out.write("                <h2 class=\"frase\">¿PORQUE COMPRAR EN LA TIENDA LOLEIN?</h2>\n");
      out.write("                <div class=\"frases\">\n");
      out.write("                    <p>LOS MEJORES PRECIOS- GARANTIZADO!</p>\n");
      out.write("                    <p>10 AÑOS DE EXPERIENCIA</p>\n");
      out.write("                    <p>VARIEDAD DE PRODUCTOS</p>\n");
      out.write("                    <p>FEEDBACK PERMANENTE CON NUESTROS COMPRADORES</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

                    
        } 
        
        else
        {
        
      out.write("\n");
      out.write("        <div class=\"contenido\">\n");
      out.write("             <div class=\"productosWeb\">\n");
      out.write("            <img class=\"sesionPlz\" src=\"img/sinSesion.png\" >\n");
      out.write("            <div class=\"divisor\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mensaje\">\n");
      out.write("                        <h2 class=\"frase\">¿PORQUE COMPRAR EN LA TIENDA LOLEIN?</h2>\n");
      out.write("                        <div class=\"frases\">\n");
      out.write("                        <p>LOS MEJORES PRECIOS- GARANTIZADO!</p>\n");
      out.write("                        <p>10 AÑOS DE EXPERIENCIA</p>\n");
      out.write("                        <p>VARIEDAD DE PRODUCTOS</p>\n");
      out.write("                        <p>FEEDBACK PERMANENTE CON NUESTROS COMPRADORES</p>\n");
      out.write("                        </div>\n");
      out.write("            </div>    \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");

        }
        
        
      out.write("\n");
      out.write("        \n");
      out.write("        <footer>\n");
      out.write("\t\t\t<div class=\"direccion\">\n");
      out.write("\t\t\t\t<h4>Visitenos</h4>\n");
      out.write("\t\t\t\t<h6>Covadonga 634, San Bernardo, Región Metropolitana Tel: 1-800-000-0000 Fax: 123-456-7890</h6>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"ayuda\">\n");
      out.write("\t\t\t\t<h4>¿Necesita ayuda?</h4>\n");
      out.write("\t\t\t\t<h6>Preguntenos y envienos un correo a tiendaLolein@gmail.com</h6>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"moneda\">\n");
      out.write("\t\t\t\t<h4>Nosotros aceptamos</h4>\n");
      out.write("\t\t\t\t<img src=\"img/tarjetas.png\" alt=\"\" class=\"tarjetas\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<h5 class=\"diseñador\">© 2014 by Edson Pérez and Alejandro Soto </h5>\n");
      out.write("\t\t</footer>\t\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("       function cambiarDisplay()\n");
      out.write("            {\n");
      out.write("                $('#formulario').slideToggle();\n");
      out.write("                 $('#formulario2').slideUp();\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            function  capturarBoleta(ev)\n");
      out.write("            {\n");
      out.write("                ev.preventDefault();\n");
      out.write("                var idboleta= $('input[name=numero]').val();\n");
      out.write("                $('#formulario').slideToggle();\n");
      out.write("                console.log(idboleta);\n");
      out.write("                var conexion;\n");
      out.write("                conexion= new XMLHttpRequest();   \n");
      out.write("                conexion.open(\"GET\",\"tablaAjax.jsp?Boleta=\"+idboleta,true);\n");
      out.write("                conexion.onreadystatechange= function ()\n");
      out.write("                {\n");
      out.write("                    if(conexion.readyState == 4 && conexion.status == 200)\n");
      out.write("                    {\n");
      out.write("                      document.getElementById(\"datosProduc\").innerHTML=conexion.responseText;\n");
      out.write("                     \n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                };\n");
      out.write("               \n");
      out.write("\n");
      out.write("                $('#formulario2').slideDown(); \n");
      out.write("                conexion.send();\n");
      out.write("               \n");
      out.write("                \n");
      out.write("                \n");
      out.write("             \n");
      out.write("                 \n");
      out.write("            }\n");
      out.write("       \n");
      out.write("         function capturarT(ev)\n");
      out.write("         {\n");
      out.write("               ev.preventDefault();\n");
      out.write("               var idT= $('input[name=numeroT]').val();\n");
      out.write("               var can= $('input[name=numeroD]').val();\n");
      out.write("               $('#formulario2').slideToggle();\n");
      out.write("                var conexion;\n");
      out.write("                conexion= new XMLHttpRequest();   \n");
      out.write("                conexion.open(\"GET\",\"eliminarT.jsp?Trans=\"+idT+\"&Can=\"+can,true);\n");
      out.write("                conexion.onreadystatechange= function ()\n");
      out.write("                {\n");
      out.write("                    if(conexion.readyState == 4 && conexion.status == 200)\n");
      out.write("                    {\n");
      out.write("                      document.getElementById(\"datosProduc\").innerHTML=conexion.responseText;\n");
      out.write("                     \n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                };\n");
      out.write("                \n");
      out.write("                 conexion.send();\n");
      out.write("         }\n");
      out.write("       \n");
      out.write("          $(function (){\n");
      out.write("              $('.publicar').on('click', cambiarDisplay);\n");
      out.write("              $('#enviarBoleta').on('click',capturarBoleta);\n");
      out.write("              $('#enviaTransaccion').on('click',capturarT);\n");
      out.write("              \n");
      out.write("          });\n");
      out.write("          \n");
      out.write("        \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
