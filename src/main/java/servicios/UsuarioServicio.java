package servicios;

import java.util.List;

import modelo.Atraccion;
import modelo.Usuario;
import persistencia.AtraccionDAO;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;

public class UsuarioServicio {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public static Usuario findUser(String nombre) {
		return DAOFactory.getUsuarioDAO().findByNombre(nombre);
	}

	public Usuario create(String nombre, Integer presupuesto, Double tiempoDisponible, String atraccionPreferida,
			String password, Boolean admin) {
		Usuario usuario = new Usuario(-1, nombre, presupuesto, tiempoDisponible, atraccionPreferida, password, admin);
		usuario.setPassword(password);

		if (usuario.isValid()) {
			DAOFactory.getUsuarioDAO().insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}

	public void delete(Integer id) {
		DAOFactory.getUsuarioDAO().delete(id);
	}

	public Usuario update(Integer id, String nombre, Integer presupuesto, Double tiempoDisponible,
			String atraccionPreferida, String password, Boolean admin) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.find(id);

		usuario.setNombre(nombre);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempoDisponible(tiempoDisponible);
		usuario.setAtraccionPreferida(atraccionPreferida);
		usuario.setPassword(password);
		usuario.setAdmin(admin);

		if (!(usuario == null)) {
			usuarioDAO.update(usuario);
		}
		return usuario;
	}
}
