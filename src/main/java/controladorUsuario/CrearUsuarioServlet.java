package controladorUsuario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import servicios.UsuarioServicio;

@WebServlet("/users/create.do")
public class CrearUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private UsuarioServicio usuarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioServicio = new UsuarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuario/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		String atraccionPreferida = req.getParameter("atraccionPreferida");
		String password = req.getParameter("password");
		
		Usuario user = usuarioServicio.create(nombre, presupuesto, tiempoDisponible, atraccionPreferida, password);
		
		if (user.isValid()) {
			resp.sendRedirect("/turismo/usuario/index.do");
		} else {
			req.setAttribute("user", user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuario/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
