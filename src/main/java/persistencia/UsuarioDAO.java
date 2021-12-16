package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Usuario;
import modeloNullUsuario.NullUser;
import persistenciaGeneral.ConexionProvider;
import persistenciaGeneral.GenericDAO;
import persistenciaGeneral.MissingDataException;

public class UsuarioDAO implements GenericDAO<Usuario> {

	@Override
	public int insert(Usuario usuario) {
		try {
			String sql = "INSERT INTO Usuario (nombre, presupuesto, tiempo_disponible, atraccion_preferida, password, admin) VALUES (?, ?, ?, ?, ?, ?)\r\n"
					+ "";
			Connection conn = ConexionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setInt(2, usuario.getPresupuesto());
			statement.setDouble(3, usuario.getTiempoDisponible());
			statement.setString(4, usuario.getAtraccionPreferida());
			statement.setString(5, usuario.getPassword());
			statement.setBoolean(6, usuario.getAdmin());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Usuario usuario) {
		try {
			String sql = "UPDATE USUARIO SET NOMBRE = ?,PRESUPUESTO = ?, TIEMPO_DISPONIBLE = ?, PASSWORD = ? WHERE ID = ?";
			Connection conn = ConexionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setInt(2, usuario.getPresupuesto());
			statement.setDouble(3, usuario.getTiempoDisponible());
			statement.setString(4, usuario.getPassword());
			statement.setInt(5, usuario.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Integer id) {
		try {
			String sql = "Update Usuario SET borrado = 1 WHERE id = ?";
			Connection conn = ConexionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS 'TOTAL USUARIOS' FROM Usuario WHERE BORRADO =0";
			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario findByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM Usuario WHERE nombre = ? AND BORRADO =0";
			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = NullUser.build();

			if (resultados.next()) {
				usuario = toUsuario(resultados);
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM Usuario WHERE BORRADO =0";
			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario find(Integer id) {
		try {
			String sql = "SELECT * FROM Usuario WHERE id = ? AND BORRADO =0";
			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet results) throws SQLException {
		return new Usuario(results.getInt(1), results.getString(2), results.getInt(3), results.getDouble(4),
				results.getString(5), results.getString(6), results.getBoolean(7));
	}

}