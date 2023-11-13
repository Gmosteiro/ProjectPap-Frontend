/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package GimController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.Sesion;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.json.JSONObject;

public class AltaClase extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
            ControladorPublish port = cps.getControladorPublishPort();
            System.out.println("Solicitud a AltaClase recibida");
            HttpSession session = request.getSession();
            Sesion currentSession = (Sesion) session.getAttribute("usuarioLogeado");
            String profesor = currentSession.getNombre();

            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            JSONObject jsonData = new JSONObject(sb.toString());

            String actividad = jsonData.getString("actividad");
            String nombreClase = jsonData.getString("nombreClase");
            String fechaHoraInicio = jsonData.getString("fechaHoraInicio");
            String imagenBase64 = jsonData.getString("imagen");
            // Obtiene los parámetros del formulario

            System.out.println("actividad " + actividad);

            System.out.println("nombreclase" + nombreClase);

            System.out.println("hora " + fechaHoraInicio);
            // Divide la cadena en fecha y hora
            String[] fechaHora = fechaHoraInicio.split("T");
            String fecha = fechaHora[0];
            String hora = fechaHora[1];
            System.out.println("fehca " + fecha);
            System.out.println("hora " + hora);
            // Parsea la cadena de fecha en un objeto LocalDate
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaInicio = LocalDate.parse(fecha, dateFormatter);

            // Parsea la cadena de hora en un objeto LocalTime
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaInicio = LocalTime.parse(hora, timeFormatter);
            // Obtengo la fecha del distema con solo yyy-mm-dd
            LocalDate fechaActual = LocalDate.now();
            // Consigo la imagen y la formateo a base64

            // Ya lo tengo formateado
            // empezar con las cosas

            port.addClase(nombreClase, fechaInicio, horaInicio, nombreClase, fechaActual, profesor, imagenBase64,
                    actividad);
            response.setContentType("text/plain");
            response.getWriter().write("La clase se ha dado de alta correctamente.");
        } catch (Exception e) {
            response.setContentType("text/plain");
            response.getWriter().write("Error al dar de alta la clase: " + e.getMessage());
        }
        // Finalmente, redirige o realiza cualquier acción adicional según tus
        // necesidades

    }

}