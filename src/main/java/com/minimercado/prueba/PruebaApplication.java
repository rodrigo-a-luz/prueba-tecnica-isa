package com.minimercado.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootApplication
@Controller
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@RequestMapping(value = "/home")
	public String home() {

		

		return "homepage.html";
	}

	@RequestMapping(value = "/comprar")
	public String getComprar(
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
