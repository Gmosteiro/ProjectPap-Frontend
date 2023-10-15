package GimController;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.Fabrica;
import logic.Usuario.Sesion;
import logic.Usuario.controllers.IControllerInicioSesion;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Fabrica factory = new Fabrica();
            IControllerInicioSesion controller = factory.getControllerInicioSesion();

            Sesion usuarioLogeado = controller.iniciarSesion(email, password);

            if (usuarioLogeado != null) {
                // Almacena el usuario en la sesión
                request.getSession().setAttribute("usuarioLogeado", usuarioLogeado);
                request.getSession().setAttribute("userEmail", email);
                request.getSession().setAttribute("userPass", password);

                response.sendRedirect("menuPrincipal.jsp");
            } else {
                response.sendRedirect("index.jsp?error=Usuario o contrasena incorrectos");
            }
        } catch (Exception e) {
            System.out.println("Error validando el login " + e);
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=Usuario o contrasena incorrectos");

        }
    }

}