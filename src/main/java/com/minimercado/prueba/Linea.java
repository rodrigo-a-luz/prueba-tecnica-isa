package com.minimercado.prueba;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Linea {
	
	@Id
	private Number id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Producto producto;
	private Number cantidad;
	private Number precioTotal;	// precio total (producto.precioUnitario * cantidad)

	public Linea(Producto producto, Number cantidad, Number precioTotal) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.id = producto.getCodigo();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Number getCantidad() {
		return cantidad;
	}

	public void setCantidad(Number cantidad) {
		this.cantidad = cantidad;
	}

	public Number getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Number precioTotal) {
		this.precioTotal = precioTotal;
	}

}
