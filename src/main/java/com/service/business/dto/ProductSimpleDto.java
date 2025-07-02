package com.service.business.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductSimpleDto {

    private Long id;
    private String name;
    private double rate;
    private long countRates;
    private double price;
    private Long numberOfSales;
    private boolean bestSeller;
    private Long productRankBySales;
    private String categoryName;
    private List<String> images;


}
