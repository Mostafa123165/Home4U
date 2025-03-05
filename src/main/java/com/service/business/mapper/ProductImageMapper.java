package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.ProductImageDto;
import com.service.business.model.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ProductImageMapper extends BaseMapper<ProductImage, ProductImageDto> {
    @Override
    @Mappings({
            @Mapping(target = "product.id",source = "t.productId")
    })
    ProductImage unMap(ProductImageDto t);

    @Override
    @Mappings({
            @Mapping(target = "productId",source = "t.product.id")
    })
    ProductImageDto map(ProductImage t);
}
