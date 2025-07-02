package com.service.business.dto;

public interface ProductSimpleProjection {
    Long getId();
    String getNameAr();
    String getNameEn();
    double getRate();
    long getCountRates();
    double getPrice();
    Long getNumberOfSales();
    Integer getIsBestSeller();
    Long getProductRankBySales();
    String getCategoryNameAr();
    String getCategoryNameEn();
    String getImages();
}
