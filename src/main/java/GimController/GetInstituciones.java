package GimController;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
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
		ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
		ControladorPublish port = null;
		try {
			port = cps.getControladorPublishPort();

			InstitucionDeportiva[] institucionesAL = port.getInstituciones();

			List<InstitucionDeportiva> instituciones = null;

			return instituciones;
		} catch (RemoteException e) {

			e.printStackTrace();
			return null;
		}
	}
}