package GimController;

import java.io.IOException;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

import jakarta.servlet.http.*;
import publicadores.Clase;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;

import java.io.OutputStream;
import publicadores.DtClase;

public class GetImagenClase extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            String nombreClase = request.getParameter("nombreClase");

            String imagenBase64;
            imagenBase64 = obtenerImagenDeClaseEnBase64(nombreClase);

            if (imagenBase64 != null) {

                response.setContentType("text/plain");
                OutputStream out = response.getOutputStream();
                out.write(imagenBase64.getBytes());
                out.flush();
                out.close();
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (ServiceException e) {

            e.printStackTrace();
        }
    }

    private String obtenerImagenDeClaseEnBase64(String nombreClase) throws ServiceException {
        ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        ControladorPublish port = null;
        try {
            port = cps.getControladorPublishPort();

            DtClase clase = null;

            clase = port.obtenerClasePorNombre(nombreClase);

            return clase.getImagen();
        } catch (RemoteException e) {

            e.printStackTrace();
            return null;
        }
    }
}