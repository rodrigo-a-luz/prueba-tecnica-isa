package com.minimercado.prueba.services;

import java.util.List;

import com.minimercado.prueba.Transaccion;

public interface TransaccionService {
	
    // Save operation
    Transaccion saveTransaccion(Transaccion transaccion);
  
    // Read operation
    List<Transaccion> fetchTransaccionList();
  
    // Delete operation
    void deleteTransaccionById(Long transaccionId);

}
