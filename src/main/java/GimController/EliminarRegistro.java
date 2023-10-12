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

        String nombreInstitucion = request.getParameter("nombreInstitucion");
        String nombreActividad = request.getParameter("nombreActividad");
        String nombreClase = request.getParameter("nombreClase");
        String nicknameSocio = request.getParameter("nicknameSocio");

        try {
            Fabrica factory = new Fabrica();
            IControllerEliminarRegClase controllerEliminar = factory.getControllerEliminarRegClase();

            // Intentamos eliminar el registro o crear uno nuevo si no existe
            controllerEliminar.eliminarRegistroDeClase(nombreInstitucion, nombreActividad, nombreClase, nicknameSocio);

            // Si llegamos aquí, el registro se eliminó o creó con éxito
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Registro eliminado o creado con éxito</h2>");
            out.println("</body></html>");

        } catch (Exception e) {
            // Si hay un error, mostramos un mensaje de error
            System.out.println("Error al eliminar o crear el registro: " + e.getMessage());
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Error al eliminar o crear el registro</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("</body></html>");
        }
    }
}


