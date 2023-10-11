
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
import java.util.List;

import logic.ActividadDeportiva.ActividadDeportiva;
import logic.ActividadDeportiva.controllers.IControllerConsultaActividad;
import logic.Fabrica;

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
			Fabrica factory = new Fabrica();

			IControllerConsultaActividad controller = factory.getControllerConsultaActividad();

			List<ActividadDeportiva> actividades = controller.getActividadesByProfe(nicknameUsuario);

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
			out.println("<th>Accion</th>");

			// Data
			if (actividades != null && !actividades.isEmpty()) {
				for (ActividadDeportiva actividad : actividades) {
					out.println("<tr>");
					out.println("<td>" + actividad.getNombre() + "</td>");
					out.println("<td>" + actividad.getDescripcion() + "</td>");
					out.println("<td>" + actividad.getDuracion() + "</td>");
					out.println("<td>" + actividad.getCosto() + "</td>");
					out.println("<td>" + actividad.getFechaReg() + "</td>");
					out.println(
							"<td><a href='/consulta_Actividad.jsp?nombreActividad=" + actividad.getNombre()
									+ "'>Ver Actividad</a></td>");

					out.println("</tr>");
				}
			} else {
				out.println("<tr><td colspan='5'>No se encontraron Actividades</td></tr>");
			}

			// if (actividades != null && ) {
			// out.println("</tr>");
			// out.println("</thead>");
			// out.println("<tbody>");
			// out.println("<tr>");
			// out.println("<td>" + actividad.getNombre() + "</td>");
			// out.println("<td>" + actividad.getDescripcion() + "</td>");
			// out.println("<td>" + actividad.getDuracion() + "</td>");
			// out.println("<td>" + actividad.getCosto() + "</td>");
			// out.println("<td>" + actividad.getFechaReg() + "</td>");
			// out.println("</tr>");
			// out.println("</tbody>");
			// out.println("</table>");
			// }
		} catch (IOException e) {
			System.out.println("Catch retornarActividadPorNombre " + e);
			e.printStackTrace();
		}

	}

	private void retornarActividadPorNombre(HttpServletResponse response, String nombreActividad) {
		try {
			Fabrica factory = new Fabrica();

			IControllerConsultaActividad controller = factory.getControllerConsultaActividad();

			ActividadDeportiva actividad = controller.obtenerActividadPorNombre(nombreActividad);

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
			out.println("<th>Accion</th>");

			// Data
			if (actividad != null) {
				out.println("</tr>");
				out.println("</thead>");
				out.println("<tbody>");
				out.println("<tr>");
				out.println("<td>" + actividad.getNombre() + "</td>");
				out.println("<td>" + actividad.getDescripcion() + "</td>");
				out.println("<td>" + actividad.getDuracion() + "</td>");
				out.println("<td>" + actividad.getCosto() + "</td>");
				out.println("<td>" + actividad.getFechaReg() + "</td>");
				out.println("</tr>");
				out.println("</tbody>");
				out.println("</table>");
			}
		} catch (IOException e) {
			System.out.println("Catch retornarActividadPorNombre " + e);
			e.printStackTrace();
		}
	}

}