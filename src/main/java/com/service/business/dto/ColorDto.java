package com.service.business.dto;

import com.service.base.dto.BaseLkpEntityDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ColorDto extends BaseLkpEntityDto<Integer> {
    private String hexColor;
}
