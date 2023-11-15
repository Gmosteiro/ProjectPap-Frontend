/**
 *
 * @author santi
 *
 * */
package GimController;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.DtActividadDeportiva;
import publicadores.DtClase;

@WebServlet("/consultaActividades")
public class ConsultaActividad extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreActividad = request.getParameter("nombreActividad");
        System.out.println("nombreActividad - " + nombreActividad);

        if (nombreActividad != null) {

            retornarActividadPorNombre(response, nombreActividad); // Metodo de santi

        }
        String nicknameUsuario = request.getParameter("nicknameUsuario");
        System.out.println("nicknameUsuario - " + nicknameUsuario);

        if (nicknameUsuario != null) {
            actividadesPorUsuario(response, nicknameUsuario);
        }

    }

    private void actividadesPorUsuario(HttpServletResponse response, String nicknameUsuario) {

        try {
            ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
            ControladorPublish port = null;
            try {
                port = cps.getControladorPublishPort();
            } catch (ServiceException ex) {
                Logger.getLogger(ConsultaActividad.class.getName()).log(Level.SEVERE, null, ex);
            }

            DtActividadDeportiva[] actividades = port.getActividadesByProfe(nicknameUsuario);

            System.out.println(actividades);

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<table class='table table-bordered'>");
            // Headers
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Actividad Deportiva</th>");
            out.println("<th>Descripción</th>");
            out.println("<th>Duración</th>");
            out.println("<th>Costo</th>");
            out.println("<th>Fecha de Registro</th>");
            out.println("<th>Imagen</th>");

            // Data
            // if (actividades != null && !actividades.isEmpty()) {
            // for (ActividadDeportiva actividad : actividades) {
            // out.println("<tr>");
            // out.println("<td>" + actividad.getNombre() + "</td>");
            // out.println("<td>" + actividad.getDescripcion() + "</td>");
            // out.println("<td>" + actividad.getDuracion() + "</td>");
            // out.println("<td>" + actividad.getCosto() + "</td>");
            // out.println("<td>" + actividad.getFechaReg() + "</td>");
            // out.println(
            // "<td> <img src=\"data:image/png;base64," + actividad.getImg()
            // + " alt=\"Imagen\" style=\"width: 100px; height: 50px; \" /> </td>");
            //
            // out.println("</tr>");
            // }
            // } else {
            // out.println("<tr><td colspan='5'>No se encontraron Actividades</td></tr>");
            // }
        } catch (IOException e) {
            System.out.println("Catch retornarActividadPorNombre " + e);

        }

    }

    private void retornarActividadPorNombre(HttpServletResponse response, String nombreActividad) {
        try {

            ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
            ControladorPublish port = cps.getControladorPublishPort();

            DtActividadDeportiva actividad = port.obtenerActividadPorNombre(nombreActividad);

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<table class='table table-bordered'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Actividad Deportiva</th>");
            out.println("<th>Descripción</th>");
            out.println("<th>Duración</th>");
            out.println("<th>Costo</th>");
            out.println("<th>Fecha de Registro</th>");
            out.println("<th>Imagen</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            if (actividad != null) {
                out.println("<tr>");
                out.println("<td>" + actividad.getNombre() + "</td>");
                out.println("<td>" + actividad.getDescripcion() + "</td>");
                out.println("<td>" + actividad.getDuracion() + "</td>");
                out.println("<td>" + actividad.getCosto() + "</td>");
                out.println("<td>" + actividad.getFechaRegistro() + "</td>");
                out.println("<td><img src='data:image/png;base64, " + actividad.getImagen()
                        + "' style='width: 100px; height: 50px; '></td>");
                out.println("</tr>");
            }

            // Agregar una nueva fila para mostrar las clases asociadas
            DtClase[] clases = port.getClasesByActividad(nombreActividad);
            if (clases != null && clases.length == 0) {
                out.println("<tr>");
                out.println("<td colspan='6'><strong>Clases Asociadas</strong></td>");
                out.println("</tr>");
                for (DtClase clase : clases) {
                    out.println("<tr>");
                    out.println("<td colspan='5'>" + clase.getNombre() + "</td>");
                    out.println(
                            "<td> <img src=\"data:image/png;base64," + clase.getImagen()
                            + " alt=\"Imagen\" style=\"width: 100px; height: 50px;\" /> </td>");
                    out.println("</tr>");
                }
            }

            out.println("</tbody>");
            out.println("</table>");
        } catch (IOException e) {
            System.out.println("Catch retornarActividadPorNombre " + e);
        } catch (ServiceException e) {
        }
    }

}
