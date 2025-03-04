package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.ColorDto;
import com.service.business.dto.ProductCardDto;
import com.service.business.dto.ProductDto;
import com.service.business.model.Product;
import com.service.business.model.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = {LocaleContextHolder.class, Collections.class},uses =
        {BusinessMapper.class,BusinessTypeMapper.class,ProductStockMapper.class,
        ProductMaterialMapper.class, ProductBaseUnitMapper.class,ColorMapper.class})
public interface ProductMapper extends BaseMapper<Product, ProductDto> {


    ColorMapper colorMapper = Mappers.getMapper(ColorMapper.class);

    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
            @Mapping(target = "type", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getBusinessType().getNameAr() : t.getBusinessType().getNameEn())"),
            @Mapping(target = "imagePath", source = "t.mainImagePath"),
            @Mapping(target = "colors", expression = "java(mapStocksToColorDto(t.getStocks()))"),
    })
    ProductCardDto mapToProductCard(Product t);

    List<ProductCardDto> mapToProductCard(List<Product> t);

    default List<ColorDto> mapStocksToColorDto(List<ProductStock> stocks) {
        return stocks.stream()
                .map(stock -> colorMapper.map(stock.getColor()))
                .collect(Collectors.toList());
    }
}

