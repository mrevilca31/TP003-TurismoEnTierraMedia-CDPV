package controladorPromociones;

/*@WebServlet("/promociones/crearPromocion.do")

public class CrearPromocionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private PromocionServicio promocionServicio;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionServicio = new PromocionServicio();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/crearPromocion.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HAY QUE CORREGIR LOS PARAMETROS

		String nombre = req.getParameter("nombre");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		Double duracion = Double.parseDouble(req.getParameter("duracion"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String tipo = req.getParameter("tipo");

		Promocion promocion = promocionServicio.create(nombre, costo, duracion, cupo, tipo);
		if (promocion.esValida()) {
			resp.sendRedirect("/promociones/index.do");
		} else {
			req.setAttribute("promociones", promocion);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promocion/crearPromocion.jsp");
			dispatcher.forward(req, resp);
		}
	}

}*/
