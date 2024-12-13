package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.CertificateDto;
import com.service.freelancer.dto.ProjectDto;
import com.service.freelancer.dto.ProjectResponseDto;
import com.service.freelancer.model.Certificate;
import com.service.freelancer.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface CertificateMapper extends BaseMapper<Certificate, CertificateDto> {


    @Override
    @Mappings({
            @Mapping(target = "path", ignore = true)
    })
    Certificate unMap(CertificateDto dto);

}
