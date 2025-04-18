package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.AskEngineerPhotosDto;
import com.service.freelancer.dto.AskWorkerPhotosDto;
import com.service.freelancer.model.AskEngineerPhotos;
import com.service.freelancer.model.AskWorkerPhotos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AskWorkerPhotosMapper extends BaseMapper<AskWorkerPhotos, AskWorkerPhotosDto> {

    @Override
    @Mappings({
            @Mapping(target = "askWorker.id",source = "t.askWorkerId")
    })
    AskWorkerPhotos unMap(AskWorkerPhotosDto t);

    @Override
    @Mappings({
            @Mapping(target = "askWorkerId",source = "t.askWorker.id")
    })
    AskWorkerPhotosDto map(AskWorkerPhotos t);

}
