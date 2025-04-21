package com.service.freelancer.controller;


import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponsePage;
import com.service.freelancer.dto.RequestDesignDto;
import com.service.freelancer.mapper.RequestDesignMapper;
import com.service.freelancer.model.RequestDesign;
import com.service.freelancer.service.RequestDesignService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/request-design")
@Tag(name = "Request Design")
@RequiredArgsConstructor
public class RequestDesignController extends BaseControllerImpl<RequestDesign, RequestDesignDto, Long> {
    private final RequestDesignService requestDesignService;

    private final RequestDesignMapper requestDesignMapper;


    @PostMapping("/filter")
    public ResponseEntity<?> filter(@Valid @RequestBody SearchRequest req) {
        Page<RequestDesignDto> dtos = requestDesignService.filter(Optional.ofNullable(req)).map(requestDesignMapper::map);
        return ResponseEntity.ok(new SuccessResponsePage<RequestDesignDto>(dtos));
    }

}
