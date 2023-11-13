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
        
        System.out.println("Adentro del Servlet GetImages");
        
        String imageName = request.getParameter("imageName");
        System.out.println("ImageName "+imageName);
        response.setContentType("image/jpg");
        String path2 = getServletContext().getRealPath(File.separator);
        File file = new File(path2, "imagenes/"+imageName);

        BufferedImage binarioImagen = ImageIO.read(file);
        OutputStream respuesta = response.getOutputStream();
        ImageIO.write(binarioImagen, "png", respuesta);
        respuesta.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
