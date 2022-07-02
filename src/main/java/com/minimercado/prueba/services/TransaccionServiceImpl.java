package com.minimercado.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimercado.prueba.Transaccion;
import com.minimercado.prueba.TransaccionRepository;

@Service
public class TransaccionServiceImpl implements TransaccionService {

	@Autowired
	private TransaccionRepository transaccionRepository;

	@Override
	public Transaccion saveTransaccion(Transaccion transaccion) {
		return transaccionRepository.save(transaccion);
	}

	@Override
	public List<Transaccion> fetchTransaccionList() {
		return (List<Transaccion>) transaccionRepository.findAll();
	}

	@Override
	public void deleteTransaccionById(Long transaccionId) {
		transaccionRepository.deleteById(transaccionId);
	}
	
}
