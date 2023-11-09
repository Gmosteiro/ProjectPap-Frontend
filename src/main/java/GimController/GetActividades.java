/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import logic.ActividadDeportiva.ActividadDeportiva;
import logic.Institucion.InstitucionDeportiva;
import logic.Institucion.ManejadorInstitucion;

/**
 *
 * @author Admin
 */
public class GetActividades extends HttpServlet {
    ManejadorInstitucion manejadorInstitucion = new ManejadorInstitucion();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String institucionNombre = request.getParameter("institucion");

        if (institucionNombre != null) {
            InstitucionDeportiva instituto = manejadorInstitucion.getInstitucionesByName(institucionNombre);
            List<ActividadDeportiva> listaactividades = instituto.getActividades();

            // Construye una lista de nombres de actividades en formato de texto plano
            StringBuilder textoactividades = new StringBuilder();
            for (ActividadDeportiva actividad : listaactividades) {
                textoactividades.append(actividad.getNombre()).append("\n");
            }

            // Configura la respuesta HTTP como texto plano
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            // Envía la lista de nombres de actividades como respuesta al cliente
            PrintWriter out = response.getWriter();
            out.print(textoactividades.toString());
        } else {
            // Maneja el caso si no se proporciona una institución válida
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Por favor, ingresa una institución válida.");
        }
    }
}
