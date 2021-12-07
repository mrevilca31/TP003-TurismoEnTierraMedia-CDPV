package modelo;

import java.util.Objects;


public class Atraccion extends Producto {

	private int cupo;
	
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
	protected boolean hayCupo() {
		return this.getCupo() > 0;
	}
	

	protected void disminuirCupo() throws NoHayCupoException {
		if (!hayCupo()) {
			throw new NoHayCupoException("Se agoto el CUPO en la atraccion: " + this.getNombre());
		}
		this.cupo--;
	}


	@Override
	public String toString() {
		return "\nATRACCION \n Nombre: " + super.getNombre() + " | Costo: " + super.getCosto() +" monedas | Duración: " + super.getDuracion() + " hs. | Tipo: " + super.getTipoAtraccion(); 
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupo == other.cupo && Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& id == other.id && Objects.equals(nombre, other.nombre) && costo == other.costo;
	}
}
