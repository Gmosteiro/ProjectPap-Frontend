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
import javax.xml.rpc.ServiceException;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.DtClase;
import publicadores.DtUsuario;

public class GetSocios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String claseNombre = request.getParameter("nombreClase");

        if (claseNombre != null && !claseNombre.isEmpty()) {
            try {
                // Intentamos obtener los socios solo si se proporciona un nombre de clase
                // válido
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
            } catch (ServiceException ex) {
                Logger.getLogger(GetSocios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Manejar el caso si no se proporciona un nombre de clase válido
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Por favor, ingresa un nombre de clase válido.");
        }
    }

    private DtUsuario[] obtenerSocios(String nombreClase) throws ServiceException {
        try {
            ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
            ControladorPublish port;

            port = cps.getControladorPublishPort();

            DtClase clase = port.getClaseByNombre(nombreClase);

            if (clase != null) {

                return port.getSociosByClase(clase);

            } else {

                return null;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GetSocios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
