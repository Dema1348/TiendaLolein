package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.*;
import controlDb.*;
import java.util.*;

public final class Agregar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilo.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/normalize.css\">\n");
      out.write("        <title>Agregar</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        HttpSession sesion= request.getSession();
        MantenedoraProductos productos= new MantenedoraProductos();
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("\t<div class=\"cuerpo\">\n");
      out.write("\t\t<img src=\"img/lolein.png\" alt=\"logo\" class=\"lolein\">\n");
      out.write("\t\t<h2 class=\"carro\">Carro de compras: 0</h2>\n");
      out.write("                ");
 if(sesion.getAttribute("usuario")==null){
                
      out.write("\n");
      out.write("                <div class=\"logeo\">\n");
      out.write("\t\t\t<h5 class=\"bienvenido\">Bienvenido/a, </h5>\n");
      out.write("\t\t\t<a class=\"registracion\" href=\"#\">Regístrate aquí</a>\n");
      out.write("                        <form action=\"loginUser.jsp\" method=\"POST\" >\n");
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
      out.write("\t\t</div>\n");
      out.write("                ");

                }    
                else {
                    Cliente usuario= (Cliente)sesion.getAttribute("usuario");
                
      out.write("\n");
      out.write("                <div class=\"logeo\">\n");
      out.write("\t\t\t<h5 class=\"bienvenido\">Bienvenido/a, ");
      out.print( usuario.getNombre() );
      out.write("</h5>\n");
      out.write("                        <a href=\"outUser.jsp\" class=\"entrar\" >Salir </a>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("                ");

                }
                    
                
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"contenedorMenuLogo\">\n");
      out.write("\t\t\t<nav>\n");
      out.write("\t\t\t\t<header>* LOLEIN, DUDE*</header>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("                                     <li><a href=\"Admin.jsp\">Modificar</a></li>\n");
      out.write("                                    <li><a href=\"Buscar.jsp\">Buscar por ID</a></li>\n");
      out.write("                                    <li><a href=\"Fecha.jsp\">Buscar Venta por Fecha</a></li>\n");
      out.write("                                    <li><a href=\"RangoFecha.jsp\">Buscar Venta por Rango de Fecha</a></li>\n");
      out.write("                                    <li><a href=\"Agregar.jsp\">Agregar</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("        <div class=\"contenido\">\n");
      out.write("           <div class=\"productosWeb\">\n");
      out.write("                <h2>* AGREGA TUS PRODUCTOS *</h2>\n");
      out.write("                <form action=\"ResAgregar.jsp\" method=\"post\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <h3>ID:</h3>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"number\" min=\"");
      out.print(productos.listar().size()+1 );
      out.write("\" name=\"txtId\" required >\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <h3>Nombre:</h3>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                 <input type=\"text\" name=\"txtNombre\" required >\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <h3>Precio:</h3>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"number\" min=\"0\" name=\"txtPrecio\" required >\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <h3>Stock:</h3>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                 <input type=\"number\" min=\"0\" name=\"txtStock\" required >\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                         <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <h3>Detalle:</h3>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                 <input type=\"text\" name=\"txtDetalle\" required >\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    <input class=\"enviarEli\" type=\"submit\" value=\"Agregar\">\n");
      out.write("                    <input class=\"enviarEli\" type=\"reset\" value=\"Cancelar\">\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("              \n");
      out.write("                <div class=\"divisor\"></div>\n");
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
      out.write("        \n");
      out.write("        <footer>\n");
      out.write("                <div class=\"direccion\">\n");
      out.write("                        <h4>Visitenos</h4>\n");
      out.write("                        <h6>Covadonga 634, San Bernardo, Región Metropolitana Tel: 1-800-000-0000 Fax: 123-456-7890</h6>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"ayuda\">\n");
      out.write("                        <h4>¿Necesita ayuda?</h4>\n");
      out.write("                        <h6>Preguntenos y envienos un correo a tiendaLolein@gmail.com</h6>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"moneda\">\n");
      out.write("                        <h4>Nosotros aceptamos</h4>\n");
      out.write("                        <img src=\"img/tarjetas.png\" alt=\"\" class=\"tarjetas\">\n");
      out.write("                </div>\n");
      out.write("                <h5 class=\"diseñador\">© 2014 by Edson Pérez and Alejandro Soto </h5>\n");
      out.write("        </footer>\t\n");
      out.write("    </div>\n");
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
