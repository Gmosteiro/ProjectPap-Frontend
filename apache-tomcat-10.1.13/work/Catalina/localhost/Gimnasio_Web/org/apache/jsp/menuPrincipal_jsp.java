/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-10-04 01:30:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class menuPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1696377057011L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1696377059760L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"utf-8\" />\r\n");
      out.write("		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n");
      out.write("\r\n");
      out.write("		<link\r\n");
      out.write("			rel=\"stylesheet\"\r\n");
      out.write("			href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\r\n");
      out.write("			integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n");
      out.write("			crossorigin=\"anonymous\"\r\n");
      out.write("		/>\r\n");
      out.write("\r\n");
      out.write("		<title>Homepage</title>\r\n");
      out.write("		");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\" />\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\r\n");
      out.write("	<div class=\"container-fluid\">\r\n");
      out.write("		<a class=\"navbar-brand\" style=\"margin-right: 25%; margin-left: 10%\" href=\"menuPrincipal.jsp\">GymPap</a>\r\n");
      out.write("		<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavAltMarkup\"\r\n");
      out.write("			aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("			<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("		</button>\r\n");
      out.write("		<div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\r\n");
      out.write("			<div class=\"navbar-nav\">\r\n");
      out.write("				<a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Inicio</a>\r\n");
      out.write("				<a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Clases</a>\r\n");
      out.write("				<a class=\"nav-link\" href=\"#\">Actividades Deportivas</a>\r\n");
      out.write("				<a class=\"nav-link\" href=\"#\">Usuario</a>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"navbar-nav\">\r\n");
      out.write("			");
 logic.Usuario.Sesion usuarioLogeado=(logic.Usuario.Sesion)
				request.getSession().getAttribute("usuarioLogeado"); if (usuarioLogeado !=null) { 
      out.write("\r\n");
      out.write("				<img style=\"width: 40px; margin-right: 5px\" src=\"");
      out.print( usuarioLogeado.getProfileImage() );
      out.write("\" />\r\n");
      out.write("				<a class=\"user-nav-link\">\r\n");
      out.write("					");
      out.print( usuarioLogeado.getNombre() + " " + usuarioLogeado.getApellido() );
      out.write("\r\n");
      out.write("				</a>\r\n");
      out.write("				<div id=\"user-options\" class=\"user-options\">\r\n");
      out.write("					<a class=\"user-options-a\" href=\"CerrarSesion\">Cerrar Sesion</a>\r\n");
      out.write("				</div>\r\n");
      out.write("				");
 } else { 
      out.write("\r\n");
      out.write("					<script>\r\n");
      out.write("						window.location.href = \"/Gimnasio_Web/index.jsp\"; // Redirigir al usuario a la pÃ¡gina de inicio de sesiÃ³n\r\n");
      out.write("					</script>\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("	.user-nav-link {\r\n");
      out.write("		display: block;\r\n");
      out.write("		padding: var(--bs-nav-link-padding-y) var(--bs-nav-link-padding-x);\r\n");
      out.write("		font-size: var(--bs-nav-link-font-size);\r\n");
      out.write("		font-weight: var(--bs-nav-link-font-weight);\r\n");
      out.write("		color: var(--bs-nav-link-color);\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		background: 0 0;\r\n");
      out.write("		border: 0;\r\n");
      out.write("		transition: color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.user-options {\r\n");
      out.write("		display: none;\r\n");
      out.write("		position: absolute;\r\n");
      out.write("		background-color: white;\r\n");
      out.write("		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);\r\n");
      out.write("		z-index: 1;\r\n");
      out.write("		margin-top: 40px;\r\n");
      out.write("		width: inherit;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.user-options-a {\r\n");
      out.write("		min-width: 200px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.user-options:hover {\r\n");
      out.write("		display: block;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.user-nav-link:hover {\r\n");
      out.write("		cursor: pointer;\r\n");
      out.write("		color: blue;\r\n");
      out.write("		background-color: grey;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.user-nav-link:hover+.user-options {\r\n");
      out.write("		display: block;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	.user-options a {\r\n");
      out.write("		display: block;\r\n");
      out.write("		padding: 10px;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		color: black;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.user-options a:hover {\r\n");
      out.write("		background-color: #f2f2f2;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.user-options.show {\r\n");
      out.write("		display: block;\r\n");
      out.write("	}\r\n");
      out.write("</style>");
      out.write("\r\n");
      out.write("	</head>\r\n");
      out.write("\r\n");
      out.write("	<body>\r\n");
      out.write("		<div class=\"\">\r\n");
      out.write("			<div id=\"carouselExampleSlidesOnly\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("				<div class=\"carousel-inner\">\r\n");
      out.write("					<div class=\"carousel-item active\">\r\n");
      out.write("						<img class=\"d-block w-100\" src=\"./imagenes/img1.jpg\" alt=\"First slide\" />\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"carousel-item\">\r\n");
      out.write("						<img class=\"d-block w-100\" src=\"./imagenes/img2.jpg\" alt=\"Second slide\" />\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"carousel-item\">\r\n");
      out.write("						<img class=\"d-block w-100\" src=\"./imagenes/img3.jpg\" alt=\"Third slide\" />\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"carousel-item\">\r\n");
      out.write("						<img class=\"d-block w-100\" src=\"./imagenes/img4.jpg\" alt=\"Third slide\" />\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<!-- Optional JavaScript -->\r\n");
      out.write("		<!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n");
      out.write("                ");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js\" integrity=\"sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js\" integrity=\"sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        /* Estilos para el footer */\r\n");
      out.write("        .footer {\r\n");
      out.write("    background-color: #000; /* Color de fondo negro */\r\n");
      out.write("    color: #fff; /* Color de texto blanco */\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding: 20px 0; /* Espaciado interno */\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    bottom: 0;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("}\r\n");
      out.write("    </style>\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- Contenido principal de tu página -->\r\n");
      out.write("\r\n");
      out.write("    <footer class=\"footer\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12\">\r\n");
      out.write("                    <div class=\"footer-content\">\r\n");
      out.write("                        <p>Si no me pedis permiso para usar esto te juro que te busco y te mato (dame follow en twitter (me niego a decile x)).</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("\r\n");
      out.write("    <!-- Scripts de Bootstrap y otros scripts si es necesario -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("</body>");
      out.write("\r\n");
      out.write("	</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
