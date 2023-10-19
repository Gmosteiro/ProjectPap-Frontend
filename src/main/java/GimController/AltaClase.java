/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import logic.Clase.controllers.IControllerAltaClase;
import logic.Fabrica;
import logic.Usuario.Sesion;



public class AltaClase extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        System.out.println("Solicitud a AltaClase recibida");   
        HttpSession session = request.getSession();
        Sesion currentSession = (Sesion) session.getAttribute("usuarioLogeado");
        String profesor = currentSession.getNombre();
        // Obtiene los parámetros del formulario
            String actividad = request.getParameter("actividad");
            String nombreClase = request.getParameter("nombreClase");
            String fechaHoraInicio = request.getParameter("fechaHoraInicio");

            System.out.println("hora "+fechaHoraInicio);
        // Divide la cadena en fecha y hora
            String[] fechaHora = fechaHoraInicio.split("T");
            String fecha = fechaHora[0];
            String hora = fechaHora[1];
            System.out.println("fehca "+fecha);
            System.out.println("hora "+hora);
        // Parsea la cadena de fecha en un objeto LocalDate
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaInicio = LocalDate.parse(fecha, dateFormatter);

        // Parsea la cadena de hora en un objeto LocalTime
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaInicio = LocalTime.parse(hora, timeFormatter);
        // Obtengo la fecha del distema con solo yyy-mm-dd
            LocalDate fechaActual = LocalDate.now();
        //Consigo la imagen y la formateo a base64
            Part filePart = request.getPart("imagen");
            InputStream fileContent = filePart.getInputStream();
            byte[] imageBytes = new byte[(int) filePart.getSize()];
            fileContent.read(imageBytes);
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        //Ya lo tengo formateado
        //empezar con las cosas
            Fabrica factory = new Fabrica();
            IControllerAltaClase controllerAltaClase = factory.getControladorAltaClase();
            controllerAltaClase.addClase(nombreClase, fechaInicio, horaInicio, nombreClase, fechaActual, profesor, base64Image, actividad);
        response.setContentType("text/plain");
        response.getWriter().write("La clase se ha dado de alta correctamente.");

        // Finalmente, redirige o realiza cualquier acción adicional según tus necesidades
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}