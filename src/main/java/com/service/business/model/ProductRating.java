package com.service.business.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        name = "product_ratings",
        uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "user_id"})
)
public class ProductRating extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private Double rate;

    @Column(columnDefinition = "TEXT")
    private String comment;
}
