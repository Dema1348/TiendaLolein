package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.*;
import controlDb.*;

public final class tablaAjax_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 MantenedoraProductosVen productosVen= new MantenedoraProductosVen(); MantenedoraVentas venta= new MantenedoraVentas(); boolean token=true; 
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
      response.setContentType("text/html");
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
      out.write("        ");
      out.write("\n");
      out.write("        ");

          HttpSession sesion=request.getSession();   
         int boleta= Integer.parseInt(request.getParameter("Boleta"));
         Cliente usuario= (Cliente)sesion.getAttribute("usuario");
         Venta ventaUser;
         ventaUser=venta.buscar(boleta);
         if(ventaUser==null)
             ventaUser= new Venta();
         
         
      out.write("\n");
      out.write("         <div class=\"contenido\">\n");
      out.write("         <div class=\"detalleCompra\">\n");
      out.write("         ");

         token=true;
         for(int i=0; i<productosVen.listar().size();i++ )
         {
             if(productosVen.listar().get(i).getIdVenta()==boleta && ventaUser.getRutCliente().getRut().equals(usuario.getRut()) ){
         
      out.write("\n");
      out.write("         <div class=\"listaCompra\" id=\"listaBorrar\"> \n");
      out.write("                    <h4>ID producto: ");
      out.print( productosVen.listar().get(i).getIdproducto() );
      out.write("</h4>\n");
      out.write("                    <h4>Precio: $");
      out.print( productosVen.listar().get(i).getPrecio() );
      out.write("</h4>\n");
      out.write("                    <h4>Cantidad: ");
      out.print( productosVen.listar().get(i).getCantidad() );
      out.write("</h4>      \n");
      out.write("                    <a class=\"editarCarro\" id=\"borraProducto\" href=\"#\" >Devolver producto/s </a>        \n");
      out.write("                </div>\n");
      out.write("        ");

            token=false;
             }
         }
         
         if(token)
         {
         
      out.write("\n");
      out.write("         <h3>Sin registro de ventas</h3>\n");
      out.write("         ");

         }
        
      out.write("\n");
      out.write("         </div>\n");
      out.write("         </div>\n");
      out.write("         <script language=\"javascript\" type=\"text/javascript\">\n");
      out.write("             alert('asd');\n");
      out.write("         </script>\n");
      out.write("     ");
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
