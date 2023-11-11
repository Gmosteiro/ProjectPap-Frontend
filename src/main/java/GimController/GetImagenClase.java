package GimController;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.rpc.ServiceException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.Clase;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishService;

public class GetImagenClase extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			String nombreClase = request.getParameter("nombreClase");

			String imagenBase64;
			imagenBase64 = obtenerImagenDeClaseEnBase64(nombreClase);

			if (imagenBase64 != null) {

				response.setContentType("text/plain");
				OutputStream out = response.getOutputStream();
				out.write(imagenBase64.getBytes());
				out.flush();
				out.close();
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (ServiceException e) {

			e.printStackTrace();
		}
	}

	private String obtenerImagenDeClaseEnBase64(String nombreClase) throws ServiceException {

		ControladorPublishService service = new ControladorPublishService();
		ControladorPublish port = service.getControladorPublishPort();

		Clase clase = null;

		clase = port.obtenerClasePorNombre(nombreClase);

		return clase.getImg();

	}
}