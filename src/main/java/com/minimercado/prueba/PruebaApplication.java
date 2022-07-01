package com.minimercado.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@GetMapping("/home")
	public String getHome() {

		

		return "home.html";
	}

	@GetMapping("/comprar")
	public String comprar(@RequestParam(value = "p", defaultValue = "0") int producto_codigo) {

		// if (producto_codigo != 0) {
		// 	try {
		// 		Transaccion transaccion = new Transaccion();
		// 	} catch (Exception e) {
		// 		//
		// 	}
		// } else {

		// }

		return "comprar.html";
	}

}
