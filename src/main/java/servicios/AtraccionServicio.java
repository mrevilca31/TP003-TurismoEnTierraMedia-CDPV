package servicios;

import java.util.List;

import modelo.Atraccion;
import persistencia.AtraccionDAO;
import persistenciaGeneral.DAOFactory;

public class AtraccionServicio {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String nombre, int costo, Double duracion, int cupo, String tipo) {

		Atraccion atraccion = new Atraccion(-1, nombre, costo, duracion, cupo, tipo);

		if (atraccion.esValida()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
		}
		return atraccion;
	}

	public Atraccion findAtraccionById(int id) {
		return DAOFactory.getAtraccionDAO().find(id);
	}

	public Atraccion update(int id, String nombre, Integer costo, Double duracion, int cupo) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.find(id);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setDuracion(duracion);
		atraccion.setCupo(cupo);

		if (atraccion.esValida()) {
			atraccionDAO.update(atraccion);
		}
		return atraccion;
	}

	public void delete(Integer id) {
		DAOFactory.getAtraccionDAO().delete(id);
	}
}
