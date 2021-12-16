package servicios;

import java.util.HashMap;
import java.util.Map;

import modelo.Atraccion;
import modelo.Usuario;
import persistencia.AtraccionDAO;
import persistencia.ItinerarioDAO;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;

public class ComprarAtraccionServicio {

	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();

	public Map<String, String> comprar(Integer usuarioId, Integer atraccionId) {
		Map<String, String> errors = new HashMap<>();

		Usuario usuario = usuarioDAO.find(usuarioId);
		Atraccion atraccion = atraccionDAO.find(atraccionId);

		if (!atraccion.hayCupo()) {
			errors.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.puedePagar(atraccion)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!usuario.tieneTiempo(atraccion)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			atraccion.disminuirCupo(1);
			atraccionDAO.update(atraccion);
			usuarioDAO.update(usuario);
			itinerarioDAO.insert(usuario, atraccion);
		}
		return errors;
	}
}
