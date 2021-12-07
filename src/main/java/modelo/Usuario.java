package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import utilidades.Crypt;

public class Usuario {

	public int id;
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private String atraccionPreferida;
	protected Itinerario itinerario;
	protected List<Producto> nuevosProductos;

	public Usuario(int id, String nombre, int presupuesto, double tiempoDisponible, String atraccionPreferida/*, String password*/) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionPreferida = atraccionPreferida;
		//this.password = password;
		nuevosProductos = new ArrayList<Producto>();
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

	public List<Producto> getProductosEnItinerario() {
		return this.itinerario.productos;
	}
	
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

	public void setItinerario(List<Producto> productos) {
		this.itinerario = new Itinerario(productos);
	}

	public void agregarProductosAlItinerario(Producto producto) {
		itinerario.agregarProductos(producto);
		this.presupuesto -= producto.getCosto();
		this.tiempoDisponible -= producto.getDuracion();
	}
	
	public void agregarProductoNuevo(Producto producto) {
		this.nuevosProductos.add(producto);
	}
	
	public List<Producto> getNuevosProductos() {
		return this.nuevosProductos;
	}

	@Override
	public String toString() {
		return "\nUSUARIO \n Nombre: " + nombre + " | Presupuesto: " + presupuesto + " | Tiempo Disponible: " + tiempoDisponible
				+ "hs. | Atraccion Preferida: " + atraccionPreferida /* + "Contraseña: *****"*/;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, presupuesto, tiempoDisponible, atraccionPreferida, itinerario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id == other.id
				&& Objects.equals(nombre, other.nombre)
				&& Objects.equals(presupuesto, other.presupuesto) 
				&& Objects.equals(tiempoDisponible, other.tiempoDisponible)
				&& Objects.equals(itinerario, other.itinerario) 
				&& Objects.equals(atraccionPreferida, other.atraccionPreferida);
	}	
	
	public boolean isNull() {
		return false;
	}
	
	private boolean puedeComprar(Producto p) {
		if (this.getPresupuesto() < p.getCosto() || this.getTiempoDisponible() < p.getDuracion()) {
			return false;
		}
		return true;
	}
	
	/*private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}
	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}
	*/
}
