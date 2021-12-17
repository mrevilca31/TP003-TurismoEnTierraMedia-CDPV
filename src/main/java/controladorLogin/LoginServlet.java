package controladorLogin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import servicios.LoginServicio;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 8308079314140233763L;
	private LoginServicio loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginServicio();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String password = req.getParameter("password");

		Usuario usuario = loginService.login(nombre, password);

		if (!usuario.isNull() && !usuario.isAdmin().booleanValue()) {
			req.getSession().setAttribute("usuario", usuario);
			resp.sendRedirect("usuario/inicio.do");
		} else if (!usuario.isNull() && usuario.isAdmin().booleanValue()) {
			req.getSession().setAttribute("usuario", usuario);
			resp.sendRedirect("usuario/listaUsuarios.do");
		} else {
			req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
