/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.Clase;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.Usuario;

import static java.lang.System.console;
import java.util.List;

import javax.xml.rpc.ServiceException;
/**
 *
 * @author Admin
 */
public class GetSocios extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	  ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
    	    try {
				ControladorPublish port = cps.getControladorPublishPort();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    String claseNombre = request.getParameter("nombreClase");
  
    if (claseNombre != null) {
        // Aquí debes obtener los socios de la clase utilizando el nombre de la clase
        // Reemplaza esta parte con tu lógica para obtener los socios
        
        List<Usuario> socios = Socios(claseNombre);
        // Construye una lista de nombres de socios en formato de texto plano
        StringBuilder textoSocios = new StringBuilder();
        for (Usuario socio : socios) {
            textoSocios.append(socio.getNickname()).append("\n");
        }

        // Configura la respuesta HTTP como texto plano
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        
        // Envía la lista de nombres de socios como respuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(textoSocios.toString());
    } else {
        // Maneja el caso si no se proporciona un nombre de clase válido
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Por favor, ingresa un nombre de clase válido.");
    }
}
    private  List<Usuario> Socios(String Clase){
    	  ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
    	    ControladorPublish port = null;
			try {
				port = cps.getControladorPublishPort();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        Clase clase = null;
		try {
			clase = port.getClaseByNombre(Clase);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<Usuario> socios = null;
		try {
			socios = (List<Usuario>) port.getSociosByClase(clase);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return socios;
    }

}
