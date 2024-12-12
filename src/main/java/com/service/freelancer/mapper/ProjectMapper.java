package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.file.FileUtils;
import com.service.freelancer.dto.ProjectDto;
import com.service.freelancer.dto.ProjectResponseDto;
import com.service.freelancer.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseMapper<Project, ProjectDto> {

    @Override
    @Mappings({
            @Mapping(target = "coverPath", ignore = true)
    })
    ProjectDto map(Project t);
    List<ProjectDto> map(List<Project> t);
    @Mappings({
            @Mapping(target = "images", ignore = true)
    })
    ProjectResponseDto mapResponse(Project t);

    @Override
    @Mappings({
            @Mapping(target = "coverPath", ignore = true)
    })
    Project unMap(ProjectDto dto);


}
