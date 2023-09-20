package GimController;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtiene los parámetros del formulario
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Realiza la validación del inicio de sesión aquí, consulta la base de datos,
        // etc.
        // ...

        // Si la validación es exitosa, puedes redirigir al usuario o enviar una
        // respuesta de éxito
        if (validarInicioSesion(email, password)) {
            // Redirige al usuario a una página de inicio o muestra un mensaje de éxito
            response.sendRedirect("menuPrincipal.jsp");
        } else {
            // El inicio de sesión falló, puedes mostrar un mensaje de error
            response.sendRedirect("login.jsp?error=1"); // Puedes pasar un parámetro para indicar el error
        }
    }

    // Método para validar el inicio de sesión en la base de datos
    private boolean validarInicioSesion(String email, String password) {
        // Lógica de validación de inicio de sesión aquí
        // Retorna true si es exitoso, false si falla
        // ...
        return true;
    }
}
