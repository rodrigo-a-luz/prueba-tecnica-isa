package com.minimercado.prueba.services;

import java.util.List;

import com.minimercado.prueba.Stock;

public interface StockService {

	// Save operation
	Stock saveStock(Stock stock);

	// Read operation
	List<Stock> fetchStockList();
	
	// Delete operation
	void deleteStockById(Long stockId);

}
