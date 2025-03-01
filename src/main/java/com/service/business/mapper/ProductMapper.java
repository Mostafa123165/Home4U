package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.ProductCardDto;
import com.service.business.dto.ProductDto;
import com.service.business.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Mapper(imports = {LocaleContextHolder.class},uses = {BusinessMapper.class,BusinessTypeMapper.class,ProductStockMapper.class,
                ProductMaterialMapper.class, ProductBaseUnitMapper.class})
public interface ProductMapper extends BaseMapper<Product, ProductDto> {

    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
            @Mapping(target = "type", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getBusinessType().getNameAr() : t.getBusinessType().getNameEn())"),
    })
    ProductCardDto mapToProductCard(Product t);

    List<ProductCardDto> mapToProductCard(List<Product> t);
}

