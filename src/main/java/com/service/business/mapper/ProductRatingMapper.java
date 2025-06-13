package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.ProductRatingDto;
import com.service.business.dto.ProductRatingResponseDTO;
import com.service.business.model.ProductRating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface ProductRatingMapper extends BaseMapper<ProductRating, ProductRatingDto> {

    @Override
    @Mappings({
            @Mapping(target = "productId", source = "product.id"),
    })
    ProductRatingDto map(ProductRating entity);

    @Override
    @Mappings({
            @Mapping(target = "product.id",source = "productId"),
    })
    ProductRating unMap(ProductRatingDto productRatingDto);

    @Mappings({
            @Mapping(target = "userName", expression = "java(t.getUser().getUsername())"),
            @Mapping(target = "userImage", source = "user.personalPhoto"),
            @Mapping(target = "userId", source = "user.id"),
    })
    ProductRatingResponseDTO mapToProductRatingResponse(ProductRating t);

    List<ProductRatingResponseDTO> mapToProductRatingResponse(List<ProductRating> t);
}
