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
import modelo.Producto;
import modelo.Usuario;
import servicios.ItinerarioServicio;

@WebServlet("/itinerario/itinerario.do")
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
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		// List<Producto> productos = (List<Producto>)
		// req.getSession().getAttribute("productos");
		
		List<Producto> itinerario = itinerarioServicio.find(usuario);
		if (!itinerario.isEmpty()) {
			req.getSession().setAttribute("itinerario", itinerario);
			req.getSession().setAttribute("usuario", usuario);
		}else {
		}
		req.setAttribute("itinerario", itinerario);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/user-itinerario.jsp");
		dispatcher.forward(req, resp);

	}

}