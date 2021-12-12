package controladorPromociones;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import persistenciaGeneral.DAOFactory;
import servicios.ComprarPromocionServicio;

@WebServlet("/promociones/buy.do")
public class ComprarPromocionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private ComprarPromocionServicio comprarPromocionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarPromocionServicio = new ComprarPromocionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer promocionId = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Map<String, String> errors = comprarPromocionServicio.comprar(usuario.getId(), promocionId);

		Usuario usuario2 = DAOFactory.getUsuarioDAO().find(usuario.getId());
		req.getSession().setAttribute("usuario", usuario2);

		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/promociones/index.do");
		dispatcher.forward(req, resp);
	}

}
