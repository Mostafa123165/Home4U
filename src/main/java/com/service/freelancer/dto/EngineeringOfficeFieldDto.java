package com.service.freelancer.dto;

import com.service.base.dto.BaseLkpEntityDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EngineeringOfficeFieldDto  extends BaseLkpEntityDto<Integer> {
    private static final long serialVersionUID = 5877866567112767764L;


    private String nameAr;
    private String nameEn;
    private EngineerTypeDto engineerType;
}