package com.service.business.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageDto {
    private Long id;
    private Long productId;
    private String imagePath;
}
