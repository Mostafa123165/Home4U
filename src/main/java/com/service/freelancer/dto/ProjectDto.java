package com.service.freelancer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ProjectDto extends BaseEntityDto<Long>  {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String tools;

    private String coverPath;

}
