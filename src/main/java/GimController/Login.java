package GimController;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.Fabrica;
import logic.Usuario.Usuario;
import logic.Usuario.controllers.ControllerInicioSesion;
import logic.Usuario.controllers.IControllerInicioSesion;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Crear una instancia de la fábrica
            Fabrica factory = new Fabrica();
            
            // Obtener el controlador de inicio de sesión
            IControllerInicioSesion controller = factory.getControllerInicioSesion();

            // Imprimir los datos (esto puede ser útil para propósitos de depuración)
            System.out.println("Data: " + email + " | " + password);

            // Iniciar sesión
            Usuario usuarioLogeado = controller.iniciarSesion(email, password);

            if (usuarioLogeado != null) {
                // Si el inicio de sesión es exitoso, redirigir a la página principal
                System.out.println("Usuario: " + usuarioLogeado.getNickname());
                response.sendRedirect("menuPrincipal.jsp");
            } else {
                // Si el inicio de sesión falla, redirigir de nuevo a la página de inicio de sesión con un mensaje de error
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (Exception e) {
            // Manejar la excepción adecuadamente (log, redirigir, etc.)
            e.printStackTrace(); // Considera usar un sistema de registro como Log4j
            response.sendRedirect("login.jsp?error=2"); 
        }
    }
}
