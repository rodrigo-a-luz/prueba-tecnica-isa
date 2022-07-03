package com.minimercado.prueba.services;

import java.util.List;

import com.minimercado.prueba.Linea;

public interface LineaService {
	// Save operation
	Linea saveLinea(Linea linea);

	// Read operation
	List<Linea> fetchLineaList();

	// Delete operation
	void deleteLineaById(Long lineaId);
}
