package com.minimercado.prueba;

import java.util.Date;
import java.util.Map;

public class Transaccion {
	
	private Date fecha;					// fecha de la venta
	private Number numero;				// unico en el sistema (identifica la transaccion)
	private Map<Number, Linea> lineas;	// mapa de codigo de Producto a Linea 
	private Producto producto;

	public Transaccion(Date fecha, Number numero, Map<Number, Linea> lineas, Producto producto) {
		this.fecha = fecha;
		this.numero = numero;
		this.lineas = lineas;
		this.producto = producto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Number getNumero() {
		return numero;
	}

	public void setNumero(Number numero) {
		this.numero = numero;
	}

	public Map<Number, Linea> getLineas() {
		return lineas;
	}

	public void setLineas(Map<Number, Linea> lineas) {
		this.lineas = lineas;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
