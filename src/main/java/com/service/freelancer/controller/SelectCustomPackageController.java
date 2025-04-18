package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.SelectCustomPackageDto;
import com.service.freelancer.model.SelectCustomPackage;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/select-custom-package")
@Tag(name = "Select Custom Package")
@RequiredArgsConstructor
public class SelectCustomPackageController extends BaseControllerImpl<SelectCustomPackage, SelectCustomPackageDto, Long> {
}
