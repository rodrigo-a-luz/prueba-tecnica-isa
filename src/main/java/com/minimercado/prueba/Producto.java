package com.minimercado.prueba;

public class Producto {
	
	private Number codigo;
	private String descripcion;
	private Number precioUnitario;

	public Producto(Number codigo, String descripcion, Number precioUnitario) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public Number getCodigo() {
		return codigo;
	}

	public void setCodigo(Number codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Number getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(Number precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
