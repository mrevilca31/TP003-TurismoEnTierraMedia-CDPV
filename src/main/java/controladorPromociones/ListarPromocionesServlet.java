package controladorPromociones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Promocion;
import servicios.PromocionServicio;


@WebServlet("/promociones/index.do")
public class ListarPromocionesServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private PromocionServicio promocionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionServicio = new PromocionServicio ();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Promocion> promocion = promocionServicio.list();
		req.setAttribute("promocion", promocion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promociones/index.jsp");
		dispatcher.forward(req, resp);

	}

}
