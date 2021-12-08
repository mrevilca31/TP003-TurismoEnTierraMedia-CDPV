package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Atraccion;
import modelo.Promocion;
import modelo.PromocionAbsoluta;
import modelo.PromocionAxB;
import modelo.PromocionPorcentual;
import persistenciaGeneral.ConexionProvider;
import persistenciaGeneral.DAOFactory;
import persistenciaGeneral.GenericDAO;
import persistenciaGeneral.MissingDataException;

public class PromocionDAO implements GenericDAO<Promocion> {

	public List<Promocion> findAll() {
		try {
			String sql = "SELECT Promocion.id AS 'ID', Promocion.nombre AS 'Nombre Promocion', tipo_promo AS 'Tipo de Promocion', tipo_preferido AS 'Tipo de atracciones', Atraccion.nombre AS 'Atracciones incluidas', Promocion.costo_total AS 'Costo total promocion absoluta',(select nombre from Atraccion where id = PROMOCION.atraccion_bonificada) AS 'Atraccion bonificada promocion AxB', Promocion.descuento AS 'Tipo descuento promocion porcentual' \r\n"
					+ "FROM Atraccion_Promocion \r\n"
					+ "JOIN Promocion ON Promocion.id = Atraccion_Promocion.promocion_id\r\n"
					+ "JOIN Atraccion ON Atraccion.id = Atraccion_Promocion.atraccion_id";
			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> atracciones = DAOFactory.getAtraccionDAO().findAll();

			List<Promocion> promociones = new ArrayList<Promocion>();
			Map<Promocion, List<Atraccion>> mapP = new HashMap<Promocion, List<Atraccion>>();

			while (resultados.next()) {
				if (resultados.getString("Tipo de Promocion").equals("AXB")) {
					PromocionAxB promo = promoAxB(resultados);
					agregarAtraccion(mapP, resultados, atracciones, promo);
				}

				if (resultados.getString("Tipo de Promocion").equals("ABSOLUTA")) {
					PromocionAbsoluta promo = promoAbsoluta(resultados);
					agregarAtraccion(mapP, resultados, atracciones, promo);
				}

				if (resultados.getString("Tipo de Promocion").equals("PORCENTUAL")) {
					PromocionPorcentual promo = promoPorcentual(resultados);
					agregarAtraccion(mapP, resultados, atracciones, promo);
				}
			}

			for (Map.Entry<Promocion, List<Atraccion>> entry : mapP.entrySet()) {
				entry.getKey().setAtraccionesEnPromocion(entry.getValue());
				promociones.add(entry.getKey());

			}

			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private PromocionPorcentual promoPorcentual(ResultSet resultados) throws SQLException {
		return new PromocionPorcentual(resultados.getInt("ID"), resultados.getString("Tipo de atracciones"),
				resultados.getString("Nombre Promocion"), resultados.getDouble("Tipo descuento promocion porcentual"));
	}

	private PromocionAbsoluta promoAbsoluta(ResultSet resultados) throws SQLException {
		return new PromocionAbsoluta(resultados.getInt("ID"), resultados.getString("Tipo de atracciones"),
				resultados.getString("Nombre Promocion"), resultados.getInt("Costo total promocion absoluta"));
	}

	private PromocionAxB promoAxB(ResultSet resultados) throws SQLException {
		return new PromocionAxB(resultados.getInt("ID"), resultados.getString("Tipo de atracciones"),
				resultados.getString("Nombre Promocion"));
	}

	private Atraccion buscarAtraccion(List<Atraccion> atracciones, String nombre) {
		Atraccion a = null;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return a;
	}

	private void agregarAtraccion(Map<Promocion, List<Atraccion>> mapP, ResultSet resultados,
			List<Atraccion> atracciones, Promocion promo) throws SQLException {
		if (mapP.containsKey(promo)) {
			List<Atraccion> atr = mapP.get(promo);
			Atraccion a = buscarAtraccion(atracciones, resultados.getString("Atracciones incluidas"));
			atr.add(a);
			mapP.put(promo, atr);

		} else {
			List<Atraccion> atr = new ArrayList<Atraccion>();
			Atraccion a = buscarAtraccion(atracciones, resultados.getString("Atracciones incluidas"));
			atr.add(a);
			mapP.put(promo, atr);
		}
	}

	public int update(Promocion promocion) {

		List<Atraccion> atraccionesIncluidas = promocion.getAtraccionesEnPromocion();
		int rows = 0;
		AtraccionDAO atraccionDao = new AtraccionDAO();

		for (Atraccion atraccion : atraccionesIncluidas) {
			rows = atraccionDao.update(atraccion);
		}
		return rows;
	}

	public int insert(Promocion promocion) {
		return 0;
		/*
		 * try { String promoAbsoluta =
		 * "INSERT INTO Promocion (nombre, tipo_promo, tipo_preferido, costo_total)" +
		 * "VALUES ('?', '?', '?', ?);"; String promoPorcentual =
		 * "INSERT INTO Promocion (nombre, tipo_promo, tipo_preferido, descuento)" +
		 * "VALUES ('?', '?', '?', ?);"; String promoAxB =
		 * "INSERT INTO Promocion (nombre, tipo_promo, tipo_preferido, atraccion_bonificada)"
		 * + "VALUES ('?', '?', '?', '?');"; String atracciones =
		 * "INSERT INTO Atraccion_Promocion (promocion_id, atraccion_id) VALUES (?, ?);"
		 * ; Connection conn = ConexionProvider.getConnection();
		 * 
		 * PreparedStatement statement1 = conn.prepareStatement(promoAbsoluta);
		 * PreparedStatement statement2 = conn.prepareStatement(promoPorcentual);
		 * PreparedStatement statement3 = conn.prepareStatement(promoAxB);
		 * PreparedStatement statement4 = conn.prepareStatement(atracciones);
		 * 
		 * if (promocion.getTipoPromo().equals("ABSOLUTA")) { statement1.setString(1,
		 * promocion.getNombre()); statement1.setString(2, promocion.getTipoPromo());
		 * statement1.setString(3, promocion.getTipoPreferido()); statement1.setInt(4,
		 * promocion.getCosto()); // esta mal statement4.setInt(1, promocion.getId());
		 * statement4.setInt(2, promocion.getId());// no se si esta bien, va el de la
		 * atraccion
		 * 
		 * int rows = statement1.executeUpdate(); } else if
		 * (promocion.getTipoPromo().equals("PORCENTUAL")) { statement2.setString(1,
		 * promocion.getNombre()); statement2.setString(2, promocion.getTipoPromo());
		 * statement2.setString(3, promocion.getTipoPreferido()); statement2.setInt(4,
		 * promocion.getDescuento()); // esta mal statement4.setInt(1,
		 * promocion.getId()); statement4.setInt(2, promocion.getId()); // no se si esta
		 * bien
		 * 
		 * int rows = statement2.executeUpdate(); } else if
		 * (promocion.getTipoPromo().equals("AXB")) { statement3.setString(1,
		 * promocion.getNombre()); statement3.setString(2, promocion.getTipoPromo());
		 * statement3.setString(3, promocion.getTipoPreferido());
		 * statement3.setString(4, promocion.getAtraccionBonificada()); // esta mal
		 * statement4.setInt(1, promocion.getId()); statement4.setInt(2,
		 * promocion.getAtraccionesEnPromocion().getId()); // ----
		 * 
		 * int rows = statement3.executeUpdate();
		 * 
		 * return rows; }
		 * 
		 * } catch (Exception e) { throw new MissingDataException(e); }
		 */
	}

	@Override
	public int delete(Integer id) {
		try {
			String sql = "UPDATE FROM Promocion SET BORRADO = ? WHERE id = ?";
			Connection conn = ConexionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, 1);
			statement.setInt(2, id);
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS 'TOTAL PROMOCIONES' FROM Promocion";
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
	public Promocion find(Integer id) {
		try {
			String sql = "SELECT Promocion.id AS 'ID', Promocion.nombre AS 'Nombre Promocion', tipo_promo AS 'Tipo de Promocion', tipo_preferido AS 'Tipo de atracciones', Atraccion.nombre AS 'Atracciones incluidas', Promocion.costo_total AS 'Costo total promocion absoluta',(select nombre from Atraccion where id = PROMOCION.atraccion_bonificada) AS 'Atraccion bonificada promocion AxB', Promocion.descuento AS 'Tipo descuento promocion porcentual' \r\n"
					+ "FROM Atraccion_Promocion \r\n"
					+ "JOIN Promocion ON Promocion.id = Atraccion_Promocion.promocion_id\r\n"
					+ "JOIN Atraccion ON Atraccion.id = Atraccion_Promocion.atraccion_id" + "WHERE id = ?";
			Connection conn = ConexionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;
			if (resultados.next()) {
				promocion = toPromocion(resultados);
			}

			return promocion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultados) throws SQLException {
		/*if (resultados.getString("Tipo de Promocion").equals("AXB")) {
			return new Promocion(resultados.getInt(1), resultados.getString(2), resultados.getString(3));
		}

		if (resultados.getString("Tipo de Promocion").equals("ABSOLUTA")) {

		}

		if (resultados.getString("Tipo de Promocion").equals("PORCENTUAL")) {

		}*/
		return null;
	}

}