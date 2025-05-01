package com.service.business.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductShopNowDto {

    private long id;
    private String name;
    private double price;
    private String imagePath;
    private double rate;

    public ProductShopNowDto() {
    }

    public ProductShopNowDto(String name, double price, String imagePath, double rate) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.rate = rate;
    }
}
