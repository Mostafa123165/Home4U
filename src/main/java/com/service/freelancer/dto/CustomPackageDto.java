package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomPackageDto extends BaseEntityDto<Long> {

    private String name;
    private String nameAr;
    private String nameEn;

    private Double price;

    private String details;
    private String detailsAr;
    private String detailsEn;

}
