package GimController;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;

import javax.xml.rpc.ServiceException;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publicadores.ActividadDeportiva;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.InstitucionDeportiva;

@WebServlet("/RegistroDictadoClase")

public class RegistroDictadoClase extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
		ControladorPublish port = null;
		try {
			port = cps.getControladorPublishPort();

			String nombreInstitucion = request.getParameter("nombreInstitucion");
			if (nombreInstitucion != null && nombreInstitucion.length() > 0) {
				InstitucionDeportiva instituto = port.getInstitucionesByName(nombreInstitucion);
				ActividadDeportiva[] listaactividades = instituto.getActividades();

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");

				JSONArray actividadesArray = new JSONArray();

				for (ActividadDeportiva actividadDeportiva : listaactividades) {

					JSONObject actividadJSON = new JSONObject();
					actividadJSON.put("nombre", actividadDeportiva.getNombre());

					actividadesArray.put(actividadJSON);
				}

				JSONObject jsonResponse = new JSONObject();
				jsonResponse.put("ERROR", false);
				jsonResponse.put("Actividades", actividadesArray);

				response.getWriter().write(jsonResponse.toString());

			} else {
				// ArrayList publicadores.ControladorPublish.getInstituciones()
				// throwsRemoteException

				System.out.println("Instituciones: " + port.getInstituciones());

				InstitucionDeportiva[] listaInstituciones = port.getInstituciones();

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");

				JSONArray institucionesArray = new JSONArray();

				for (InstitucionDeportiva institucion : listaInstituciones) {

					JSONObject institucionJSON = new JSONObject();
					institucionJSON.put("nombre", institucion.getNombre());

					institucionesArray.put(institucionJSON);
				}

				JSONObject jsonResponse = new JSONObject();
				jsonResponse.put("ERROR", false);
				jsonResponse.put("Instituciones", institucionesArray);

				response.getWriter().write(jsonResponse.toString());

			}
		} catch (ServiceException e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
			ControladorPublish port = cps.getControladorPublishPort();
			System.out.println("En Registro Dictado Clase");
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();

			JSONObject jsonData = new JSONObject(sb.toString());

			String socio = jsonData.getString("socio");
			String clase = jsonData.getString("clase");

			LocalDate fecha = LocalDate.now();

			// response
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			JSONObject jsonResponse = new JSONObject();

			boolean existeRegistro = port.validateDataWeb(socio, clase);
			System.out.println("validate: " + existeRegistro);

			if (existeRegistro) {

				jsonResponse.put("ERROR", existeRegistro);
				jsonResponse.put("Message", " Ya existe un registro para los datos ingresados ");
				response.getWriter().write(jsonResponse.toString());

			} else {

				// String nicknameSocio, String nombreClase, LocalDate fechaReg
				boolean registro = port.addRegistroDictadoWeb(socio, clase, fecha);
				System.out.println("registro: " + registro);

				jsonResponse.put("ERROR", !registro);
				jsonResponse.put("Message", !registro ? "Error al crear registro " : "Creado con exito ");

				System.out.println("response: " + jsonResponse.toString());

				response.getWriter().write(jsonResponse.toString());
			}

		} catch (Exception e) {
			// Manejar el error apropiadamente y enviar una respuesta de error al cliente si
			// es necesario
			System.out.println("Catch " + e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("{Error : " + e.getMessage() + "}");
		}
	}

}