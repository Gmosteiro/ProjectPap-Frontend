/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import logic.ActividadDeportiva.ActividadDeportiva;
import logic.ActividadDeportiva.ManejadorActividad;
import logic.Institucion.InstitucionDeportiva;
import logic.Institucion.ManejadorInstitucion;
import logic.Clase.Clase;

/**
 *
 * @author Admin
 */
public class GetActividades extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        String institucionNombre = request.getParameter("institucion");
        
        if (institucionNombre != null) {
            InstitucionDeportiva instituto = ManejadorInstitucion.getInstitucionesByName(institucionNombre);
            List<ActividadDeportiva> listaactividades = instituto.getActividades();
            
            request.setAttribute("nombresActividades", listaactividades);
            
        } else {
            //request.setAttribute("error", "Por favor, ingresa una actividad válida.");
        }
        
        request.getRequestDispatcher("/consultardicClase.jsp").forward(request, response);
    }
    
     
   
}
