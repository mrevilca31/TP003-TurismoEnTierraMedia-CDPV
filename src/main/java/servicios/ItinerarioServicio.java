package servicios;

import java.util.List;

import modelo.Atraccion;
import modelo.Itinerario;
import modelo.Producto;
import modelo.Usuario;
import persistencia.ItinerarioDAO;
import persistenciaGeneral.DAOFactory;

public class ItinerarioServicio {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Itinerario create(Usuario usuario, Producto producto) {

		Itinerario itinerario = new Itinerario();

		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		itinerarioDAO.insert(usuario, producto);
		return itinerario;
	}

	public Itinerario find(int id, List<Producto> productos) {
		return (Itinerario) DAOFactory.getItinerarioDAO().findAll(id, productos);
	}
}
