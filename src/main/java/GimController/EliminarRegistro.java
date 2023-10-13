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
import java.io.PrintWriter;
import java.time.LocalDate;

import logic.Clase.Clase;
import logic.Clase.ManejadorClases;
import logic.Fabrica;
import logic.Usuario.ManejadorUsuarios;
import logic.Usuario.Socio;
import logic.Usuario.controllers.ControllerEliminarRegClase;
import logic.Usuario.controllers.IControllerEliminarRegClase;

@WebServlet("/EliminarRegistro")
public class EliminarRegistro extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nombreInstitucion = request.getParameter("nombreInstitucion");
        String nombreActividad = request.getParameter("nombreActividad");
        String nombreClase = request.getParameter("nombreClase");
        String nicknameSocio = request.getParameter("nicknameSocio");

        IControllerEliminarRegClase controllerEliminar = new ControllerEliminarRegClase();
        boolean eliminado = controllerEliminar.eliminarRegistroDeClase(nombreInstitucion, nombreActividad, nombreClase, nicknameSocio);

        if (eliminado) {
            request.setAttribute("eliminado", true);
            request.setAttribute("alta", false);
        } else {
            request.setAttribute("eliminado", false);
            request.setAttribute("alta", true);
        }

        request.getRequestDispatcher("eliminarRegistro.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form action='EliminarRegistro' method='post'>");

        // Aquí puedes agregar los campos para recibir la información necesaria (institución, actividad, clase, socio)
        response.getWriter().println("Nombre Institución: <input type='text' name='nombreInstitucion'><br><br>");
        response.getWriter().println("Nombre Actividad: <input type='text' name='nombreActividad'><br><br>");
        response.getWriter().println("Nombre Clase: <input type='text' name='nombreClase'><br><br>");
        response.getWriter().println("Nickname Socio: <input type='text' name='nicknameSocio'><br><br>");

        response.getWriter().println("<input type='submit' value='Eliminar Registro'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }
}
