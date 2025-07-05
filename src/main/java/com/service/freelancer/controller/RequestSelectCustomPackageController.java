package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.RequestSelectCustomPackageDto;
import com.service.freelancer.mapper.RequestSelectCustomPackageMapper;
import com.service.freelancer.model.RequestSelectCustomPackage;
import com.service.freelancer.service.RequestSelectCustomPackageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Override
    public ResponseEntity<?> update(@RequestBody RequestSelectCustomPackageDto dto) {
        RequestSelectCustomPackage entity1 = requestSelectCustomPackageService.findById(dto.getId());
        RequestSelectCustomPackage entity2 = requestSelectCustomPackageMapper.UpdateMap(dto, entity1);
        RequestSelectCustomPackage result = requestSelectCustomPackageService.update(entity2);
        RequestSelectCustomPackageDto dtos = requestSelectCustomPackageMapper.map(result);
        return ResponseEntity.ok(new SuccessResponse<>(dtos));
    }
}