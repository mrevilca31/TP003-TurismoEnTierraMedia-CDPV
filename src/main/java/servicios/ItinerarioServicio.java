package servicios;

import java.util.List;

import modelo.Atraccion;
import modelo.Itinerario;
import modelo.Producto;
import modelo.Usuario;
import persistencia.ItinerarioDAO;
import persistenciaGeneral.DAOFactory;

public class ItinerarioServicio {

	public Itinerario find(int id, List<Producto> productos) {
		return (Itinerario) DAOFactory.getItinerarioDAO().findAll(id, productos);
	}
}
