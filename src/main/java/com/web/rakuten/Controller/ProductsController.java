package com.web.rakuten.Controller;


import com.web.rakuten.Model.Products;
import com.web.rakuten.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String home(Model model){
        //List<Products> rakuten_products = productsService.getProducts();
        model.addAttribute("products", productsService.getProducts());
        return "index";
    }
}
