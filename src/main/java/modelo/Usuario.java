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
	private String password;
	private Boolean admin;
	private Boolean borrado;

	protected Itinerario itinerario;
	protected List<Producto> nuevosProductos;

	public Usuario(int id, String nombre, int presupuesto, double tiempoDisponible, String atraccionPreferida,
			String password, Boolean admin, Boolean borrado) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionPreferida = atraccionPreferida;
		this.password = password;
		this.admin = admin;
		this.borrado = borrado;

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
		return "\nUSUARIO \n Nombre: " + nombre + " | Presupuesto: " + presupuesto + " | Tiempo Disponible: "
				+ tiempoDisponible + "hs. | Atraccion Preferida: " + atraccionPreferida + "Contraseña: ***** | Admin: "
				+ admin;
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
		return id == other.id && Objects.equals(nombre, other.nombre) && Objects.equals(presupuesto, other.presupuesto)
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

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

}
