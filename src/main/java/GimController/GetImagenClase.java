package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List; // Importa la clase List si no está importada

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import logic.Fabrica;
import logic.Clase.Clase;
import logic.Clase.controllers.IControllerConsultaClases;
import logic.Usuario.controllers.IControllerConsultaUsuario;
import jakarta.servlet.http.*;
import java.io.OutputStream;
import logic.ActividadDeportiva.ActividadDeportiva;
import logic.ActividadDeportiva.ManejadorActividad;



public class GetImagenClase extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        // Aquí debes implementar la lógica para obtener la imagen de la clase en base64
        // Deberías cargar la imagen desde una ubicación, convertirla a base64 y devolverla como una cadena.
        // Retorna null si no se encuentra la imagen.
        // Por ejemplo, puedes usar bibliotecas como Apache Commons Codec para convertir una imagen a base64.
         Fabrica factory = new Fabrica();
        IControllerConsultaClases controllerClases = factory.getControllerConsultaClases();
        Clase clase = controllerClases.obtenerClasePorNombre(nombreClase);
        
        return clase.getImg();
    }
}