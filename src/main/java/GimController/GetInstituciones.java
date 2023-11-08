package GimController;

import java.io.IOException;
import java.rmi.RemoteException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.InstitucionDeportiva;

import java.util.List;

import javax.xml.rpc.ServiceException;

@WebServlet("/ObtenerInstitucionesServlet")
public class GetInstituciones extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            List<InstitucionDeportiva> instituciones;
            instituciones = getInstitucionesalBackend();

            StringBuilder textoInstituciones = new StringBuilder();
            for (InstitucionDeportiva institucion : instituciones) {
                textoInstituciones.append(institucion.getNombre()).append("\n");
            }

            // Configura la respuesta HTTP
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            // Envía la respuesta de texto plano al cliente
            response.getWriter().write(textoInstituciones.toString());

        } catch (ServiceException e) {

            e.printStackTrace();
        }
    }

    // Método para simular la obtención de datos de instituciones (puedes
    // reemplazarlo con tu lógica real)
    private List<InstitucionDeportiva> getInstitucionesalBackend() throws ServiceException {
        ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        ControladorPublish port = null;
        try {
            port = cps.getControladorPublishPort();

            List<InstitucionDeportiva> instituciones = null;

            instituciones = (List<InstitucionDeportiva>) port.getInstituciones();

            return instituciones;
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }
}