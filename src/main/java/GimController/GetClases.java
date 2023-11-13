package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.rpc.ServiceException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ActividadDeportiva;
import publicadores.Clase;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.DtActividadDeportiva;
import publicadores.DtClase;

@WebServlet("/getClases")
public class GetClases extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		String nombreClase = request.getParameter("nombreClase");
		String nombreActividad = request.getParameter("nombreActividad");
		String tablaConAccion = request.getParameter("tablaconaccion");
		// Si necesitan agregar otro parametro lo meten aca

		ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
		ControladorPublish port = null;
		try {
			port = cps.getControladorPublishPort();
		} catch (ServiceException e) {

			e.printStackTrace();
		}

		DtClase[] clases = null;
		// y crean otra condicion aca (lo mejor seria pasarlo a un switch)

		if (nickname != null && nickname.length() > 0) {

			clases = port.getClasesByUser(nickname);

		} else if (nombreClase != null && nombreClase.length() > 0) {

			DtClase nuevaClase = port.obtenerClasePorNombre(nombreClase);

			clases[1] = nuevaClase;

		} else if (nombreActividad != null && nombreActividad.length() > 0) {

			DtActividadDeportiva actividadBuscada = port.obtenerActividadPorNombre(nombreActividad);

			clases = port.obtenerClasesPorActividad(actividadBuscada);

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

		if (tablaConAccion != null && tablaConAccion.length() > 0) {

			out.println("<th>Accion</th>");
		}

		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		if (clases != null && clases.length == 0) {

			for (DtClase clase : clases) {
				out.println("<tr>");
				out.println("<td>" + clase.getNombre() + "</td>");
				out.println("<td>" + clase.getFecha() + "</td>");
				out.println("<td>" + clase.getFechaRegistro() + "</td>");
				out.println("<td>" + clase.getHora() + "</td>");
				out.println("<td>" + clase.getUrl() + "</td>");

				out.println("<td> <img src=\"data:image/png;base64," + clase.getImagen()
						+ " alt=\"Imagen\" style=\"width: 40px; height: 40px; border-radius: 50%\" /> </td>");
				if (tablaConAccion != null && tablaConAccion.length() > 0) {

					out.println(
							"<td><button class=\"btn btn-info btn-block btn-round\" data-action=\"registrar\" type=\"button\" onclick=\"enviarInfo('"
									+ clase.getNombre() + "');\">Registrar</button></td>");
				}

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