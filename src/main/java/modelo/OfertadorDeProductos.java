package modelo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import persistencia.AtraccionDAO;
import persistencia.ItinerarioDAO;
import persistencia.PromocionDAO;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;

public class OfertadorDeProductos {

	public void sugerirProductos(List<Usuario> usuarios, List<Producto> productos) throws NoHayCupoException {

		for (Usuario usuario : usuarios) {

			ItinerarioDAO itinerarioGeneral = DAOFactory.getItinerarioDAO();

			usuario.setItinerario(itinerarioGeneral.findAll(usuario.getId(), productos));
			if (usuario.itinerario.productos.isEmpty()) {
				System.out.println(
						"\n--------------------------------------------------------------------------------------------------\n");
				System.out.println("\t\t\t\t ¡Bienvenido " + usuario.getNombre() + "!");
			} else {
				System.out.println("\t\t\t\t ¡Bienvenido nuevamente " + usuario.getNombre() + "!");
				System.out.println("Usted compró anteriormente los siguientes productos: " + "\n "
						+ usuario.getProductosEnItinerario());
			}
			productos.sort(new ComparadorPorTipoAtraccion(usuario.getAtraccionPreferida()));

			for (Producto producto : productos) {
				List<Producto> itinerario = usuario.getProductosEnItinerario();

				boolean contiene = false;
				Iterator<Producto> iterador = itinerario.iterator();
				while (!contiene && iterador.hasNext()) {
					contiene = iterador.next().contiene(producto);
				}

				boolean hayCupo = producto.hayCupo();

				boolean puedeComprar = puedeComprar(usuario, producto);

				if (!contiene && hayCupo && puedeComprar) {
					System.out.println(
							"\n--------------------------------------------------------------------------------------------------\n");
					System.out.println("Usuario: " + usuario.getNombre() + "  Presupuesto: " + usuario.getPresupuesto()
							+ "  Tiempo Disponible: " + usuario.getTiempoDisponible() + "  Tipo de Atracción Favorito: "
							+ usuario.getAtraccionPreferida());
					System.out.println(
							"\n--------------------------------------------------------------------------------------------------\n");
					System.out.println(producto);
					if (this.decisionUsuario().toUpperCase().equals("SI")) {
						usuario.agregarProductosAlItinerario(producto);
						usuario.agregarProductoNuevo(producto);
						producto.disminuirCupo();
					}
				} 
			}
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.update(usuario);

			System.out.println(
					"\n--------------------------------------------------------------------------------------------------\n");
			System.out.println("\t\t\t\t RESUMEN DE ITINERARIO\n");
			System.out.println(usuario.itinerario);
			System.out.println("\t\t\t\t COSTO TOTAL: " + usuario.itinerario.costoTotal() + " monedas.");
			System.out.println("\t\t\t\t DURACION TOTAL: " + usuario.itinerario.duracionTotal() + " horas.");

			for (Producto producto : usuario.getNuevosProductos()) {
				actualizarProducto(producto);
				itinerarioGeneral.insert(usuario, producto);
			}
		}
		System.out.println("\n\n\n\t\t\t\t FIN PROGRAMA");
	}

	@SuppressWarnings("resource")
	private String decisionUsuario() {
		Scanner sc = new Scanner(System.in);
		String opcion = "";
		System.out.println("\n\n¿Desea añadir la sugerencia a su ITINERARIO?");
		System.out.print("\nIngrese SI o NO: ");
		opcion = sc.next();
		System.out.println();
		while (!opcion.toUpperCase().equals("SI") && !opcion.toUpperCase().equals("NO")) {
			System.out.println("Ingrese SI o NO: ");
			opcion = sc.next();
			System.out.println();
		}
		return opcion;
	}

	private boolean puedeComprar(Usuario u, Producto p) {
		if (u.getPresupuesto() < p.getCosto() || u.getTiempoDisponible() < p.getDuracion()) {
			return false;
		}
		return true;
	}

	public void actualizarProducto(Producto producto) {
		if (producto.esPromo()) {
			PromocionDAO promoDAO = DAOFactory.getPromocionDAO();
			promoDAO.update((Promocion) producto);
		} else {
			AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
			atraccionDao.update((Atraccion) producto);
		}
	}
}
