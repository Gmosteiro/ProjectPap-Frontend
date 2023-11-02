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
import publicadores.ControladorPublish;
import publicadores.ControladorPublishService;
import publicadores.ControladorPublishServiceLocator;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String email = request.getParameter("email");
            String password = request.getParameter("password");


            publicadores.Sesion usuarioLogeado = iniciarSesion(email, password);

            if (usuarioLogeado != null) {
                // Almacena el usuario en la sesión
                request.getSession().setAttribute("usuarioLogeado", usuarioLogeado != null ? usuarioLogeado : null);

                response.sendRedirect("menuPrincipal.jsp");
            } else {
                request.getSession().invalidate();

                response.sendRedirect("index.jsp?error=Usuario o contrasena incorrectos");
            }
        } catch (Exception e) {
            System.out.println("Error validando el login " + e);
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=Usuario o contrasena incorrectos");

        }
    }
    
    //OPERACION CONSUMIDA
    
    public publicadores.Sesion iniciarSesion(String email, String password) throws Exception {
    	ControladorPublishService cps = new ControladorPublishServiceLocator();
    	ControladorPublish port = cps.getControladorPublishPort();
    	return port.iniciarSesion(email, password);
    }
} 
















