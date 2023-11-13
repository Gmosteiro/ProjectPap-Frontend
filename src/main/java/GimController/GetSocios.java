/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package GimController;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import publicadores.Clase;
import publicadores.ControladorPublish;
import publicadores.ControladorPublishServiceLocator;
import publicadores.InstitucionDeportiva;
import publicadores.Socio;
import publicadores.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

/**
 *
 * @author Admin
 */
public class GetSocios extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

    private ArrayList<Usuario> Socios(String Clase) {
        ControladorPublishServiceLocator cps = new ControladorPublishServiceLocator();
        ControladorPublish port = null;
        try {
            port = cps.getControladorPublishPort();

            Clase clase = null;

            clase = port.getClaseByNombre(Clase);

            java.util.ArrayList socios = port.getSociosByClase(clase);
            ArrayList<Usuario> usuarios = new ArrayList<>();
            List<Usuario> socioss = (List<Usuario>) socios;
            for (Usuario socio : socioss) {
                Usuario usuario = (Usuario) socio; // Realiza el casting de Socio a Usuario
                usuarios.add(usuario); // Agrega el usuario a la lista de usuarios
            }

            return usuarios;
        } catch (RemoteException | ServiceException e) {

            e.printStackTrace();
            return null;

        }

    }

}
