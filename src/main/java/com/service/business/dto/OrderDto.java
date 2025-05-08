package com.service.business.dto;

import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto extends BaseEntityDto<Long> {

    private Long userId;

    @Size(min = 1, message = "Order details must be greater than 0")
    private List<OrderDetailsDto> orderDetails;
}
