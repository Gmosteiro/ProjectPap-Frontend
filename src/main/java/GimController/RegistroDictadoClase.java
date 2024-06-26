package GimController;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.DtActividadDeportiva;
import publicadores.DtInstitucion;

@WebServlet("/RegistroDictadoClase")

public class RegistroDictadoClase extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        ControladorPublish port = null;
        try {
            port = cps.getControladorPublishPort();

            String nombreInstitucion = request.getParameter("nombreInstitucion");
            if (nombreInstitucion != null && nombreInstitucion.length() > 0) {
                DtInstitucion instituto = port.getInstitucionesByName(nombreInstitucion);
                DtActividadDeportiva[] listaactividades = port.getActividadesByInstitucion(instituto.getNombre());

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                JSONArray actividadesArray = new JSONArray();

                for (DtActividadDeportiva actividadDeportiva : listaactividades) {

                    JSONObject actividadJSON = new JSONObject();
                    actividadJSON.put("nombre", actividadDeportiva.getNombre());

                    actividadesArray.put(actividadJSON);
                }

                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("ERROR", false);
                jsonResponse.put("Actividades", actividadesArray);

                response.getWriter().write(jsonResponse.toString());

            } else {

                DtInstitucion[] instituciones = port.getInstituciones();
                System.out.println("Instituciones: " + instituciones);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                JSONArray institucionesArray = new JSONArray();

                for (DtInstitucion institucion : instituciones) {

                    JSONObject institucionJSON = new JSONObject();
                    institucionJSON.put("nombre", institucion.getNombre());

                    institucionesArray.put(institucionJSON);
                }

                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("ERROR", false);
                jsonResponse.put("Instituciones", institucionesArray);

                response.getWriter().write(jsonResponse.toString());

            }
        } catch (ServiceException e) {

            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
            ControladorPublish port = cps.getControladorPublishPort();
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

            LocalDate fecha = LocalDate.now();

            // response
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            JSONObject jsonResponse = new JSONObject();

            boolean existeRegistro = port.validateDataWeb(socio, clase);
            System.out.println("validate: " + existeRegistro);

            if (existeRegistro) {

                jsonResponse.put("ERROR", existeRegistro);
                jsonResponse.put("Message", " Ya existe un registro para los datos ingresados ");
                response.getWriter().write(jsonResponse.toString());

            } else {

                // String nicknameSocio, String nombreClase, LocalDate fechaReg
                boolean registro = port.addRegistroDictadoWeb(socio, clase, fecha.toString());
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
