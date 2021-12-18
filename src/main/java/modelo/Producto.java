package modelo;

import java.util.ArrayList;
import java.util.List;

import persistencia.AtraccionDAO;
import persistencia.PromocionDAO;
import persistenciaGeneral.DAOFactory;

public abstract class Producto {

	protected List<Atraccion> atracciones = new ArrayList<>();
	protected List<Promocion> promociones = new ArrayList<>();
	public int id;
	protected String tipoAtraccion;
	protected String nombre;
	protected int costo;
	protected double duracion;
	protected Boolean borrado;

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCosto() {
		return costo;
	}

	public double getDuracion() {
		return duracion;
	}

	public String getTipoAtraccion() {
		return tipoAtraccion;
	}

	public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTipoAtraccion(String tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public boolean esPromo() {
		return false;
	}

	public Boolean isBorrado() {
		return borrado;
	}

	public void agregarAtraccion(Atraccion a) {
		this.atracciones.add(a);
	}

	public void agregarPromocion(Promocion p) {
		this.promociones.add(p);
	}

	protected abstract boolean contiene(Producto p);

	protected abstract boolean hayCupo();

	protected abstract void disminuirCupo();

	public void actualizarProducto(Producto producto) {
		if (producto.esPromo()) {
			PromocionDAO promoDAO = DAOFactory.getPromocionDAO();
			promoDAO.update((Promocion) producto);
		} else {
			AtraccionDAO atraccionDao = DAOFactory.getAtraccionDAO();
			atraccionDao.update((Atraccion) producto);
		}
	}
}