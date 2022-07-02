package com.minimercado.prueba;

public class ItemCarrito {
	
	private int codigoProducto;
	private int cantidad;
	
	public ItemCarrito() {
		this.codigoProducto = 0;
		this.cantidad = 0;
	}

	public ItemCarrito(int codigoProducto, int cantidad) {
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemCarrito [codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + "]";
	}

}
