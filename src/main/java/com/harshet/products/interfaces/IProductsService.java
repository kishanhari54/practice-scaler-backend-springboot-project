package com.harshet.products.interfaces;

import com.harshet.products.dto.product;
import com.harshet.products.exceptions.NotFoundException;

import java.util.List;

public interface IProductsService {
    public List<product> getProducts();
    public product getProductById(Long id) throws NotFoundException;
    public product updateProductById(product ProductInfo,Long id);
    public product deleteProductById(Long id);
    public product createProduct(product ProductInfo);
}
