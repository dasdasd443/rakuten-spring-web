package com.web.rakuten;

import com.web.rakuten.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class RakutenApplication {

	public final ProductsService productsService;

	@Autowired
	public RakutenApplication(ProductsService productsService) {
		this.productsService = productsService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RakutenApplication.class, args);
	}

	@GetMapping("/")
	public String home(Model model){
		//List<Products> rakuten_products = productsService.getProducts();
		model.addAttribute("products", productsService.getProducts());
		return "index";
	}

	
	@GetMapping("/user-login")
	public String login(){
		return "login";
	}

	@GetMapping("/user-register")
	public String register(){
		return "register";
	}
}
