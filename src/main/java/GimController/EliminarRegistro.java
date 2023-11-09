/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author santi
 */

package GimController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import logic.Clase.Clase;
import logic.Clase.ManejadorClases;
import logic.Usuario.ManejadorUsuarios;
import logic.Usuario.Socio;
import logic.Usuario.controllers.ControllerEliminarRegClase;
import logic.Usuario.controllers.IControllerEliminarRegClase;

@WebServlet("/EliminarRegistro")
public class EliminarRegistro extends HttpServlet {
    ManejadorUsuarios manejadorUsuarios = new ManejadorUsuarios();
    ManejadorClases manejadorClases = new ManejadorClases();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String nombreInstitucion = request.getParameter("nombreInstitucion");
        String nombreActividad = request.getParameter("nombreActividad");
        String nombreClase = request.getParameter("nombreClase");
        String nicknameSocio = request.getParameter("nicknameSocio");
        Socio socio = manejadorUsuarios.getSocio(nicknameSocio);
        Clase clase = manejadorClases.getClaseByNombre(nombreClase);

        IControllerEliminarRegClase controllerEliminar = new ControllerEliminarRegClase();
        boolean eliminado = controllerEliminar.eliminarRegistroDeClase(nombreInstitucion, nombreActividad, nombreClase,
                nicknameSocio);

        if (!controllerEliminar.existenElementos(nombreInstitucion, nombreActividad, nombreClase, nicknameSocio)) {
            request.setAttribute("elementosExistentes", false);
        }

        if (eliminado) {
            request.setAttribute("eliminado", true);
        } else {
            boolean alta = controllerEliminar.crearRegistro(socio, clase);
            if (alta) {
                request.setAttribute("alta", true);
            }
        }

        request.getRequestDispatcher("eliminarRegistro.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form action='EliminarRegistro' method='post'>");

        // Aquí puedes agregar los campos para recibir la información necesaria
        // (institución, actividad, clase, socio)
        response.getWriter().println("Nombre Institución: <input type='text' name='nombreInstitucion'><br><br>");
        response.getWriter().println("Nombre Actividad: <input type='text' name='nombreActividad'><br><br>");
        response.getWriter().println("Nombre Clase: <input type='text' name='nombreClase'><br><br>");
        response.getWriter().println("Nickname Socio: <input type='text' name='nicknameSocio'><br><br>");

        response.getWriter().println("<input type='submit' value='Eliminar Registro'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }
}
