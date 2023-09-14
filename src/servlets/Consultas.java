package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtClase;
import datatypes.DtSocio;
import interfaces.Fabrica;
import interfaces.IControlador;

/**
 * Servlet implementation class Consultas
 */
@WebServlet("/Consultas")
public class Consultas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstancia();
		IControlador icon = fabrica.getIControlador();
		int idClase = Integer.valueOf(request.getParameter("idClase"));
		if (request.getParameter("boton").equals("clase")){
			DtClase dtc = icon.obtenerClase(idClase);
			request.setAttribute("dtclase", dtc);
			request.setAttribute("mostrar", "clase");
		}else if (request.getParameter("boton").equals("socios")) {
			ArrayList<DtSocio> socios = icon.obtenerInfoSociosPorClase(idClase);
			request.setAttribute("socios", socios);
			request.setAttribute("mostrar", "socios");
		}
		request.setAttribute("idClase", idClase);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/infoClase.jsp");
		rd.forward(request, response);
	}

}
