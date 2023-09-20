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

//@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Fabrica factory = new Fabrica();
            IControllerInicioSesion controller = factory.getControllerInicioSesion();

            System.out.println("Data: " + email + " | " + password);

            Usuario usuarioLogeado = controller.iniciarSesion(email, password);

            if (usuarioLogeado != null) {
                System.out.println("Usuario: " + usuarioLogeado.getNickname());
                response.sendRedirect("menuPrincipal.jsp");
            } else {
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=2"); // Redirige con un código de error apropiado
        }
    }
}
