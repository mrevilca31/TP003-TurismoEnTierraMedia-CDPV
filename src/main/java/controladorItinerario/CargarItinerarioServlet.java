package controladorItinerario;

import java.io.IOException;

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
import modelo.Usuario;
import servicios.ItinerarioServicio;
import servicios.UsuarioServicio;

@WebServlet("/itinerario/cargarItinerario.do")
public class CargarItinerarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private ItinerarioServicio itinerarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioServicio = new ItinerarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/itinerario/cargarItinerario.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("usuario");
		String producto = req.getParameter("producto");
		Usuario user = UsuarioServicio.find(usuario);
		//FALTA AGREGAR LA PARTE DE PRODUCTO

		Itinerario itinerario = itinerarioServicio.create(user, producto);
		resp.sendRedirect("/itinerario/index.do");
	}

}
