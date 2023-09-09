package com.harshet.products.clients.fakeStore.dto;

import lombok.Data;

@Data
public class fakeStoreProductDTO {
    public Long id;
    public String title;
    public String price;
    public String category;
    public String description;
    public String image;
    public rating rating;
}

class rating{
    public double rate;
    public Long count;
}

