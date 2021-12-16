package servicios;

import java.util.List;

import modelo.Atraccion;
import modelo.Itinerario;
import modelo.Producto;
import modelo.Usuario;
import persistencia.ItinerarioDAO;
import persistenciaGeneral.DAOFactory;

public class ItinerarioServicio {

	public List<Producto> find(int id, List<Producto> productos) {
		return DAOFactory.getItinerarioDAO().findAll(id, productos);
	}
}
