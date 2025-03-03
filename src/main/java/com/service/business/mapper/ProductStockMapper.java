package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.ProductStockDto;
import com.service.business.model.ProductStock;
import org.mapstruct.Mapper;

@Mapper(uses = {ColorMapper.class})
public interface ProductStockMapper extends BaseMapper<ProductStock, ProductStockDto> {

}
