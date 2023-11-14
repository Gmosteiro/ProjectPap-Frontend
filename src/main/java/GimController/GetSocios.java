package GimController;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import publicadores.Clase;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.DtUsuario;

import javax.xml.rpc.ServiceException;

public class GetSocios extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String claseNombre = request.getParameter("nombreClase");

        if (claseNombre != null && !claseNombre.isEmpty()) {
            // Intentamos obtener los socios solo si se proporciona un nombre de clase válido
            DtUsuario[] socios = obtenerSocios(claseNombre);

            if (socios != null) {
                // Construir una lista de nombres de socios en formato de texto plano
                StringBuilder textoSocios = new StringBuilder();
                for (DtUsuario socio : socios) {
                    textoSocios.append(socio.getNickname()).append("\n");
                }

                // Configurar la respuesta HTTP como texto plano
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");

                // Enviar la lista de nombres de socios como respuesta al cliente
                PrintWriter out = response.getWriter();
                out.print(textoSocios.toString());
            } else {
                // Si no se pudieron obtener los socios, enviar un mensaje de error
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No se pudieron obtener los socios.");
            }
        } else {
            // Manejar el caso si no se proporciona un nombre de clase válido
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Por favor, ingresa un nombre de clase válido.");
        }
    }

    private DtUsuario[] obtenerSocios(String nombreClase) {
        ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        ControladorPublish port;

        try {
            port = cps.getControladorPublishPort();

            // Obtener la clase por su nombre
            Clase clase = null;
            try {
                clase = port.getClaseByNombre(nombreClase);
            } catch (RemoteException ex) {
                Logger.getLogger(GetSocios.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (clase != null) {
                try {
                    // Obtener los socios de la clase si se encontró la clase
                    return port.getSociosByClase(clase);
                } catch (RemoteException ex) {
                    Logger.getLogger(GetSocios.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // Si la clase no se encontró, retorna null
                return null;
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        // Si hay un error, retornar null
        return null;
    }
}
