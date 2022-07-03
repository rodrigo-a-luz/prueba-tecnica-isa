package com.minimercado.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimercado.prueba.Producto;
import com.minimercado.prueba.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto saveProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> fetchProductoList() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public void deleteProductoById(Long productoId) {
		productoRepository.deleteById(productoId);
	}
}
