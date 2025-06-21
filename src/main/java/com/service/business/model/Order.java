package com.service.business.model;

import com.service.base.model.BaseEntity;
import com.service.common.model.OrderStatus;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"order_number"})
})
public class Order extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private OrderStatus status;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    @Column(name = "total_price")
    private double totalPrice;

    public void associateOrderDetails() {
        this.getOrderDetails().forEach(orderDetail -> orderDetail.setOrder(this));
    }
}
