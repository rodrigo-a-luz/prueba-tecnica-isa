package com.minimercado.prueba;

public class Linea {
	
	private Producto producto;
	private Number cantidad;
	private Number precioTotal;	// precio total (producto.precioUnitario * cantidad)

	public Linea(Producto producto, Number cantidad, Number precioTotal) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
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
