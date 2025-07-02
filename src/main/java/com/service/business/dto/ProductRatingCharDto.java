package com.service.business.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductRatingCharDto {

    private double overAllRating;
    private long countRantings;
    private double oneStarPct;
    private double twoStarPct;
    private double threeStarPct;
    private double fourStarPct;
    private double fiveStarPct;

    public ProductRatingCharDto(double overAllRating,long countRantings,double oneStarPct, double twoStarPct, double threeStarPct, double fourStarPct,double fiveStarPct) {
        this.overAllRating = overAllRating;
        this.countRantings = countRantings;
        this.oneStarPct = oneStarPct;
        this.twoStarPct = twoStarPct;
        this.threeStarPct = threeStarPct;
        this.fourStarPct = fourStarPct;
        this.fiveStarPct = fiveStarPct;
    }
}
