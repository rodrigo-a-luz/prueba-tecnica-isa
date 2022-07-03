package com.minimercado.prueba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.minimercado.prueba.services.ProductoService;
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

	@Autowired
	private ProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@RequestMapping(value = "/home")
	public String home(
		HttpServletRequest request,
		HttpServletResponse response
	) {

		List<Stock> stockList = stockService.fetchStockList();

		request.setAttribute("stockList", stockList);

		return "homepage";
	}

	@RequestMapping(value = "/comprar")
	public String comprar(
		// @ModelAttribute Carrito carrito,
		// Model model
		// Map<String, String> params
		HttpServletRequest request,
		HttpServletResponse response,
		RedirectAttributes redirectAttributes
	) {

		// proceso la compra
		// obtengo parametros recibidos
		Map<String, String[]> params = request.getParameterMap();
		if (params != null) {
			// valido parametros
			if (
				params.containsKey("producto") &&
				params.containsKey("cantidad")
			) {
				String[] productos = params.get("producto");
				String[] cantidades = params.get("cantidad");
				int cantidadProductos =  productos.length;

				if (cantidadProductos > 0) {
					// hay productos
					try {
						// construyo un mapa de productos para facilitar su busqueda
						List<Producto> productoList = productoService.fetchProductoList();
						Map<String, Producto> mapaProductos = new HashMap<>();
						productoList.forEach(producto -> {
							mapaProductos.put(String.valueOf(producto.getCodigo()), producto);
						});

						// construyo un mapa de stocks para facilitar su busqueda
						List<Stock> stocks = stockService.fetchStockList();
						Map<String, Stock> mapaStocks = new HashMap<String, Stock>();
						stocks.forEach(stock -> {
							mapaStocks.put(String.valueOf(stock.getProducto().getCodigo()), stock);
						});

						// construyo la lista de lineas para la transaccion
						List<Linea> newLineas = new ArrayList<Linea>();
						for (int i = 0; i < productos.length; i++) {
							Stock stock = mapaStocks.get(productos[i]);
							if ((Integer.valueOf(cantidades[i]) > 0) && (Integer.valueOf(cantidades[i]) <= stock.getCantidad())) {
								// creo y agrego la Linea correspondiente
								Linea nLinea = new Linea(mapaProductos.get(productos[i]),
										Integer.parseInt(cantidades[i]));
								try {
									// lineaService.saveLinea(nLinea);
								} catch (Exception e) {
									// no se hace nada, se intenta crear la transaccion igualmente
								};
								try {
									// stock.setCantidad(stock.getCantidad() - nLinea.getCantidad());
									// stockService.saveStock(stock);
								} catch (Exception e) {
									// no se hace nada, se intenta crear la transaccion igualmente
								};
								newLineas.add(nLinea);
							} else {
								request.setAttribute("error", "No se pudo procesar la compra");
								return "error";
							}
						};

						if (!newLineas.isEmpty()) {
							Transaccion transaccion = new Transaccion(newLineas);
							transaccionService.saveTransaccion(transaccion);
						} else {
							request.setAttribute("error", "No se pudo procesar la compra");
							return "error";
						}
					} catch (Exception e) {
						request.setAttribute("error", "No se pudo procesar la compra");
						return "error";
					}
					
				}
			}
		}

		// System.out.println("#params: " + params.size());
		System.out.println("Params: ");
		request.getParameterMap().forEach((key, value) -> {
			System.out.println("KEY: " + key);
			System.out.println("VALUES:");
			for (int i = 0; i < value.length; i++) {
				System.out.println(value[i]);
			}
		});

		// agrego mensaje de alerta
		redirectAttributes.addAttribute("msgalert", "Gracias por comprar en el Minimercado!");

		return "redirect:/home";
	}

}
