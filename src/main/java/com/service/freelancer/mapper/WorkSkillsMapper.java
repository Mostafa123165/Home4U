package com.service.freelancer.mapper;
import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.TechnicalWorkerTypeDto;
import com.service.freelancer.dto.WorkSkillsDto;
import com.service.freelancer.model.TechnicalWorkerType;
import com.service.freelancer.model.WorkSkills;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class })
public interface WorkSkillsMapper extends BaseMapper<WorkSkills, WorkSkillsDto> {
    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    })
    WorkSkillsDto map(WorkSkills t);
}