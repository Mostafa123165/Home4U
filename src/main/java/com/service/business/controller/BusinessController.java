package com.service.business.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.business.dto.BusinessDto;
import com.service.business.model.Business;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Schema(name = "Business")
@RequestMapping("api/v1/business")
public class BusinessController extends BaseControllerImpl<Business, BusinessDto,Long> {

}
