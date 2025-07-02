package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.RequestAskEngineerDto;
import com.service.freelancer.mapper.RequestAskEngineerMapper;
import com.service.freelancer.model.RequestAskEngineer;
import com.service.freelancer.service.RequestAskEngineerService;
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
@RequestMapping("api/v1/request-ask-engineer")
@Tag(name = " Request Ask Engineer")
public class RequestAskEngineerController extends BaseControllerImpl<RequestAskEngineer, RequestAskEngineerDto, Long> {

    private final RequestAskEngineerService requestAskEngineerService;
    private final RequestAskEngineerMapper requestAskEngineerMapper;

    @GetMapping("/my-asks")
    public ResponseEntity<?> getMyAsks(@RequestParam Long askId) {
        List<RequestAskEngineerDto> dtos = requestAskEngineerMapper.map(requestAskEngineerService.getByAskId(askId));
        return ResponseEntity.ok(new SuccessResponseList<RequestAskEngineerDto>(dtos));
    }
}

