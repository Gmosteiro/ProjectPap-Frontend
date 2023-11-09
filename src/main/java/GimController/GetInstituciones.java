package GimController;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import logic.Institucion.InstitucionDeportiva;
import logic.Institucion.ManejadorInstitucion;

@WebServlet("/ObtenerInstitucionesServlet")
public class GetInstituciones extends HttpServlet {
    ManejadorInstitucion manejadorInstitucion = new ManejadorInstitucion();
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<InstitucionDeportiva> instituciones = getInstitucionesalBackend();

        StringBuilder textoInstituciones = new StringBuilder();
        for (InstitucionDeportiva institucion : instituciones) {
            textoInstituciones.append(institucion.getNombre()).append("\n");
        }

        // Configura la respuesta HTTP
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        // Envía la respuesta de texto plano al cliente
        response.getWriter().write(textoInstituciones.toString());
    }

    // Método para simular la obtención de datos de instituciones (puedes
    // reemplazarlo con tu lógica real)
    private List<InstitucionDeportiva> getInstitucionesalBackend() {
        List<InstitucionDeportiva> instituciones = manejadorInstitucion.getInstituciones();

        return instituciones;
    }
}