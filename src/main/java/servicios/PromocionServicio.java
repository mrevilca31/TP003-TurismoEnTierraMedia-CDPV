package servicios;

import java.util.List;

import modelo.Promocion;
import persistenciaGeneral.DAOFactory;

public class PromocionServicio {

	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	/*public Promocion create(String nombre, int costo, Double duracion, int cupo, String tipo) {

		//HAY QUE MODIFICAR LOS PARAMETROS
		Promocion promocion = new Promocion(-1, nombre, costo, duracion, cupo, tipo);

		if (promocion.esValida()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}
		return promocion;
	}*/

	public Promocion findAtraccionById(int id) {
		return DAOFactory.getPromocionDAO().find(id);
	}

	/*public Promocion update(int id, String nombre, Integer costo, Double duracion, int cupo, String tipo) {

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Promocion promocion = promocionDAO.find(id);

		//HAY QUE MODIFICAR LOS PARAMETROS
		promocion.setNombre(nombre);
		promocion.setCosto(costo);
		promocion.setDuracion(duracion);
		promocion.setCupo(cupo);

		if (promocion.esValida()) {
			promocionDAO.update(promocion);
		}
		return promocion;
	}*/

	public void delete(Integer id) {
		DAOFactory.getPromocionDAO().delete(id);
	}
}
