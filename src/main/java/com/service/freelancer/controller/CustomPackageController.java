package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.CustomPackageDto;
import com.service.freelancer.model.CustomPackage;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/custom-package")
@Tag(name = "Custom Package")
@RequiredArgsConstructor
public class CustomPackageController extends BaseControllerImpl<CustomPackage, CustomPackageDto, Long> {

}
