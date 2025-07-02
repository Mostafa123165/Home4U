package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponseList;
import com.service.base.model.SuccessResponsePage;
import com.service.freelancer.dto.SelectCustomPackageDto;
import com.service.freelancer.mapper.SelectCustomPackageMapper;
import com.service.freelancer.model.SelectCustomPackage;
import com.service.freelancer.service.SelectCustomPackageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/select-custom-package")
@Tag(name = "Select Custom Package")
@RequiredArgsConstructor
public class SelectCustomPackageController extends BaseControllerImpl<SelectCustomPackage, SelectCustomPackageDto, Long> {

    private final SelectCustomPackageService selectCustomPackageService;
    private final SelectCustomPackageMapper selectCustomPackageMapper;

    @PostMapping("/filter")
    public ResponseEntity<?> filter(@Valid @RequestBody SearchRequest req) {
        Page<SelectCustomPackageDto> dtos = selectCustomPackageService.filter(Optional.ofNullable(req)).map(selectCustomPackageMapper::map);
        return ResponseEntity.ok(new SuccessResponsePage<SelectCustomPackageDto>(dtos));
    }

    @GetMapping("/my-select-package")
    public ResponseEntity<?> getMyAsks() {
        List<SelectCustomPackageDto> dtos = selectCustomPackageMapper.map(selectCustomPackageService.getMyAsks());
        return ResponseEntity.ok(new SuccessResponseList<SelectCustomPackageDto>(dtos));
    }
}
