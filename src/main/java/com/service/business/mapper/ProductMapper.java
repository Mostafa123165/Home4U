package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.*;
import com.service.business.model.Product;
import com.service.business.model.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = {LocaleContextHolder.class, Collections.class,Collectors.class},
        uses = {
        BusinessMapper.class,BusinessTypeMapper.class,ProductStockMapper.class,
        ProductMaterialMapper.class, ProductBaseUnitMapper.class,ColorMapper.class,
        ProductImageMapper.class})
public interface ProductMapper extends BaseMapper<Product, ProductDto> {


    ColorMapper colorMapper = Mappers.getMapper(ColorMapper.class);

    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
            @Mapping(target = "type", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getBusinessType().getNameAr() : t.getBusinessType().getNameEn())"),
            @Mapping(target = "imagePath", source = "t.mainImagePath"),
            @Mapping(target = "colors", expression = "java(mapStocksToColorDto(t.getStocks()))"),
            @Mapping(target = "inStock" , expression = "java(t.getStockAmount()>0?true:false)")
    })
    ProductCardDto mapToProductCard(Product t);

    List<ProductCardDto> mapToProductCard(List<Product> t);

    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
            @Mapping(target = "imagePath", source = "t.mainImagePath"),
            @Mapping(target = "price", source = "t.price"),
            @Mapping(target = "rate", ignore = true),
    })
    ProductShopNowDto mapToProductShopNow(Product t);

    List<ProductShopNowDto> mapToProductShopNow(List<Product> t);

    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
    })
    ProductIdDto mapToId(Product t);

    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
            @Mapping(target = "categoryName", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getBusinessTypeCategory().getNameAr() : t.getBusinessTypeCategory().getNameEn())"),
            @Mapping(target = "images", expression = "java(t.getImagePaths().stream().map(image -> image.getImagePath()).collect(Collectors.toList()))"),
    })
    ProductSimpleDto mapToProductSimple(Product t);

    List<ProductSimpleDto> mapToProductSimple(List<Product> t);

    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
            @Mapping(target = "categoryName", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getCategoryNameAr() : t.getCategoryNameEn())"),
            @Mapping(target = "images", expression = "java(t.getImages() != null ? List.of(t.getImages().split(\",\")) : new ArrayList<>())"),
            @Mapping(target = "bestSeller" , expression = "java(t.getIsBestSeller() == 1 ? true : false)"),
    })
    ProductSimpleDto mapToProductSimpleProjection(ProductSimpleProjection t);

    List<ProductSimpleDto> mapToProductSimpleProjection(List<ProductSimpleProjection> t);

    default List<ColorDto> mapStocksToColorDto(List<ProductStock> stocks) {
        return stocks.stream()
                .map(stock -> colorMapper.map(stock.getColor()))
                .collect(Collectors.toList());
    }
}




