package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.RequestRequestDesignDto;
import com.service.freelancer.mapper.RequestRequestDesignMapper;
import com.service.freelancer.model.RequestRequestDesign;
import com.service.freelancer.service.RequestRequestDesignService;
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
@RequestMapping("api/v1/request-request-design")
@Tag(name = "  Request Request Design")
public class RequestRequestDesignController extends BaseControllerImpl<RequestRequestDesign, RequestRequestDesignDto, Long> {

    private final RequestRequestDesignService requestRequestDesignService;
    private final RequestRequestDesignMapper requestRequestDesignMapper;

    @GetMapping("/my-asks")
    public ResponseEntity<?> getMyAsks(@RequestParam Long askId) {
        List<RequestRequestDesignDto> dtos = requestRequestDesignMapper.map(requestRequestDesignService.getByAskId(askId));
        return ResponseEntity.ok(new SuccessResponseList<RequestRequestDesignDto>(dtos));
    }
}