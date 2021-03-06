package controladorUsuario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import servicios.UsuarioServicio;

@WebServlet("/usuario/crearUsuario.do")
public class CrearUsuarioServlet extends HttpServlet  implements Servlet {

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
				.getRequestDispatcher("/views/usuario/crearUsuario.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		String atraccionPreferida = req.getParameter("atraccionPreferida");
		String password = req.getParameter("password");
		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));

		Usuario tmp_user = usuarioServicio.create(nombre, presupuesto, tiempoDisponible, atraccionPreferida, password, admin);

		if (tmp_user.isValid()) {
			resp.sendRedirect("/jsp01/usuario/listaUsuarios.do");
		} else {
			req.setAttribute("tmp_user", tmp_user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuario/crearUsuario.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
