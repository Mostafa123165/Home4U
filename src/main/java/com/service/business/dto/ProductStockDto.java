package com.service.business.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.common.model.Color;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStockDto extends BaseEntityDto<Long> {

    @NotNull(message = "Product stock color is required")
    private ColorDto color;

    @NotNull(message = "Product stock amount is required")
    private double amount;
}
