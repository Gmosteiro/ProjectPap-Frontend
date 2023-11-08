package GimController;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.Sesion;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
            final ControladorPublish port = cps.getControladorPublishPort();

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            System.out.println("en el inicio 4 " + email + " " + password);
            Sesion usuarioLogeado = port.iniciarSesion(email, password);
            System.out.println("en el inicio ");
            if (usuarioLogeado != null) {
                // Almacena el usuario en la sesión
                System.out.println("en el inicio del fin " + email + " " + password);
                request.getSession().setAttribute("usuarioLogeado", usuarioLogeado != null ? usuarioLogeado : null);

                response.sendRedirect("menuPrincipal.jsp");
            } else {
                request.getSession().invalidate();
                System.out.println("en el inicio 4 " + email + " " + password);
                response.sendRedirect("index.jsp?error=Usuario o contrasena incorrectos");
            }
        } catch (Exception e) {
            System.out.println("Error validando el login " + e);
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=Usuario o contrasena incorrectos");

        }
    }

    // OPERACION CONSUMIDA

}
