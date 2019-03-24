package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ipn.mx.geneticos.modelo.dto.Route;
import com.ipn.mx.geneticos.modelo.dto.Route;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/shared/header.jsp");
    _jspx_dependants.add("/shared/navbar.jsp");
    _jspx_dependants.add("/shared/footer.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Dashboard</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(Route.STATIC);
      out.write("/css/bootstrap.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(Route.STATIC);
      out.write("/css/index.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(Route.STATIC);
      out.write("/css/Pe-icon-7-stroke.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(Route.STATIC);
      out.write("/css/animate.min.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Navbar -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"navbar navbar-expand-lg fixed-top navbar-light bg-white\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <a href=\"dashboard.jsp\" class=\"navbar-brand\">IPN</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("            <ul class=\"navbar-nav\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"");
      out.print(Route.PATH);
      out.write("/index.jsp\">Inicio <span class=\"pe-7s-home\"></span></a>\n");
      out.write("                </li>\n");
      out.write("                \n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" id=\"themes\">Ejercicios<span class=\"caret\"></span></a>\n");
      out.write("                    <div class=\"dropdown-menu\" aria-labelledby=\"themes\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"");
      out.print(Route.PATH);
      out.write("/view/ejercicios/quicksort.jsp\">Quicksort</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"");
      out.print(Route.PATH);
      out.write("/view/ejercicios/grafica.jsp\">Gráfica</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"");
      out.print(Route.PATH);
      out.write("/view/ejercicios/tiposDatos.jsp\">Tipos de Datos</a>\n");
      out.write("                        <!--<div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"agregarCarrera.jsp\">Agregar carrera</a>-->\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                \n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" id=\"themes\">Tecnicas<span class=\"caret\"></span></a>\n");
      out.write("                    <div class=\"dropdown-menu\" aria-labelledby=\"themes\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"");
      out.print(Route.PATH);
      out.write("/view/tecnicas/ruleta.jsp\">Ruleta</a>\n");
      out.write("                        <!--<a class=\"dropdown-item\" href=\"datos.jsp\">Ver alumnos por carrera</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"agregarCarrera.jsp\">Agregar carrera</a>-->\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("            <ul class=\"nav navbar-nav ml-auto\">\n");
      out.write("                <!--<li class=\"nav-item\">\n");
      out.write("                  <a class=\"nav-link\" href=\"https://wrapbootstrap.com/?ref=bsw\" target=\"_blank\">ESCOM</a>\n");
      out.write("                </li>-->\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" id=\"themes\">Opciones<span class=\"caret\"></span></a>\n");
      out.write("                    <div class=\"dropdown-menu\" aria-labelledby=\"themes\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"mostrarCarreras.jsp\">Ver perfil</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"index.jsp\">Cerrar sesión</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container animated fadeIn delay-10ms\">\n");
      out.write("            <div class=\"row \">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <h2>Ejercicios</h2>\n");
      out.write("                    <hr>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 col-xs-12\">\n");
      out.write("                    <div class=\"card border-info mb-3\" style=\"max-width: 20rem;\">\n");
      out.write("                        <div class=\"card-header\"> </div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                          <h4 class=\"card-title\">Quicksort</h4>\n");
      out.write("                          <p class=\"card-text\">Algoritmo de ordenamiento.</p>\n");
      out.write("                          <a href=\"view/ejercicios/quicksort.jsp\" class=\"btn btn-lg btn-outline-info btn-block\">Revisar</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 col-xs-12 \">\n");
      out.write("                    <div class=\"card border-warning mb-3\" style=\"max-width: 20rem;\">\n");
      out.write("                        <div class=\"card-header\"></div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                          <h4 class=\"card-title\">Gráfica</h4>\n");
      out.write("                          <p class=\"card-text\">Datos random y gráfica de los datos.</p>\n");
      out.write("                          <a href=\"view/ejercicios/grafica.jsp\" class=\"btn btn-lg btn-outline-warning btn-block\">Revisar</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 col-xs-12\">\n");
      out.write("                    <div class=\"card border-success mb-3\" style=\"max-width: 20rem;\">\n");
      out.write("                        <div class=\"card-header\"></div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                          <h4 class=\"card-title\">Tipos de datos</h4>\n");
      out.write("                          <p class=\"card-text\">Enteros, flotante, cadena bits y gray.</p>\n");
      out.write("                          <a href=\"view/ejercicios/tiposDatos.jsp\" class=\"btn btn-lg btn-outline-success btn-block\">Revisar</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row \">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <h2>Técnicas</h2>\n");
      out.write("                    <hr>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 col-xs-12\">\n");
      out.write("                    <div class=\"card border-info mb-3\" style=\"max-width: 20rem;\">\n");
      out.write("                        <div class=\"card-header\"> </div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                          <h4 class=\"card-title\">Ruleta</h4>\n");
      out.write("                          <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\n");
      out.write("                          <a href=\"view/tecnicas/ruleta.jsp\" class=\"btn btn-lg btn-outline-info btn-block\">Revisar</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 col-xs-12\">\n");
      out.write("                    <div class=\"card border-warning mb-3\" style=\"max-width: 20rem;\">\n");
      out.write("                        <div class=\"card-header\"></div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                          <h4 class=\"card-title\">Articulo</h4>\n");
      out.write("                          <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\n");
      out.write("                          <a href=\"mostrarArticulos.jsp\" class=\"btn btn-lg btn-outline-warning btn-block\">Revisar</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- footer -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 String PATH_ASSETS = request.getContextPath()+ "/assets/"; 
      out.write("\n");
      out.write("<footer class=\"col-12 footer font-small blue\">\n");
      out.write("    <!-- Copyright -->\n");
      out.write("    <div class=\"footer-copyright text-center py-3\">\n");
      out.write("        © 2018 Copyright: <a href=\"https://mdbootstrap.com/education/bootstrap/\"> ESCOM </a>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<!-- scripts -->\n");
      out.write("<script src=\"");
      out.print( PATH_ASSETS );
      out.write("js/jquery-3.3.1.min.js\"></script>\n");
      out.write("<script src=\"");
      out.print( PATH_ASSETS );
      out.write("js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"");
      out.print( PATH_ASSETS );
      out.write("js/sweetalert2.js\"></script>\n");
      out.write("<script src=\"");
      out.print( PATH_ASSETS );
      out.write("js/vue.js\"></script>\n");
      out.write("<script>\n");
      out.write("    $(window).scroll(function () {\n");
      out.write("        var top = $(document).scrollTop();\n");
      out.write("        $('.splash').css({\n");
      out.write("            'background-position': '0px -'+(top/3).toFixed(2)+'px'\n");
      out.write("        });\n");
      out.write("        if(top < 10)\n");
      out.write("            $('.navbar').removeClass('navbar-shadow');\n");
      out.write("        else\n");
      out.write("            $('.navbar').addClass('navbar-shadow');\n");
      out.write("    });\n");
      out.write("</script>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
