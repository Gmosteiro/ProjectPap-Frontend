package GimController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logic.Fabrica;
import logic.Usuario.Sesion;
import logic.Usuario.controllers.IControllerInicioSesion;
import logic.Usuario.controllers.IControllerModificarUsuario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import org.json.JSONObject;

@WebServlet("/actualizarUsuario")
public class ActualizarUsuario extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			System.out.println("En Actualizar Usuario");
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();

			JSONObject jsonData = new JSONObject(sb.toString());

			String nickname = jsonData.getString("nickname");
			String nombre = jsonData.getString("nombre");
			String apellido = jsonData.getString("apellido");
			String profileImage = jsonData.getString("profileImage");

			System.out.println("Profile Image: " + profileImage);
			String fechaNacimientoStr = jsonData.getString("fechaNacimiento");

			LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			Fabrica factory = new Fabrica();

			IControllerModificarUsuario controllerUsuario = factory.getControllerModificarUsuario();
			// nickname, nuevoNombre, nuevoApellido, nuevafecha, img
			boolean update = controllerUsuario.modificarUsuarioWeb(nickname, nombre, apellido, fechaNacimiento,
					profileImage);

			if (update) {
				// Aca actualizo la sesion a nivel de servidor para que coincida con los datos
				// modificados
				HttpSession session = request.getSession();

				Sesion currentSession = (Sesion) session.getAttribute("usuarioLogeado");
				System.out.println("UsuarioLogedo.nombre: " + currentSession.getNombre());

				currentSession.setApellido(apellido);
				currentSession.setNombre(nombre);
				currentSession.setFechaNacimiento(fechaNacimientoStr);

				session.setAttribute("usuarioLogeado", currentSession);

				Sesion modificado = (Sesion) session.getAttribute("usuarioLogeado");
				System.out.println("modificado.nombre " + modificado.getNombre());

			}

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			// Puedes enviar una respuesta en formato JSON si es necesario
			JSONObject jsonResponse = new JSONObject();

			jsonResponse.put("ERROR", !update);
			jsonResponse.put("Message", update ? "Modificado Correctamente " : "Error modificarUsuario ");

			response.getWriter().write(jsonResponse.toString());

		} catch (

		Exception e) {
			// Manejar el error apropiadamente y enviar una respuesta de error al cliente si
			// es necesario
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("Error al actualizar el perfil: " + e.getMessage());
		}
	}
}
