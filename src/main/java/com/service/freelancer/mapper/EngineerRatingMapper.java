package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineerRatingDto;
import com.service.freelancer.model.EngineerRating;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {EngineerMapper.class})
public interface EngineerRatingMapper extends BaseMapper<EngineerRating, EngineerRatingDto> {
}
