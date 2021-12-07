package persistenciaGeneral;

import persistencia.AtraccionDAO;
import persistencia.ItinerarioDAO;
import persistencia.PromocionDAO;
import persistencia.UsuarioDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}

	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAO();
	}
	
	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAO();
	}
	
	public static ItinerarioDAO getItinerarioDAO() {
		return new ItinerarioDAO();
	}
}
