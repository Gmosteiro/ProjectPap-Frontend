package GimController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.DtUsuario;
import publicadores.DtClase;

import java.io.IOException;

import javax.xml.rpc.ServiceException;

@WebServlet("/EliminarRegistro")
public class EliminarRegistro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
            ControladorPublish port = cps.getControladorPublishPort();

            String nombreInstitucion = request.getParameter("nombreInstitucion");
            String nombreActividad = request.getParameter("nombreActividad");
            String nombreClase = request.getParameter("nombreClase");
            String nicknameSocio = request.getParameter("nicknameSocio");

            DtUsuario socio = port.getSocio(nicknameSocio);
            DtClase clase = port.getClaseByNombre(nombreClase);

            boolean eliminado = port.eliminarRegistroDeClase(nombreInstitucion, nombreActividad, nombreClase, nicknameSocio);
            boolean alta = port.crearRegistro(socio, clase);
            if (!port.existenElementos(nombreInstitucion, nombreActividad, nombreClase, nicknameSocio)) {
                request.setAttribute("elementosExistentes", false);
            }

            if (eliminado) {
                request.setAttribute("eliminado", true);
                System.out.println("eliminado"+eliminado);
                System.out.println("alta"+alta);

            } else  {
                    request.setAttribute("alta", true);
                      System.out.println("eliminado"+eliminado);
                      System.out.println("alta"+alta);
                }
            

            request.getRequestDispatcher("eliminarRegistro.jsp").forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
            // Manejar la excepción del servicio web
            // Podrías redirigir a una página de error o realizar alguna acción específica
            // Puedes usar response.sendRedirect("ruta/a/paginaDeError.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form action='EliminarRegistro' method='post'>");

        // Campos para recibir la información necesaria (institución, actividad, clase, socio)
        response.getWriter().println("Nombre Institución: <input type='text' name='nombreInstitucion'><br><br>");
        response.getWriter().println("Nombre Actividad: <input type='text' name='nombreActividad'><br><br>");
        response.getWriter().println("Nombre Clase: <input type='text' name='nombreClase'><br><br>");
        response.getWriter().println("Nickname Socio: <input type='text' name='nicknameSocio'><br><br>");

        response.getWriter().println("<input type='submit' value='Eliminar Registro'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }
}
