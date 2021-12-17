package servicios;

import java.util.ArrayList;
import java.util.List;

import modelo.Atraccion;
import modelo.Producto;
import modelo.Promocion;
import modelo.Usuario;
import persistenciaGeneral.DAOFactory;
import modelo.ComparadorPorTipoAtraccion;

public class OrdenadorServicio {

	public List<Producto> crearListaOrdenada(String nombre) {
		Usuario usuario = DAOFactory.getUsuarioDAO().findByNombre(nombre);
		List<Atraccion> atraccionDAO = DAOFactory.getAtraccionDAO().findAll();
		// List<Promocion> promocionDAO = DAOFactory.getPromocionDAO().findAll();

		List<Producto> ofertas = new ArrayList<Producto>();
		for (Atraccion atraccion : atraccionDAO) {
			ofertas.add(atraccion);
		}
		/*
		 * for (Promocion promo : promocionDAO) { ofertas.add(promo); }
		 */
		ofertas.sort(new ComparadorPorTipoAtraccion(usuario.getAtraccionPreferida()));

		return ofertas;
	}
}
