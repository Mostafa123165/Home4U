package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.RequestSelectCustomPackageDto;
import com.service.freelancer.mapper.RequestSelectCustomPackageMapper;
import com.service.freelancer.model.RequestSelectCustomPackage;
import com.service.freelancer.service.RequestSelectCustomPackageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/request-select-custom-package")
@Tag(name = " Request Select Custom Package")
public class RequestSelectCustomPackageController extends BaseControllerImpl<RequestSelectCustomPackage, RequestSelectCustomPackageDto, Long> {

    private final RequestSelectCustomPackageService requestSelectCustomPackageService;
    private final RequestSelectCustomPackageMapper requestSelectCustomPackageMapper;

    @GetMapping("/my-asks")
    public ResponseEntity<?> getMyAsks(@RequestParam Long askId) {
        List<RequestSelectCustomPackageDto> dtos = requestSelectCustomPackageMapper.map(requestSelectCustomPackageService.getByAskId(askId));
        return ResponseEntity.ok(new SuccessResponseList<RequestSelectCustomPackageDto>(dtos));
    }
}