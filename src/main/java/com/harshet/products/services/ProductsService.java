package com.harshet.products.services;

import com.harshet.products.clients.fakeStore.dto.fakeStoreProductDTO;
import com.harshet.products.clients.fakeStore.service.fakeStoreProductService;
import com.harshet.products.dto.product;
import com.harshet.products.exceptions.NotFoundException;
import com.harshet.products.interfaces.IProductsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProductsService")
public class ProductsService implements IProductsService {

    fakeStoreProductService fakeStoreProductService;
    public ProductsService(fakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
    }
    private  product convertfakeStoreProduct(fakeStoreProductDTO fakeStoreProduct){
        product product = new product();
        product.setDescription(fakeStoreProduct.getDescription());
        product.setCategory(fakeStoreProduct.getCategory());
        product.setImage(fakeStoreProduct.getImage());
        product.setTitle(fakeStoreProduct.getTitle());
        product.setPrice(fakeStoreProduct.getPrice());
        return  product;
    }
    private  fakeStoreProductDTO convertProductToFakeStore(product product){
        fakeStoreProductDTO fakeStoreProductDTO = new fakeStoreProductDTO();
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory());
        fakeStoreProductDTO.setImage(product.getImage());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        return  fakeStoreProductDTO;
    }
    @Override
    public List<product> getProducts() {
        List products = new ArrayList();

        List<fakeStoreProductDTO> fakeStoreProduct=  this.fakeStoreProductService.getProducts();
        for(fakeStoreProductDTO fakeStore: fakeStoreProduct){
            products.add(this.convertfakeStoreProduct(fakeStore));
        }
        return products;
    }

    @Override
    public product getProductById(Long id)  throws NotFoundException {
           fakeStoreProductDTO fakeStoreProduct = this.fakeStoreProductService.getProduct(id);
        return this.convertfakeStoreProduct(fakeStoreProduct);
    }

    @Override
    public product updateProductById(product ProductInfo, Long id) {
       fakeStoreProductDTO fakeStoreProduct= this.fakeStoreProductService.updateProduct( this.convertProductToFakeStore(ProductInfo) ,id );
       return this.convertfakeStoreProduct(fakeStoreProduct);
    }

    @Override
    public product deleteProductById(Long id) {

        fakeStoreProductDTO fakeStoreProduct = this.fakeStoreProductService.deleteProduct(id);
        return this.convertfakeStoreProduct(fakeStoreProduct);
    }

    public product createProduct(product ProductInfo){
        fakeStoreProductDTO fakeStoreProduct = this.fakeStoreProductService.createProduct( this.convertProductToFakeStore(ProductInfo) );
        return this.convertfakeStoreProduct(fakeStoreProduct);
    }
}
