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

// @WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Fabrica factory = new Fabrica();
        IControllerInicioSesion controller = factory.getControllerInicioSesion();

        System.out.println("Data" + email + " | " + password);

        Usuario usuarioLogeado = controller.iniciarSesion(email, password);
        System.out.println("Usuario: " + usuarioLogeado.getNickname());
        if (usuarioLogeado != null) {
            response.sendRedirect("menuPrincipal.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }

}
