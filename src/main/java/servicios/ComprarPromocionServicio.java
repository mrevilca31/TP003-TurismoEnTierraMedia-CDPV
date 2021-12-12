package servicios;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServlet;
import modelo.Promocion;
import modelo.Usuario;
import persistencia.PromocionDAO;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;

public class ComprarPromocionServicio extends HttpServlet {
	
	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();

	public Map<String, String> comprar(Integer usuarioId, Integer promocionId) {
		Map<String, String> errors = new HashMap<String, String>();

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
			usuario.agregarProductosAlItinerario(promocion);
			promocion.disminuirCupo(1);
			promocionDAO.update(promocion);
			usuarioDAO.update(usuario);
		}
		return errors;
	}
	
}
