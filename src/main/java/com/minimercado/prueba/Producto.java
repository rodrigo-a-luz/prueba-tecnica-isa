package com.minimercado.prueba;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio_unitario")
	private float precioUnitario;

	public Producto() {
		this.codigo = 0;
		this.descripcion = "";
		this.precioUnitario = 0;
	}

	public Producto(int codigo, String descripcion, float precioUnitario) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
