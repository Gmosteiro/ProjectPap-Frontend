/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GimController;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ActividadDeportiva;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;

import java.io.IOException;

import javax.xml.rpc.ServiceException;
import publicadores.DtActividadDeportiva;

@WebServlet("/RankingActividades")
public class RankingActividades extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        ControladorPublish port = null;
        try {
            port = cps.getControladorPublishPort();

            DtActividadDeportiva[] rankingActividades = port.obtenerRankingDeActividades();

            response.setContentType("text/html;charset=UTF-8");
            try (java.io.PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Ranking de Actividades Deportivas</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Ranking de Actividades Deportivas</h1>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Costo</th>");
                out.println("<th>Descripción</th>");
                out.println("<th>Imagen</th>");
                out.println("</tr>");

                for (DtActividadDeportiva actividad : rankingActividades) {
                    out.println("<tr>");
                    out.println("<td>" + actividad.getNombre() + "</td>");
                    out.println("<td>" + actividad.getCosto() + "</td>");
                    out.println("<td>" + actividad.getDescripcion() + "</td>");
                    out.println("<td><img src='data:image/png;base64, " + actividad.getImagen()
                            + "' style='width: 40px; height: 40px; border-radius: 50%'></td>");
                    out.println("</tr>");
                }

                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (ServiceException e) {

            e.printStackTrace();
        }

    }
}
