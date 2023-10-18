/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GimController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import logic.Clase.controllers.ControllerRanking;
import logic.Clase.Clase;

@WebServlet("/RankingClases")
public class RankingClases extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ControllerRanking controllerRanking = new ControllerRanking();

        List<Clase> rankingClases = controllerRanking.obtenerRankingDeClases();

        response.setContentType("text/html;charset=UTF-8");
        try (java.io.PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ranking de Dictado de Clases</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ranking de Dictado de Clases</h1>");
            out.println("<table class=\"table table-striped\">");
            out.println("<thead class=\"thead-dark\">");
            out.println("<tr>");
            out.println("<th scope=\"col\">Nombre</th>");
            out.println("<th scope=\"col\">Fecha</th>");
            out.println("<th scope=\"col\">URL</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for (Clase clase : rankingClases) {
                out.println("<tr>");
                out.println("<td>" + clase.getNombre() + "</td>");
                out.println("<td>" + clase.getFecha() + "</td>");
                out.println("<td><a href=\"" + clase.getUrl() + "\">Enlace</a></td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }

        controllerRanking.closeEntityManagerFactory();
    }
}