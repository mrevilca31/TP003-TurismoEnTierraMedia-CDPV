package servicios;

import java.util.List;

import modelo.Atraccion;
import modelo.Itinerario;
import modelo.Producto;
import modelo.Usuario;
import persistencia.ItinerarioDAO;
import persistenciaGeneral.DAOFactory;

public class ItinerarioServicio {

	public List<Producto> find(Usuario usuario) {
		List<Producto> productos = DAOFactory.getItinerarioDAO().findByNombre(usuario);
		/*if(productos != null) {
			for(Producto comprasRealizadas:productos ) {
				usuario.itinerario.add(comprasRealizadas);	
			}	
		}		*/
		return usuario.itinerario;
	} 
}
