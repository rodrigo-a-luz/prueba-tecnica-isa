package com.minimercado.prueba.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minimercado.prueba.Stock;
import com.minimercado.prueba.Transaccion;
import com.minimercado.prueba.TransaccionRepository;

@Service
public class TransaccionServiceImpl implements TransaccionService {

	@Autowired
	private TransaccionRepository transaccionRepository;

	@Autowired
	private StockService stockService;

	// registra la transaccion y actualiza el stock
	@Override
	@Transactional
	public Transaccion saveTransaccion(Transaccion transaccion) {
		transaccion.getLineas().forEach(linea -> {
			// stockService.updateStockByProductId(linea.getProducto().getCodigo(), linea.getCantidad());
			List<Stock> stocks = stockService.fetchStockList();
			Map<String, Stock> mapaStocks = new HashMap<String, Stock>();
			stocks.forEach(stock -> {
				mapaStocks.put(String.valueOf(stock.getProducto().getCodigo()), stock);
			});

			Stock stock = mapaStocks.get(String.valueOf(linea.getProducto().getCodigo()));
			if (stock.getCantidad() >= linea.getCantidad()) {
				stock.setCantidad(stock.getCantidad() - linea.getCantidad());
			};
		});

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
