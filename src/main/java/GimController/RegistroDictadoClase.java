package GimController;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.Fabrica;
import logic.Usuario.ManejadorUsuarios;
import logic.Usuario.Registro;
import logic.Usuario.controllers.IControllerRegistroDictado;

@WebServlet("/RegistroDictadoClase")

public class RegistroDictadoClase extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            System.out.println("En Registro Dictado Clase");
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            JSONObject jsonData = new JSONObject(sb.toString());

            String socio = jsonData.getString("socio");
            String clase = jsonData.getString("clase");
            String fechaStr = jsonData.getString("fecha");

            LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Fabrica factory = new Fabrica();

            IControllerRegistroDictado controller = factory.getControllerRegistroDictado();

            // response
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            JSONObject jsonResponse = new JSONObject();

            boolean validate = controller.validateDataWeb(socio, clase);
            System.out.println("validate: " + validate);

            if (!validate) {

                jsonResponse.put("ERROR", !validate);
                jsonResponse.put("Message", " Ya existe un registro para los datos ingresados ");
                response.getWriter().write(jsonResponse.toString());

            } else {

                // String nicknameSocio, String nombreClase, LocalDate fechaReg
                boolean registro = controller.addRegistroDictadoWeb(socio, clase, fecha);
                System.out.println("registro: " + registro);

                jsonResponse.put("ERROR", !registro);
                jsonResponse.put("Message", !registro ? "Error al crear registro " : "Creado con exito ");

                System.out.println("response: " + jsonResponse.toString());

                response.getWriter().write(jsonResponse.toString());
            }

        } catch (Exception e) {
            // Manejar el error apropiadamente y enviar una respuesta de error al cliente si
            // es necesario
            System.out.println("Catch " + e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{Error : " + e.getMessage() + "}");
        }
    }

}