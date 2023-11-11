package GimController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishService;
import publicadores.InstitucionDeportiva;

@WebServlet("/ObtenerInstitucionesServlet")
public class GetInstituciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			List<InstitucionDeportiva> instituciones;
			instituciones = getInstitucionesalBackend();

			StringBuilder textoInstituciones = new StringBuilder();
			for (InstitucionDeportiva institucion : instituciones) {
				textoInstituciones.append(institucion.getNombre()).append("\n");
			}

			// Configura la respuesta HTTP
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");

			// Envía la respuesta de texto plano al cliente
			response.getWriter().write(textoInstituciones.toString());

		} catch (ServiceException e) {

			e.printStackTrace();
		}
	}

	// Método para simular la obtención de datos de instituciones (puedes
	// reemplazarlo con tu lógica real)
	private List<InstitucionDeportiva> getInstitucionesalBackend() throws ServiceException {
		ControladorPublishService service = new ControladorPublishService();
		ControladorPublish port = service.getControladorPublishPort();

		ArrayList<InstitucionDeportiva> institucionesAL = port.getInstituciones();

		List<InstitucionDeportiva> instituciones = null;

		return instituciones;

	}
}