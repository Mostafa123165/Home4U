package com.service.business.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.business.model.HomeFurnishingRequestType;
import com.service.common.dto.GovernorateDto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.Set;

@Getter
@Setter
public class HomeFurnishingRequestDto extends BaseEntityDto<Long> {

    @NotNull(message = "Request type cannot be null")
    private HomeFurnishingRequestTypeDto requestType;

    @NotBlank(message = "Phone number cannot be blank")
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters")
    private String phoneNumber;

    @NotNull(message = "Government cannot be null")
    private GovernorateDto government;

    @NotNull(message = "Time frame cannot be null")
    @Min(value = 1, message = "Time frame must be at least 1 day")
    private Integer timeFrameDays;

    @NotNull(message = "Budget cannot be null")
    @Min(value = 0, message = "Budget must be at least 0")
    private Double budget;

    private String attachmentFileUrl;

    private String note;

    private Set<ProductMaterialDto> productMaterial;

    private KitchenTypeDto kitchenType;

    private Set<DevicesAttachedDto> devicesAttacheds;

    private Long kitchenSize;

    private FurnitureTypeDto furnitureType;

}
