package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ProjectResponseDto extends BaseEntityDto<Long> {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String tool;
    private List<byte[]> images;
}

