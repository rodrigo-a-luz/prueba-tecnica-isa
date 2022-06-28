package com.minimercado.prueba;

public class Stock {
	
	private Producto producto;
	private Number cantidad;	// se inicializa en 10
	
	public Stock(Producto producto, Number cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
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

}
