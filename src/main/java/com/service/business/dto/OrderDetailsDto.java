package com.service.business.dto;

import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsDto extends BaseEntityDto<Long> {

    @NotNull(message = "Product id is required")
    private Long productId;

    @NotNull(message = "amount is required")
    private double amount;
}
