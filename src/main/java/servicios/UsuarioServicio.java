package servicios;

import java.util.List;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;

public class UsuarioServicio {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario create(String nombre, Integer presupuesto, Double tiempoDisponible, String atraccionPreferida,
			String password, Boolean admin) {
		Usuario usuario = new Usuario(-1, nombre, presupuesto, tiempoDisponible, atraccionPreferida, password, false);
		usuario.setPassword(password);

		if (usuario.isValid()) {
			DAOFactory.getUsuarioDAO().insert(usuario);
		}

		return usuario;
	}

	public void delete(Integer id) {
		DAOFactory.getUsuarioDAO().delete(id);
	}

	public Usuario update(Integer id, String nombre, Integer presupuesto, Double tiempoDisponible,
			String atraccionPreferida, Boolean admin) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.find(id);

		usuario.setNombre(nombre);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempoDisponible(tiempoDisponible);
		usuario.setAtraccionPreferida(atraccionPreferida);
		usuario.setAdmin(admin);

		if (usuario.isValid()) {
			usuarioDAO.update(usuario);
		}
		return usuario;
	}

	public Usuario find(int id) {
		return DAOFactory.getUsuarioDAO().find(id);
	}
}
