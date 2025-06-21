package com.service.business.dto;

import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsResponseDto extends BaseEntityDto<Long> {

    private ProductIdDto product;

    private double price;

    private double amount;
}
