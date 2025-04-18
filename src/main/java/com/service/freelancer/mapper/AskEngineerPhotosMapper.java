package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.ProductImageDto;
import com.service.business.model.ProductImage;
import com.service.freelancer.dto.AskEngineerPhotosDto;
import com.service.freelancer.model.AskEngineerPhotos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AskEngineerPhotosMapper extends BaseMapper<AskEngineerPhotos, AskEngineerPhotosDto> {

    @Override
    @Mappings({
            @Mapping(target = "askEngineer.id",source = "t.askEngineerId")
    })
    AskEngineerPhotos unMap(AskEngineerPhotosDto t);

    @Override
    @Mappings({
            @Mapping(target = "askEngineerId",source = "t.askEngineer.id")
    })
    AskEngineerPhotosDto map(AskEngineerPhotos t);
}
