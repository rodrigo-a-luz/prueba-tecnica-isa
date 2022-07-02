package com.minimercado.prueba;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Producto producto;

	@Column(name = "cantidad")
	private int cantidad;	// se inicializa en 10
	
	public Stock(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Stock() {
		this.producto = null;
		this.cantidad = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Stock [id=" + id + ", producto=" + producto.getCodigo() + ", desc=" + producto.getDescripcion() + ", cantidad=" + cantidad + "]";
	}

}
