
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

import javax.xml.rpc.ServiceException;

import publicadores.ActividadDeportiva;
import publicadores.ArrayList;
import publicadores.Clase;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishService;
import publicadores.ControladorPublishServiceLocator;



@WebServlet("/consultaActividades")
public class ConsultaActividad extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        try {
			ControladorPublish port = cps.getControladorPublishPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			
			ControladorPublish controller = null;
			List<ActividadDeportiva> actividades = (List<ActividadDeportiva>) controller.getActividadesByProfe(nicknameUsuario);

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
			if (actividades != null && !actividades.isEmpty()) {
				for (ActividadDeportiva actividad : actividades) {
					out.println("<tr>");
					out.println("<td>" + actividad.getNombre() + "</td>");
					out.println("<td>" + actividad.getDescripcion() + "</td>");
					out.println("<td>" + actividad.getDuracion() + "</td>");
					out.println("<td>" + actividad.getCosto() + "</td>");
					out.println("<td>" + actividad.getFechaReg() + "</td>");
					out.println(
							"<td> <img src=\"data:image/png;base64," + actividad.getImg()
									+ " alt=\"Imagen\" style=\"width: 100px; height: 50px; \" /> </td>");
                                                                                                       

					out.println("</tr>");
				}
			} else {
				out.println("<tr><td colspan='5'>No se encontraron Actividades</td></tr>");
			}

		} catch (IOException e) {
			System.out.println("Catch retornarActividadPorNombre " + e);
			e.printStackTrace();
		}

	}

	private void retornarActividadPorNombre(HttpServletResponse response, String nombreActividad) {
		try {
	

			ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
	        ControladorPublish port = cps.getControladorPublishPort();

			ActividadDeportiva actividad = port.obtenerActividadPorNombre(nombreActividad);

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
				out.println("<td>" + actividad.getFechaReg() + "</td>");
				out.println("<td><img src='data:image/png;base64, " + actividad.getImg()
						+ "' style='width: 100px; height: 50px; '></td>");
				out.println("</tr>");
			}

			// Agregar una nueva fila para mostrar las clases asociadas
			List<Clase> clases = (List<Clase>) port.getClasesByActividad(nombreActividad);
			if (clases != null && !clases.isEmpty()) {
				out.println("<tr>");
				out.println("<td colspan='6'><strong>Clases Asociadas</strong></td>");
				out.println("</tr>");
				for (Clase clase : clases) {
					out.println("<tr>");
					out.println("<td colspan='5'>" + clase.getNombre() + "</td>");
					out.println(
							"<td> <img src=\"data:image/png;base64," + clase.getImg()
									+ " alt=\"Imagen\" style=\"width: 100px; height: 50px;\" /> </td>");         
					out.println("</tr>");
				}
			}

			out.println("</tbody>");
			out.println("</table>");
		} catch (IOException e) {
			System.out.println("Catch retornarActividadPorNombre " + e);
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}