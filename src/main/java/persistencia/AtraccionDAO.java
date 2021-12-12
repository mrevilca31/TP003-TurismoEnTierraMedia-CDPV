package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Atraccion;
import persistenciaGeneral.ConexionProvider;
import persistenciaGeneral.GenericDAO;
import persistenciaGeneral.MissingDataException;

public class AtraccionDAO implements GenericDAO<Atraccion> {

	@Override
	public int update(Atraccion atraccion) {
		try {
			String sql = "UPDATE ATRACCION SET NOMBRE = '?', COSTO = ?, DURACION = ?, CUPO= ?, TIPO ='?' WHERE ID = ?";
			Connection conn = ConexionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getDuracion());
			statement.setInt(4, atraccion.getCupo());
			statement.setString(5, atraccion.getTipoAtraccion());
			statement.setInt(6, atraccion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Atraccion> findAll() {
		try {
			String sql = "SELECT * FROM ATRACCION WHERE borrado = 0";
			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> atraccion = new LinkedList<>();
			while (resultados.next()) {
				atraccion.add(toAtraccion(resultados));
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet results) throws SQLException {
		return new Atraccion(results.getInt(1), results.getString(2), results.getInt(3), results.getDouble(4),
				results.getInt(5), results.getString(6));
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS 'TOTAL ATRACCIONES' FROM Atraccion WHERE borrad = 0";
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

	@Override
	public int insert(Atraccion atraccion) {
		try {
			String sql = "INSERT INTO Atraccion (nombre, costo, duracion, cupo, tipo) VALUES ('?', ?, ?, ?)";
			Connection conn = ConexionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setInt(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getDuracion());
			statement.setInt(4, atraccion.getCupo());
			statement.setString(5, atraccion.getTipoAtraccion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Integer id) {
		try {
			String sql = "UPDATE FROM Atraccion SET borrado = 1 WHERE id = ?";
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
	public Atraccion find(Integer id) {
		try {
			String sql = "SELECT * FROM ATTRACTIONS WHERE id = ? AND borrado = 0";
			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Atraccion atraccion = null;
			if (resultados.next()) {
				atraccion = toAtraccion(resultados);
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}