package servicios;

import java.util.List;

import modelo.Usuario;
import persistenciaGeneral.DAOFactory;

public class UsuarioServicio {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario create(String nombre, Integer presupuesto, Double tiempoDisponible, String atraccionPreferida, String password) {
		Usuario usuario = new Usuario(-1, nombre, presupuesto, tiempoDisponible, atraccionPreferida, password);
		usuario.setPassword(password);

		if (usuario.isValid()) {
			DAOFactory.getUsuarioDAO().insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}
}
