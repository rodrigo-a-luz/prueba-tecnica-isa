package com.minimercado.prueba;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minimercado.prueba.services.StockService;
import com.minimercado.prueba.services.TransaccionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootApplication
@Controller
public class PruebaApplication {

	@Autowired
	private TransaccionService transaccionService;

	@Autowired
	private StockService stockService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@RequestMapping(value = "/home")
	public String home(
		HttpServletRequest request,
		HttpServletResponse response
	) {

		// List<Transaccion> transacciones = transaccionService.fetchTransaccionList();

		// if (transacciones != null) {
		// 	for (int i = 0; i < transacciones.size(); i++) {
		// 		Transaccion transaccion = transacciones.get(i);
		// 		System.out.println(transaccion.toString());
		// 		List<Linea> lineas = transaccion.getLineas();
		// 		if (lineas != null) {
		// 			for (int j = 0; j < lineas.size(); j++) {
		// 				Linea linea = lineas.get(j);
		// 				System.out.println(linea.toString());
		// 			}
		// 		} else {
		// 			System.out.println("Transaccion sin lineas");
		// 		}
		// 	}
		// } else {
		// 	System.out.println("transacciones es NULL");
		// }

		// request.setAttribute("transacciones", transacciones);

		List<Stock> stockList = stockService.fetchStockList();

		if (stockList != null) {
			for (int i = 0; i < stockList.size(); i++) {
				Stock stock = stockList.get(i);
				System.out.println(stock.toString());
			}
		} else {
			System.out.println("transacciones es NULL");
		}

		request.setAttribute("stockList", stockList);

		return "homepage";
	}

	@RequestMapping(value = "/comprar")
	public String comprar(
		HttpServletRequest request,
		HttpServletResponse response,
		@RequestParam(value = "codigo", defaultValue = "0") String codigo
		// Model model
	) {

		// if (producto_codigo != 0) {
		// 	try {
		// 		Transaccion transaccion = new Transaccion();
		// 	} catch (Exception e) {
		// 		//
		// 	}
		// } else {

		// }

		// System.out.println("CODIGO: " + (request.getParameter("codigo") != null ? request.getParameter("codigo") : "NO_CODE"));

		// request.setAttribute("codigo", codigo);
		// model.addAttribute("codigo", codigo);

		return "comprarpage";
	}

}
