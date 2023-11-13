package GimController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
