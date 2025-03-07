package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.ColorDto;
import com.service.business.dto.ProductMaterialDto;
import com.service.business.model.ProductMaterial;
import com.service.common.model.Color;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface ProductMaterialMapper extends BaseMapper<ProductMaterial, ProductMaterialDto> {

    @Override
    @Mappings(
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    )
    ProductMaterialDto map(ProductMaterial t);
}
