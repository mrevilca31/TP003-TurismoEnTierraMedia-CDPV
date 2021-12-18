package servicios;

import java.util.HashMap;
import java.util.Map;

import modelo.Promocion;
import modelo.Usuario;
import persistencia.ItinerarioDAO;
import persistencia.PromocionDAO;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;

public class ComprarPromocionServicio {

	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();


	public Map<String, String> comprar(Integer usuarioId, Integer promocionId) {
		Map<String, String> errors = new HashMap<>();

		Usuario usuario = usuarioDAO.find(usuarioId);
		Promocion promocion = promocionDAO.find(promocionId);

		if (!promocion.hayCupo()) {
			errors.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.puedePagar(promocion)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!usuario.tieneTiempo(promocion)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			promocion.disminuirCupo();
			promocionDAO.update(promocion);
			usuarioDAO.update(usuario);
			itinerarioDAO.insert(usuario, promocion);

		}
		return errors;
	}

}
