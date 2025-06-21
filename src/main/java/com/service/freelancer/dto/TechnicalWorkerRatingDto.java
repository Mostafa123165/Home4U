package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.common.dto.SimpleDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TechnicalWorkerRatingDto extends BaseEntityDto<Long> {
    private Integer rate;
    private String comment;
    private SimpleDto technicalWorker;
}
