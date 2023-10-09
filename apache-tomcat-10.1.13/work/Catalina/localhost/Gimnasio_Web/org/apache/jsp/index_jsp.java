/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-10-09 13:26:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1696856544962L));
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<html lang=\"en\">\r\n");
      out.write("	<head>\r\n");
      out.write("		<link\r\n");
      out.write("			rel=\"stylesheet\"\r\n");
      out.write("			href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\r\n");
      out.write("			integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n");
      out.write("			crossorigin=\"anonymous\"\r\n");
      out.write("		/>\r\n");
      out.write("		<meta charset=\"utf-8\" />\r\n");
      out.write("		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("		<title>Iniciar Sesión</title>\r\n");
      out.write("		<link rel=\"userIcon\" href=\"imagenes/UserIcon.png\" />\r\n");
      out.write("	</head>\r\n");
      out.write("\r\n");
      out.write("	<body>\r\n");
      out.write("		<header class=\"intro\"></header>\r\n");
      out.write("		<main>\r\n");
      out.write("			<article>\r\n");
      out.write("				<div class=\"container\" style=\"margin-top: 10%\">\r\n");
      out.write("					<div class=\"row justify-content-center\">\r\n");
      out.write("						<div class=\"col-md-6\">\r\n");
      out.write("							<div class=\"text-center\">\r\n");
      out.write("								<img src=\"GetImage?imageName=UserIcon.jpg\" width=\"150\" height=\"150\" />\r\n");
      out.write("								<h4 style=\"margin-bottom: 20px\">Iniciar Sesión</h4>\r\n");
      out.write("							</div>\r\n");
      out.write("							<form action=\"Login\" method=\"POST\">\r\n");
      out.write("								<div class=\"form-group\">\r\n");
      out.write("									<input\r\n");
      out.write("										type=\"text\"\r\n");
      out.write("										class=\"form-control\"\r\n");
      out.write("										id=\"email1\"\r\n");
      out.write("										name=\"email\"\r\n");
      out.write("										placeholder=\"Nickname...\"\r\n");
      out.write("									/>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"form-group\">\r\n");
      out.write("									<input\r\n");
      out.write("										type=\"password\"\r\n");
      out.write("										class=\"form-control\"\r\n");
      out.write("										id=\"password1\"\r\n");
      out.write("										name=\"password\"\r\n");
      out.write("										placeholder=\"Contraseña...\"\r\n");
      out.write("									/>\r\n");
      out.write("								</div>\r\n");
      out.write("								");
 String errorMessage=request.getParameter("error"); if (errorMessage !=null &&
								!errorMessage.isEmpty()) { 
      out.write("\r\n");
      out.write("								<div class=\"alert alert-danger\" role=\"alert\">");
      out.print( errorMessage );
      out.write("</div>\r\n");
      out.write("								");
 } 
      out.write("\r\n");
      out.write("								<button type=\"submit\" class=\"btn btn-info btn-block btn-round\">Iniciar</button>\r\n");
      out.write("							</form>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</article>\r\n");
      out.write("		</main>\r\n");
      out.write("		<!-- jQuery -->\r\n");
      out.write("		<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\r\n");
      out.write("		<!-- Popper JS -->\r\n");
      out.write("		<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\r\n");
      out.write("		<!-- Bootstrap JS -->\r\n");
      out.write("		<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\r\n");
      out.write("		");
      out.write("<style>\r\n");
      out.write("	/* Estilos para el footer */\r\n");
      out.write("	.footer {\r\n");
      out.write("		background-color: #000; /* Color de fondo negro */\r\n");
      out.write("		color: #fff; /* Color de texto blanco */\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		padding: 20px 0; /* Espaciado interno */\r\n");
      out.write("		position: fixed;\r\n");
      out.write("		bottom: 0;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		margin-top: 20px; /* Margen superior para separar del contenido principal */\r\n");
      out.write("		font-size: 14px; /* TamaÃ±o de fuente */\r\n");
      out.write("		line-height: 1.5; /* Espaciado entre lÃ­neas */\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.footer a {\r\n");
      out.write("		color: #fff; /* Color de los enlaces */\r\n");
      out.write("		text-decoration: none; /* Quita el subrayado de los enlaces */\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.footer a:hover {\r\n");
      out.write("		text-decoration: underline; /* Estilo de enlace al pasar el cursor por encima */\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<footer class=\"footer\">\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<div class=\"col-md-12\">\r\n");
      out.write("				<div class=\"footer-content\">\r\n");
      out.write("					<p>\r\n");
      out.write("						Si no me pides permiso para usar esto, te juro que te busco y te mato (dame follow en Twitter,\r\n");
      out.write("						me niego a decÃ­rtelo).\r\n");
      out.write("					</p>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</footer>\r\n");
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
