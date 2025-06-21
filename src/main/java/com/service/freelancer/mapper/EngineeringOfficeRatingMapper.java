package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineeringOfficeRatingDto;
import com.service.freelancer.model.EngineeringOfficeRating;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {EngineeringOfficeMapper.class})
public interface EngineeringOfficeRatingMapper extends BaseMapper<EngineeringOfficeRating, EngineeringOfficeRatingDto> {

}
