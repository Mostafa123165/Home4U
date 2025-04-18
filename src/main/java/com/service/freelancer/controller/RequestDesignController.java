package com.service.freelancer.controller;


import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.RequestDesignDto;
import com.service.freelancer.model.RequestDesign;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/request-design")
@Tag(name = "Request Design")
@RequiredArgsConstructor
public class RequestDesignController extends BaseControllerImpl<RequestDesign, RequestDesignDto, Long> {
}
