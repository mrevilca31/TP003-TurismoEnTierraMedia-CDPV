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
import modelo.Producto;
import modelo.Usuario;
import servicios.OrdenadorServicio;

@WebServlet("/usuario/inicio.do")
public class OrdenarProductosServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private OrdenadorServicio ordenadorServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.ordenadorServicio = new OrdenadorServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = ((Usuario) req.getSession().getAttribute("usuario"));
		String nombre = usuario.getNombre();
		List<Producto> ofertas = ordenadorServicio.crearListaOrdenada(nombre);
		req.setAttribute("ofertas", ofertas);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/user-inicio.jsp");
		dispatcher.forward(req, resp);

	}

}
