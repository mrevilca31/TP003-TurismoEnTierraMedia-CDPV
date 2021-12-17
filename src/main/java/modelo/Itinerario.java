package modelo;

import java.util.List;

public class Itinerario {
	protected List<Producto> productos;

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Itinerario(List<Producto> productos) {

		this.productos = productos;
	}

	public Itinerario() {}

	public List<Producto> getProductos() {
		return productos;
	}

	protected void agregarProductos(Producto p) {
		this.productos.add(p);
	}

	protected double duracionTotal() {
		double horas = 0.0;

		for (Producto producto : productos) {
			horas += producto.getDuracion();
		}

		return horas;
	}

	protected int costoTotal() {
		int monedas = 0;

		for (Producto producto : productos) {
			monedas += producto.getCosto();
		}

		return monedas;
	}

	@Override
	public String toString() {
		String cadena = "";

		for (Producto producto : productos) {
			cadena += producto + "\n";
		}

		return cadena;
	}
}