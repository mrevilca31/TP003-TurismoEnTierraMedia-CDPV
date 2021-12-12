package servicios;

import jakarta.servlet.http.HttpServlet;
import modelo.Usuario;
import modeloNullUsuario.NullUser;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;

public class LoginServicio extends HttpServlet {

	public Usuario login(String nombre, String password) {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDao.findByNombre(nombre);
    	
    	if (usuario.isNull() || !usuario.checkPassword(password)) {
    		usuario = NullUser.build();
    	}
    	return usuario;
	}
}
