/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xSanPrax
 */

package GimController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.ActividadDeportiva.controllers.IControllerAltaActividad;
import logic.Fabrica;

public class AltaActividad extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AltaActividad.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            int duracion = Integer.parseInt(request.getParameter("duracion"));
            float costo = Float.parseFloat(request.getParameter("costo"));
            String fechaRegistro = request.getParameter("fechaRegistro");

            LocalDate fechaRegistroLocalDate = LocalDate.parse(fechaRegistro);

            // Obtener la imagen del request
            InputStream imagenStream = request.getPart("imagen").getInputStream();
            byte[] imagenBytes = imagenStream.readAllBytes();

            // Guardar la imagen en el servidor (puedes adaptar la ruta)
            String rutaImagen = request.getServletContext().getRealPath("/uploads/") + nombre + ".jpg";
            Files.write(Paths.get(rutaImagen), imagenBytes);

            // Llamar a tu función para agregar la actividad
            boolean resultado = agregarActividad(nombre, descripcion, duracion, costo, fechaRegistroLocalDate,
                    imagenBytes, "Gimnasio");

            if (resultado) {
                response.sendRedirect("exito.jsp");
            } else {
                response.sendRedirect("error.jsp"); // Puedes personalizar la página de error
            }
        } catch (NumberFormatException | IOException e) {
            LOGGER.log(Level.SEVERE, "Error al procesar la solicitud", e);
            response.sendRedirect("error.jsp"); // Puedes personalizar la página de error
        }
    }

    private boolean agregarActividad(String nombre, String descripcion, int duracion, float costo,
            LocalDate fechaRegistro, byte[] imagenBytes, String nombreInstitucion) {
        try {
            Fabrica factory = new Fabrica();
            IControllerAltaActividad controller = factory.getControladorAltaActividad();

            if (validateActivityData(nombre)) {
                // controller.altaActividad(nombre, descripcion, duracion, costo, fechaRegistro,
                // imagenBytes, nombreInstitucion);
                JOptionPane.showMessageDialog(
                        null, // Parent component (null for default)
                        "Actividad Creada!", // Message text
                        "Success", // Dialog title
                        JOptionPane.INFORMATION_MESSAGE // Message type
                );
                return true;
            } else {
                // Manejar el caso de actividad duplicada
                return false;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al agregar actividad", e);
            return false;
        }
    }

    private boolean validateActivityData(String nombre) {
        // Verificar si el nombre de la actividad es válido
        if (nombre != null && !nombre.isEmpty()) {

            return true; // Si la validación es exitosa
        } else {
            return false; // Si la validación falla
        }

    }
}
