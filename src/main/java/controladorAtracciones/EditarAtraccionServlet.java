package controladorAtracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Atraccion;
import servicios.AtraccionServicio;

@WebServlet("/attractions/edit.do")
public class EditarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionServicio atraccionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionServicio = new AtraccionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion atraccion = atraccionServicio.find(id);
		req.setAttribute("atraccion", atraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer costo = req.getParameter("costo").trim() == "" ? null : Integer.parseInt(req.getParameter("costo"));
		Double duracion = Double.parseDouble(req.getParameter("duracion"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipo = req.getParameter("tipo");

		Atraccion atraccion = atraccionServicio.update(id, nombre, costo, duracion, cupo, tipo);

		if (atraccion.esValida()) {
			resp.sendRedirect("/turismo/attractions/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
