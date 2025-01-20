package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.CertificateDto;
import com.service.freelancer.model.Certificate;
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
    List<Certificate> unMap(List<CertificateDto> dto);


}
