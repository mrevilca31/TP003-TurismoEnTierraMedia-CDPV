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
import servicios.AtraccionServicio;

@WebServlet("/atracciones/listaAtraccionesUsuario.do")
public class ListarAtraccionesUsuarioServlet extends HttpServlet implements Servlet {

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
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/user-atracciones.jsp");
		dispatcher.forward(req, resp);

	}

}
