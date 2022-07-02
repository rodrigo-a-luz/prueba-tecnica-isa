package com.minimercado.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimercado.prueba.Stock;
import com.minimercado.prueba.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public Stock saveStock(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public List<Stock> fetchStockList() {
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public void deleteStockById(Long StockId) {
		stockRepository.deleteById(StockId);
	}
}
