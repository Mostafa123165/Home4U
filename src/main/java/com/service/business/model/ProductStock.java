package com.service.business.model;

import com.service.base.model.BaseEntity;
import com.service.common.model.Color;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product_stocks", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_id","color_id"})})
public class ProductStock extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @Column(name = "amount",nullable = false)
    private double amount;
}
