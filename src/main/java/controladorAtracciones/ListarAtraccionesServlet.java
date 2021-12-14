package controladorAtracciones;

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
import modelo.Usuario;
import servicios.AtraccionServicio;

@WebServlet("/atracciones/listaAtracciones.do")
public class ListarAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private AtraccionServicio atraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionServicio = new AtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Atraccion> atraccion = atraccionServicio.list();
		req.setAttribute("atracciones", atraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/admin-atracciones.jsp");
		dispatcher.forward(req, resp);
		
		/*Usuario usuario;
		if(usuario.isAdmin().booleanValue()) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/admin-atracciones.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/atracciones/user-atracciones.jsp");
			dispatcher.forward(req, resp);
		}*/
	}

}
