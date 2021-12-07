package persistenciaGeneral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionProvider {

	private static String url = "jdbc:sqlite:BaseDeDatosTierraMedia.db";
	private static Connection conexion;
	
	public static Connection getConnection() throws SQLException {
		if (conexion == null) {
			conexion = DriverManager.getConnection(url);			
		}
		return conexion;
	}

}