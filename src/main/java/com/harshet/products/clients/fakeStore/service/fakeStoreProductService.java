package com.harshet.products.clients.fakeStore.service;

import com.harshet.products.clients.fakeStore.dto.fakeStoreProductDTO;
import com.harshet.products.clients.fakeStore.dto.fakeStoreProductUpdateResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class fakeStoreProductService {

    private RestTemplate restTemplate;
    private String fakeStoreProductsBaseURL = "https://fakestoreapi.com/products";
    private String fakeStoreProductsByID = "https://fakestoreapi.com/products/{id}";
    public fakeStoreProductService(RestTemplateBuilder resttemplateBuilder){
        this.restTemplate= resttemplateBuilder.build();
    }

    public List<fakeStoreProductDTO> getProducts(){
            ResponseEntity<fakeStoreProductDTO[]> response =  restTemplate.getForEntity(fakeStoreProductsBaseURL,fakeStoreProductDTO[].class);
            return List.of(response.getBody());
    }

    public fakeStoreProductDTO getProduct(Long id){
        ResponseEntity<fakeStoreProductDTO> response =  restTemplate.getForEntity(fakeStoreProductsByID, fakeStoreProductDTO.class,id);
        fakeStoreProductDTO product = response.getBody();
        return product;
    }

    public fakeStoreProductDTO createProduct(fakeStoreProductDTO product){
          ResponseEntity<fakeStoreProductDTO> response = restTemplate.postForEntity(fakeStoreProductsBaseURL,product, fakeStoreProductDTO.class);
          return response.getBody();
    }
    public fakeStoreProductDTO deleteProduct(Long id){
        //ResponseEntity<fakeStoreProductDTO> response = restTemplate.delete(fakeStoreProductsByID,id);
        HttpHeaders header = new HttpHeaders();
        HttpEntity entity=   new HttpEntity<>(header);
        ResponseEntity<fakeStoreProductDTO> response =  restTemplate.exchange(fakeStoreProductsByID, HttpMethod.DELETE,entity,fakeStoreProductDTO.class,id);
        return response.getBody();
    }

    public fakeStoreProductDTO  updateProduct(fakeStoreProductDTO product, Long id){
        HttpHeaders header = new HttpHeaders();
        HttpEntity entity=   new HttpEntity<>(product,header);
        ResponseEntity<fakeStoreProductUpdateResponse> response =  restTemplate.exchange(fakeStoreProductsByID, HttpMethod.PUT,entity,fakeStoreProductUpdateResponse.class,id);
        return   this.getProduct(response.getBody().getId());
    }
}
