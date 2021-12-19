package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import utilidades.Crypt;

public class Usuario {

	public int id;
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private String atraccionPreferida;
	private String password;
	private Boolean admin;
	private Boolean borrado;

	private HashMap<String, String> errors;

	public LinkedList<Producto> itinerario = new LinkedList<Producto>();

	public Usuario(int id, String nombre, int presupuesto, double tiempoDisponible, String atraccionPreferida,
			String password, Boolean admin) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionPreferida = atraccionPreferida;
		this.password = password;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public String getAtraccionPreferida() {
		return atraccionPreferida;
	}

	/*
	 * public List<Producto> getProductosEnItinerario() { return
	 * this.getItinerario().productos; }
	 */

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public void setAtraccionPreferida(String atraccionPreferida) {
		this.atraccionPreferida = atraccionPreferida;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}

	public Boolean isBorrado() {
		return borrado;
	}

	public void agregarProductosAlItinerario(Producto producto) {
		itinerario.add(producto);
		this.presupuesto -= producto.getCosto();
		this.tiempoDisponible -= producto.getDuracion();
	}

	@Override
	public String toString() {
		return "Usuario: " + nombre + " | Presupuesto: " + presupuesto + " | Tiempo Disponible: "
				+ tiempoDisponible + "hs. | Atraccion Preferida: " + atraccionPreferida
				+ " | Contraseña: ***** | Admin: " + admin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, presupuesto, tiempoDisponible, atraccionPreferida, getItinerario());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Usuario other = (Usuario) obj;
		return id == other.id && Objects.equals(nombre, other.nombre) && Objects.equals(presupuesto, other.presupuesto)
				&& Objects.equals(tiempoDisponible, other.tiempoDisponible)
				&& Objects.equals(getItinerario(), other.getItinerario())
				&& Objects.equals(atraccionPreferida, other.atraccionPreferida);
	}

	public boolean isNull() {
		return false;
	}

	public boolean puedePagar(Producto p) {
		return p.getCosto() <= this.getPresupuesto();
	}

	public boolean tieneTiempo(Producto p) {
		return p.getDuracion() <= this.getTiempoDisponible();
	}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<>();

		if (presupuesto < 0) {
			errors.put("presupuesto", "No debe ser negativo");
		}
		if (tiempoDisponible < 0) {
			errors.put("tiempoDisponible", "No debe ser negativo");
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public List<Producto> getItinerario() {
		return itinerario;
	}

	public void setItinerario(LinkedList<Producto> itinerario) {
		this.itinerario = itinerario;
	}

	public String totalItinerario() {

		double duracion = 0;
		double costo = 0;
		for (Producto producto : this.itinerario) {
			costo += producto.getCosto();
			duracion += producto.getDuracion();
		}
		return "RESUMEN DE COMPRA: COSTO TOTAL = " + costo + ", DURACION TOTAL = " + duracion;

	}

}
