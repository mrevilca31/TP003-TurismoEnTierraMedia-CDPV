package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;
import modelo.Usuario;
import persistenciaGeneral.ConexionProvider;
import persistenciaGeneral.MissingDataException;

public class ItinerarioDAO {

	public void insert(Usuario usuario, Producto producto) {

		try {
			if (producto.esPromo()) {
				String sql = "INSERT INTO ITINERARIO (USUARIO_ID, PROMOCION_ID) VALUES (?, ?)";
				Connection conn = ConexionProvider.getConnection();

				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, usuario.getId());
				statement.setInt(2, producto.getId());
				statement.executeUpdate();
			} else {
				String sql = "INSERT INTO ITINERARIO (USUARIO_ID, ATRACCION_ID)" + "VALUES(?, ?)";
				Connection conn = ConexionProvider.getConnection();

				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, usuario.getId());
				statement.setInt(2, producto.getId());
				statement.executeUpdate();
			}

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Producto> findAll(Usuario usuario, List<Producto> productos) {
		try {
			String consulta = "select promocion_id, atraccion_id from Itinerario WHERE usuario_id = ?";
			String promo = "select promocion.id, promocion.nombre from Promocion\r\n" + "INNER JOIN Itinerario on \r\n"
					+ "Promocion.id = ?;";
			String atracc = "select Atraccion.id, Atraccion.nombre from Atraccion\r\n" + "INNER JOIN Itinerario on \r\n"
					+ "Atraccion.id = ?;";

			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(consulta);
			PreparedStatement statementPromo = conn.prepareStatement(promo);
			PreparedStatement statementAtrac = conn.prepareStatement(atracc);

			statement.setString(1, usuario.getNombre());
			ResultSet resultados = statement.executeQuery();

			List<Producto> itinerario = new ArrayList<>();
			while (resultados.next()) {

				if (!(resultados.getString(1) == null)) {

					statementPromo.setInt(1, resultados.getInt(1));
					ResultSet pr = statementPromo.executeQuery();

					Producto promocion = buscarProducto(pr, productos);
					itinerario.add(promocion);
				}
				if (!(resultados.getString(2) == null)) {

					statementAtrac.setInt(1, resultados.getInt(2));
					ResultSet at = statementAtrac.executeQuery();
					Producto atraccion = buscarProducto(at, productos);
					itinerario.add(atraccion);
				}
			}

			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Producto buscarProducto(ResultSet pr, List<Producto> productos) throws SQLException {

		for (Producto producto : productos) {
			if (producto.getNombre().equals(pr.getString(2))) {
				return producto;
			}
		}
		return null;
	}
}
