package com.service.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.base.Constant;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class OrderSimpleDto {
    private Long id;
    private String orderNumber;
    private double quantity;
    private double price;
    private OrderStatusDto status;

    @JsonFormat(pattern = Constant.DateFormate.DATE_FORMAT)
    private LocalDateTime createdDate;

}
