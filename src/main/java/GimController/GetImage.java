package GimController;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetImage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configura el tipo de contenido para una imagen JPEG
        response.setContentType("image/jpeg");
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa")

        // Obtiene la ruta real del archivo de imagen
        String path = getServletContext().getRealPath(File.separator);
        
        File file = new File(path + "imagenes/img1.jpg");
        
        // Lee la imagen desde el archivo
        BufferedImage imagen = ImageIO.read(file);
        
        // Obtiene el flujo de salida de la respuesta
        OutputStream respuesta = response.getOutputStream();
        
        // Escribe la imagen en el flujo de respuesta en formato JPEG
        ImageIO.write(imagen, "jpeg", respuesta);
        
        // Cierra el flujo de respuesta
        respuesta.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
