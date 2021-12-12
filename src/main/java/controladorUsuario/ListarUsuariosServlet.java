package controladorUsuario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import servicios.UsuarioServicio;

@WebServlet("/usuarios/index.do")
public class ListarUsuariosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private UsuarioServicio usuarioServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioServicio = new UsuarioServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Usuario> usuario = usuarioServicio.list();
		req.setAttribute("usuario", usuario);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuario/index.jsp");
		//Aca creo que tiene que ir a la pagina de admin/usuarios.jsp
		dispatcher.forward(req, resp);

	}

}
