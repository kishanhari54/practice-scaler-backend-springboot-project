package com.harshet.products.controllers;

import com.harshet.products.dto.product;
import com.harshet.products.exceptions.NotFoundException;
import com.harshet.products.interfaces.IProductsService;
import com.harshet.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class productsController {
    ProductsService productService;
    // Constructor
    public productsController(ProductsService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<product> getAllProducts(){
    return this.productService.getProducts();
    }

    @GetMapping("/{id}")
    public product getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return this.productService.getProductById(id);
    }

    @PostMapping
    public product createProduct(@RequestBody product request){
        return this.productService.createProduct(request);
    }

    @PutMapping("/{id}")
    public product updateProductById(@RequestBody product request , @PathVariable("id") Long id){

        return this.productService.updateProductById(request,id);
    }
    @DeleteMapping("{id}")
    public product deleteProductById(@PathVariable("id") Long id){
            return this.productService.deleteProductById(id);
    }
}
