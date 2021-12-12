package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Atraccion extends Producto {

	private int cupo;
	private Map<String, String> errors;

	public Atraccion(int id, String nombre, int costo, double duracion, int cupo, String tipo) {
		super.id = id;
		super.nombre = nombre;
		super.costo = costo;
		super.duracion = duracion;
		super.tipoAtraccion = tipo;
		this.cupo = cupo;
	}

	public int getCupo() {
		return cupo;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public void setTipo(String tipo) {
		this.tipoAtraccion = tipo;
	}

	@Override
	public boolean hayCupo() {
		return this.getCupo() > 0;
	}

	public boolean esValida() {
		validar();
		return errors.isEmpty();
	}

	public void validar() {
		errors = new HashMap<>();

		if (costo <= 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (duracion <= 0) {
			errors.put("duracion", "Debe ser positivo");
		}
		if (cupo <= 0) {
			errors.put("cupo", "Debe ser positivo");
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	@Override
	public void disminuirCupo(int i) {
		this.cupo--;
	}

	@Override
	public String toString() {
		return "\nATRACCION \n Nombre: " + super.getNombre() + " | Costo: " + super.getCosto() + " monedas | Duración: "
				+ super.getDuracion() + " hs. | Tipo: " + super.getTipoAtraccion();
	}

	@Override
	public boolean contiene(Producto p) {
		if (p.esPromo()) {
			return p.contiene(this);
		}

		return this.equals(p);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, costo, duracion, cupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Atraccion other = (Atraccion) obj;
		return cupo == other.cupo && Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& id == other.id && Objects.equals(nombre, other.nombre) && costo == other.costo;
	}
}
