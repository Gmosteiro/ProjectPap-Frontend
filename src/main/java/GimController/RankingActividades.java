/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GimController;

import java.io.IOException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publicadores.ActividadDeportiva;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;

@WebServlet("/RankingActividades")
public class RankingActividades extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
		ControladorPublish port = null;
		try {
			port = cps.getControladorPublishPort();

			List<ActividadDeportiva> rankingActividades = (List<ActividadDeportiva>) port.obtenerRankingDeActividades();

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

				for (ActividadDeportiva actividad : rankingActividades) {
					out.println("<tr>");
					out.println("<td>" + actividad.getNombre() + "</td>");
					out.println("<td>" + actividad.getCosto() + "</td>");
					out.println("<td>" + actividad.getDescripcion() + "</td>");
					out.println("<td><img src='data:image/png;base64, " + actividad.getImg()
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
