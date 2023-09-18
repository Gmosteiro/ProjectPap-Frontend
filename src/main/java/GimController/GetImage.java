package GimController;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/GetImage")

public class GetImage extends HttpServlet {

    // protected void doGet(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // // Configura el tipo de contenido para una imagen JPEG
    // response.setContentType("image/jpeg");
    // String path = getServletContext().getRealPath(File.separator);

    // File file = new File(path + "imagenes/img1.jpg");
    // BufferedImage imagen = ImageIO.read(file);
    // OutputStream respuesta = response.getOutputStream();
    // ImageIO.write(imagen, "jpeg", respuesta);
    // respuesta.close();
    // }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ServletContext cntx = req.getServletContext();
        // Get the absolute path of the image
        String filename = cntx.getRealPath("imagenes/UserIcon.png");
        // retrieve mimeType dynamically
        String mime = cntx.getMimeType(filename);
        if (mime == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        resp.setContentType(mime);
        File file = new File(filename);
        resp.setContentLength((int) file.length());

        FileInputStream in = new FileInputStream(file);
        OutputStream out = resp.getOutputStream();

        // Copy the contents of the file to the output stream
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
