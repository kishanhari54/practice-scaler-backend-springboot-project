package com.harshet.products.controllers;

import com.harshet.products.dto.product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class productsController {

    // Constructor
    public productsController(){}

    @GetMapping
    public String getAllProducts(){
        return "Products Fetched";
    }

    @GetMapping("/{id}")
    public product getProductById(@PathVariable("id") Long id){
        product product = new product();
        product.setDescription("Take it");
        return product;
    }

    @PostMapping
    public product createProduct(@RequestBody product request){
        return new product();
    }

    @PutMapping
    public product updateProductById(@RequestBody product request , Long id){
        return new product();
    }
    @DeleteMapping("{id}")
    public boolean deleteProductById(@PathVariable("id") Long id){
            return true;
    }
}
