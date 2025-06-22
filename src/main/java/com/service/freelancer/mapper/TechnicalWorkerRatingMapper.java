package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.TechnicalWorkerRatingDto;
import com.service.freelancer.model.TechnicalWorkerRating;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {TechnicalWorkerMapper.class})
public interface TechnicalWorkerRatingMapper extends BaseMapper<TechnicalWorkerRating, TechnicalWorkerRatingDto> {
}
