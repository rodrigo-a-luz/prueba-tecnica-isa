package com.minimercado.prueba;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "linea")
public class Linea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Producto producto;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "precio_total")
	private float precioTotal;	// precio total (producto.precioUnitario * cantidad)

	public Linea() {
		this.producto = null;
		this.cantidad = 0;
		this.precioTotal = 0;
		this.id = 0;
	}

	public Linea(Producto producto, int cantidad, float precioTotal) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.id = producto.getCodigo();
	}

	public Linea(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = producto.getPrecioUnitario() * cantidad;
		this.id = producto.getCodigo();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

}
