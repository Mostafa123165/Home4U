package com.service.business.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "product_visits", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_id", "user_id"})
})
public class ProductVisit extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ProductVisit() {
    }

    public ProductVisit(Product product, User user) {
        this.product = product;
        this.user = user;
    }
}
