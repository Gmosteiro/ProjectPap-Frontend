package GimController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import logic.ActividadDeportiva.ActividadDeportiva;
import logic.ActividadDeportiva.ManejadorActividad;
import logic.Clase.Clase;
import logic.Fabrica;
import logic.Usuario.Sesion;
import logic.Usuario.controllers.IControllerInicioSesion;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GetClases", urlPatterns = {"/GetClases"})
public class GetClases extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        String actividadNombre = request.getParameter("actividad");
        
        if (actividadNombre != null) {
            ActividadDeportiva actividaddeportiva = ManejadorActividad.obtenerActividadPorNombre(actividadNombre);
            if(actividaddeportiva !=null){
            List<Clase> listaClases = actividaddeportiva.getClases();
            
            request.setAttribute("clases", listaClases);
            }
            else {
            request.setAttribute("error", "Por favor, ingresa una actividad válida.");
            }
        } else {
            request.setAttribute("error", "Por favor, ingresa una actividad válida.");
        }
        
        request.getRequestDispatcher("/consultardicClase.jsp").forward(request, response);
    }
    
     
    
}
