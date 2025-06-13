package com.service.business.dto;

import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRatingDto extends BaseEntityDto<Long> {

    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Rate is required")
    @Min(value = 1, message = "Rate must be between 1 and 5")
    @Max(value = 5, message = "Rate must be between 1 and 5")
    private Double rate;

    private String comment;
}
