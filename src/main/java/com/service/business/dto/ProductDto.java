package com.service.business.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.business.model.ProductImage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProductDto extends BaseEntityDto<Long> {

    @NotBlank(message = "Arabic name is required")
    private String nameAr;

    @NotBlank(message = "English name is required")
    private String nameEn;

    @NotBlank(message = "Arabic description is required")
    private String descriptionAr;

    @NotBlank(message = "English description is required")
    private String descriptionEn;

    @NotNull(message = "Price is required")
    private double price;

    private double length;

    private double width;

    private double height;

    @NotNull(message = "Business type is required")
    private BusinessTypeDto businessType;

    @NotNull(message = "Business type category is required")
    private BusinessTypeCategoryDto businessTypeCategory;

    @NotNull(message = "Base unit is required")
    private ProductBaseUnitDto baseUnit;

    private Set<ProductMaterialDto> materials;

    @Valid
    private List<ProductStockDto> stocks;

    private List<ProductImageDto> imagePaths;

}
