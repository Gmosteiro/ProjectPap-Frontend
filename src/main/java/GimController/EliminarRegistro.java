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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nicknameSocio = request.getParameter("nicknameSocio");
        String nombreClase = request.getParameter("nombreClase");

        try {
            Fabrica factory = new Fabrica();
            IControllerEliminarRegClase controllerEliminar = factory.getControllerEliminarRegClase();

            Socio socio = ManejadorUsuarios.getSocio(nicknameSocio);
            Clase clase = ManejadorClases.getClaseByNombre(nombreClase);

            if (socio != null && clase != null) {
                // Eliminar el registro del Socio en la Clase
                controllerEliminar.eliminarRegistroDeClase(socio, clase);
                System.out.println("Registro eliminado con éxito.");
            } else {
                System.out.println("No se encontró un Socio o una Clase asociados a los datos proporcionados.");
            }

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Registro eliminado con éxito</h2>");
            out.println("</body></html>");

        } catch (Exception e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Error al eliminar el registro</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("</body></html>");
        }
    }
}
