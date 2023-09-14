package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtClase;
import datatypes.DtEntrenamiento;
import datatypes.DtSpinning;
import datatypes.Turno;
import interfaces.Fabrica;
import interfaces.IControlador;

/**
 * Servlet implementation class AgregarClase
 */
@WebServlet("/AgregarClase")
public class AgregarClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AgregarClase() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControlador icon = fabrica.getIControlador();
		int id = Integer.valueOf(request.getParameter("idClase"));
		Turno turno = null;
		DtClase dtc = null;
		if (request.getParameter("turnoClase").equals("manana")) {
			turno = Turno.Manana;
		}else if(request.getParameter("turnoClase").equals("tarde")){
			turno = Turno.Tarde;
		}else if(request.getParameter("turnoClase").equals("noche")){
			turno = Turno.Noche;
		}
		String nombre = request.getParameter("nomClase");
		if (request.getParameter("tipoClase").equals("entrenamiento")){
			boolean enRambla = false;
			if (request.getParameter("enRamblaLaClase").equals("Si")) {
				enRambla=true;
			}
			dtc = new DtEntrenamiento(id, nombre, turno, enRambla);
		}else {
			int cantBicicletas = Integer.valueOf(request.getParameter("cantBicicletasClase"));
			dtc = new DtSpinning(id, nombre, turno, cantBicicletas);
		}
		icon.agregarClase(dtc);
		RequestDispatcher rd;
		request.setAttribute("mensaje", "Se ha ingresado correctamente la clase " + nombre + " de ID " + id + " en el sistema.");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

}
