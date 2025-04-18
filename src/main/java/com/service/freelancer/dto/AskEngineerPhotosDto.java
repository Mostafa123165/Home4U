package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AskEngineerPhotosDto {

    private Long id;

    private Long askEngineerId;

    private String photoPath;
}
