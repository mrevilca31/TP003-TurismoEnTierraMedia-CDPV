package controladorItinerario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Atraccion;
import modelo.Itinerario;
import modelo.Producto;
import servicios.ItinerarioServicio;

@WebServlet("/itinerario/index.do")
public class ListarItinerarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private ItinerarioServicio itinerarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioServicio = new ItinerarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Itinerario> itinerario = itinerarioServicio.find(int id, List<Producto> productos);
		req.setAttribute("itinerario", itinerario);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/iti/index.jsp");
		dispatcher.forward(req, resp);

	}

}
