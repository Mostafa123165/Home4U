package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.RequestAskWorkerDto;
import com.service.freelancer.mapper.RequestAskWorkerMapper;
import com.service.freelancer.model.RequestAskWorker;
import com.service.freelancer.service.RequestAskWorkerService;
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
@RequestMapping("api/v1/request-ask-worker")
@Tag(name = "Request Ask Worker Controller")
public class RequestAskWorkerController extends BaseControllerImpl<RequestAskWorker, RequestAskWorkerDto, Long> {

    private final RequestAskWorkerService requestAskWorkerService;
    private final RequestAskWorkerMapper requestAskWorkerMapper;

    @GetMapping("/my-asks")
    public ResponseEntity<?> getMyAsks(@RequestParam Long askId) {
        List<RequestAskWorkerDto> dtos = requestAskWorkerMapper.map(requestAskWorkerService.getByAskId(askId));
        return ResponseEntity.ok(new SuccessResponseList<RequestAskWorkerDto>(dtos));
    }
}
