package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List; // Importa la clase List si no está importada

import javax.xml.rpc.ServiceException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.*;
import publicadores.Clase;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;

import java.io.OutputStream;



public class GetImagenClase extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        try {
			ControladorPublish port = cps.getControladorPublishPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Aquí debes implementar la lógica para obtener los datos de la imagen en base64
        String nombreClase = request.getParameter("nombreClase"); // Obtén el nombre de la clase de la solicitud
        
        // Supongamos que tienes una función que obtiene la imagen de la clase en formato base64
        String imagenBase64 = obtenerImagenDeClaseEnBase64(nombreClase);

        if (imagenBase64 != null) {
            // Establece la respuesta como una imagen en formato base64
            response.setContentType("text/plain");
            OutputStream out = response.getOutputStream();
            out.write(imagenBase64.getBytes());
            out.flush();
            out.close();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    // Implementa esta función para obtener la imagen de la clase en base64
    private String obtenerImagenDeClaseEnBase64(String nombreClase) {
    	ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        ControladorPublish port = null;
		try {
			port = cps.getControladorPublishPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Aquí debes implementar la lógica para obtener la imagen de la clase en base64
        // Deberías cargar la imagen desde una ubicación, convertirla a base64 y devolverla como una cadena.
        // Retorna null si no se encuentra la imagen.
        // Por ejemplo, puedes usar bibliotecas como Apache Commons Codec para convertir una imagen a base64.

        Clase clase = null;
		try {
			clase = port.obtenerClasePorNombre(nombreClase);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return clase.getImg();
    }
}