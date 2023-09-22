/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GimController;

/**
 *
 * @author xSanPrax
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AltaActividad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int duracion = Integer.parseInt(request.getParameter("duracion"));
        float costo = Float.parseFloat(request.getParameter("costo"));
        String fechaRegistro = request.getParameter("fechaRegistro");

        // Obtener la imagen del request
        InputStream imagenStream = request.getPart("imagen").getInputStream();
        byte[] imagenBytes = imagenStream.readAllBytes();

        // Guardar la imagen en el servidor (puedes adaptar la ruta)
       String rutaImagen = request.getServletContext().getRealPath("/uploads/") + nombre + ".jpg";
        Files.write(Paths.get(rutaImagen), imagenBytes);

        // Llamar a tu función para agregar la actividad (debes tenerla en tu código)
        agregarActividad(nombre, descripcion, duracion, costo, fechaRegistro, imagenBytes, "Gimnasio");

        // Redireccionar o mostrar mensaje de éxito
        response.sendRedirect("exito.jsp");
    }

    // Esta es una función de ejemplo, debes tener tu propia lógica
    private void agregarActividad(String nombre, String descripcion, int duracion, float costo,
                                  String fechaRegistro, byte[] imagenBytes, String institucion) {
        // Aquí debes agregar la lógica para agregar la actividad a tu sistema
        // Utiliza los parámetros recibidos para crear una nueva actividad
        // Por ejemplo: controllerAltaActividad.altaActividad(nombre, descripcion, duracion, costo, fechaRegistro, imagenBytes, institucion);
    }
}

