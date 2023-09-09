package com.harshet.products.services;

import com.harshet.products.dto.product;
import com.harshet.products.interfaces.IProductsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProductsService")
public class ProductsService implements IProductsService {

    @Override
    public List<product> getProducts() {
        List products = new ArrayList();

        product product = new product();
        product.setDescription("Try First");
        products.add(product);
        return products;
    }

    @Override
    public product getProductById(Long id) {
        product product = new product();
        product.setDescription(String.valueOf(id));
        return product;
    }

    @Override
    public product updateProductById(product ProductInfo, Long id) {
        return new product();
    }

    @Override
    public boolean deleteProductById(Long id) {
        return true;
    }

    public product createProduct(product ProductInfo){
        return new product();
    }
}
