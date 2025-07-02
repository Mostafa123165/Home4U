package com.service.freelancer.controller;


import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponseList;
import com.service.base.model.SuccessResponsePage;
import com.service.freelancer.dto.AskEngineerDto;
import com.service.freelancer.dto.RequestDesignDto;
import com.service.freelancer.mapper.RequestDesignMapper;
import com.service.freelancer.model.RequestDesign;
import com.service.freelancer.service.RequestDesignService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/my-request-design")
    public ResponseEntity<?> getMyAsks () {
        List<RequestDesignDto> dtos = requestDesignMapper.map(requestDesignService.getMyAsks());
        return ResponseEntity.ok(new SuccessResponseList<RequestDesignDto>(dtos));
    }

}
