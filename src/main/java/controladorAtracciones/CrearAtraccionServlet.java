package controladorAtracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Atraccion;
import servicios.AtraccionServicio;

@WebServlet("/atracciones/crearAtraccion.do")
public class CrearAtraccionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private AtraccionServicio atraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionServicio = new AtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/crearAtraccion.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		Double duracion = Double.parseDouble(req.getParameter("duracion"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipo = req.getParameter("tipo");

		Atraccion atraccion = atraccionServicio.create(nombre, costo, duracion, cupo, tipo);
		if (atraccion.esValida()) {
			resp.sendRedirect("/atracciones/listaAtracciones.do");
		} else {
			req.setAttribute("atraccion", atraccion);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/crearAtraccion.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
}