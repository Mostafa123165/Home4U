package com.service.retail.mapper;

import com.service.auth.model.UserRegisterDto;
import com.service.base.mapper.BaseMapper;
import com.service.retail.dto.ExhibitionDto;
import com.service.retail.model.Exhibition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ExhibitionMapper extends BaseMapper<Exhibition, ExhibitionDto> {


    @Mappings({
            @Mapping(target = "types",source = "t.exhibition.types"),
            @Mapping(target = "tradName",source = "t.exhibition.tradName"),
            @Mapping(target = "bioAr",source = "t.exhibition.bioAr"),
            @Mapping(target = "bioEn",source = "t.exhibition.bioEn"),
    })
    Exhibition unMapUserRegister(UserRegisterDto t);
}
