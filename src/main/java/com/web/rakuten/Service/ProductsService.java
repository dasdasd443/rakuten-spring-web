package com.web.rakuten.Service;

import com.web.rakuten.Model.Products;
import com.web.rakuten.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsService {

    public final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getProducts(){
        return productsRepository.findAll();
    }
}
