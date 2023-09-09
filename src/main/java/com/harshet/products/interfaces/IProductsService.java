package com.harshet.products.interfaces;

import com.harshet.products.dto.product;

import java.util.List;

public interface IProductsService {
    public List<product> getProducts();
    public product getProductById(Long id);
    public product updateProductById(product ProductInfo,Long id);
    public boolean deleteProductById(Long id);
    public product createProduct(product ProductInfo);
}
