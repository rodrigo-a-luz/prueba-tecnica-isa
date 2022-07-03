package com.minimercado.prueba.services;

import java.util.List;

import com.minimercado.prueba.Producto;

public interface ProductoService {
	// Save operation
	Producto saveProducto(Producto producto);

	// Read operation
	List<Producto> fetchProductoList();

	// Delete operation
	void deleteProductoById(Long productoId);
}
