package GimController;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CerrarSesion")
public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtén la sesión actual o crea una nueva si no existe
		HttpSession session = request.getSession();

		// if (session != null) {
		// Invalida (borra) la sesión actual
		session.invalidate();
		// }

		// Redirige al usuario a la página de inicio (index.jsp)
		response.sendRedirect("index.jsp");
	}
}
