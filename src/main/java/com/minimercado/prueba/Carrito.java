package com.minimercado.prueba;

import java.util.List;

public class Carrito {
	
	private List<ItemCarrito> listaCompra;

	public Carrito(List<ItemCarrito> listaCompra) {
		this.listaCompra = listaCompra;
	}

	public Carrito() {
		this.listaCompra = null;
	}

	public List<ItemCarrito> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<ItemCarrito> listaCompra) {
		this.listaCompra = listaCompra;
	}

}
