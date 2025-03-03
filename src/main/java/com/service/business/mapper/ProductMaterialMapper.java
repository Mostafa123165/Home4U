package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.ProductMaterialDto;
import com.service.business.model.ProductMaterial;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMaterialMapper extends BaseMapper<ProductMaterial, ProductMaterialDto> {

}
