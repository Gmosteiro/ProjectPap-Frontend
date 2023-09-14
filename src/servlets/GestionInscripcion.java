package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IControlador;

@WebServlet("/GestionInscripcion")
public class GestionInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GestionInscripcion() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControlador icon = fabrica.getIControlador();
		String ciSocio = request.getParameter("cedSocio");
		int idClase = Integer.valueOf(request.getParameter("idClase"));
		if (request.getParameter("boton").equals("agregar")) {
			icon.agregarInscripcion(ciSocio, idClase, new Date());
			request.setAttribute("mensaje", "Se ha ingresado correctamente al sistema la inscripción del socio " + ciSocio + " en la clase " + idClase);
		}else if (request.getParameter("boton").equals("eliminar")){
			icon.borrarInscripcion(ciSocio, idClase);
			request.setAttribute("mensaje", "Se ha eliminado del sistema la inscripción del socio " + ciSocio + " de la clase " + idClase);
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}
}
