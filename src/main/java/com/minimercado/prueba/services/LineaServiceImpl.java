package com.minimercado.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimercado.prueba.Linea;
import com.minimercado.prueba.LineaRepository;

@Service
public class LineaServiceImpl implements LineaService {

	@Autowired
	LineaRepository lineaRepository;

	@Override
	public Linea saveLinea(Linea linea) {
		return lineaRepository.save(linea);
	}

	@Override
	public List<Linea> fetchLineaList() {
		return (List<Linea>) lineaRepository.findAll();
	}

	@Override
	public void deleteLineaById(Long lineaId) {
		lineaRepository.deleteById(lineaId);
	}
	
}
