package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List; // Importa la clase List si no está importada

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import logic.Fabrica;
import logic.ActividadDeportiva.ActividadDeportiva;
import logic.ActividadDeportiva.controllers.IControllerConsultaActividad;
import logic.Clase.Clase;
import logic.Clase.controllers.IControllerConsultaClases;
import logic.Usuario.controllers.IControllerConsultaUsuario;
import jakarta.servlet.http.*;
import logic.ActividadDeportiva.ActividadDeportiva;
import logic.ActividadDeportiva.ManejadorActividad;

@WebServlet("/getClases")
public class GetClases extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nickname = request.getParameter("nickname");
        String nombreClase = request.getParameter("nombreClase");
        String nombreActividad = request.getParameter("nombreActividad");
        // Si necesitan agregar otro parametro lo meten aca

        Fabrica factory = new Fabrica();
        List<Clase> clases = new ArrayList<>();
        // y crean otra condicion aca (lo mejor seria pasarlo a un switch)
        if (nickname != null && nickname.length() > 0) {

            IControllerConsultaUsuario controllerConsultaUsuario = factory.getControladorConsultaUsuario();
            clases = controllerConsultaUsuario.getClasesByUser(nickname);

        } else if (nombreClase != null && nombreClase.length() > 0) {

            IControllerConsultaClases controllerClases = factory.getControllerConsultaClases();
            clases.add(controllerClases.obtenerClasePorNombre(nombreClase));

        } else if (nombreActividad != null && nombreActividad.length() > 0) {

            IControllerConsultaActividad controllerCA = factory.getControllerConsultaActividad();

            ActividadDeportiva actividadBuscada = controllerCA.obtenerActividadPorNombre(nombreActividad);

            clases = factory.getControllerConsultaClases().obtenerClasesPorActividad(actividadBuscada);

        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<table class='table table-bordered'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Nombre</th>");
        out.println("<th>Fecha</th>");
        out.println("<th>Fecha de Registro</th>");
        out.println("<th>Hora</th>");
        out.println("<th>URL</th>");
        out.println("<th>Imagen</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        if (clases != null && !clases.isEmpty()) {
            for (Clase clase : clases) {
                out.println("<tr>");
                out.println("<td>" + clase.getNombre() + "</td>");
                out.println("<td>" + clase.getFechaFormatted() + "</td>");
                out.println("<td>" + formatFecha(clase.getFechaReg()) + "</td>");
                out.println("<td>" + clase.getHora() + "</td>");
                out.println("<td>" + clase.getUrl() + "</td>");

                out.println(
                        "<td> <img src=\"data:image/png;base64," + clase.getImg()
                                + " alt=\"Imagen\" style=\"width: 40px; height: 40px; border-radius: 50%\" /> </td>");

                out.println("</tr>");
            }
        } else {
            out.println("<tr><td colspan='5'>No se encontraron clases</td></tr>");
        }

        out.println("</tbody>");
        out.println("</table>");
    }

    private String formatFecha(LocalDate fecha) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return fecha.atStartOfDay().format(formatter);

    }

}