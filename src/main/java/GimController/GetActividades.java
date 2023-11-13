/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publicadores.ActividadDeportiva;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.InstitucionDeportiva;
import java.util.ArrayList;

import javax.xml.rpc.ServiceException;

/**
 *
 * @author Admin
 */
public class GetActividades extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
            ControladorPublish port = null;
            port = cps.getControladorPublishPort();

            String institucionNombre = request.getParameter("institucion");

            if (institucionNombre != null) {
                InstitucionDeportiva instituto = port.getInstitucionesByName(institucionNombre);
                ActividadDeportiva[] listaactividades = instituto.getActividades();

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
        } catch (ServiceException e) {

            e.printStackTrace();
        }
    }
}
