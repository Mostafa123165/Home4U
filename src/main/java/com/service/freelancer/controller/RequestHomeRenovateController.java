package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.RequestHomeRenovateDto;
import com.service.freelancer.mapper.RequestHomeRenovateMapper;
import com.service.freelancer.model.RequestHomeRenovate;
import com.service.freelancer.service.RequestHomeRenovateService;
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
@RequestMapping("api/v1/request-home-renovate")
@Tag(name = " Request Home Renovate")
public class RequestHomeRenovateController extends BaseControllerImpl<RequestHomeRenovate, RequestHomeRenovateDto, Long> {

    private final RequestHomeRenovateService requestHomeRenovateService;
    private final RequestHomeRenovateMapper requestHomeRenovateMapper;

    @GetMapping("/my-asks")
    public ResponseEntity<?> getMyAsks(@RequestParam Long askId) {
        List<RequestHomeRenovateDto> dtos = requestHomeRenovateMapper.map(requestHomeRenovateService.getByAskId(askId));
        return ResponseEntity.ok(new SuccessResponseList<RequestHomeRenovateDto>(dtos));
    }
}