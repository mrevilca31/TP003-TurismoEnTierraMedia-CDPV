package servicios;

import java.util.List;

import jakarta.servlet.http.HttpServlet;
import modelo.Atraccion;
import persistencia.AtraccionDAO;
import persistenciaGeneral.DAOFactory;

public class AtraccionServicio extends HttpServlet {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String nombre, int costo, Double duracion, int cupo, String tipo) {

		Atraccion atraccion = new Atraccion(-1,  nombre, costo, duracion, cupo, tipo);

		if (atraccion.esValida()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			  atraccionDAO.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public Atraccion update(int id, String nombre, Integer costo, Double duracion, int cupo, String tipo) {

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

	public void delete(Integer id) { // me da error, me falta comparar con la clase de Fabian//
		Atraccion atraccion = new Atraccion(id, null, null, null, null, null);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.delete(atraccion);
	}

	public Atraccion find(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.find(id);
	}

}
