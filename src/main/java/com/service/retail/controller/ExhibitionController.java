package com.service.retail.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.retail.dto.ExhibitionDto;
import com.service.retail.model.Exhibition;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Schema(name = "Exhibition")
@RequestMapping("api/v1/exhibitions")
public class ExhibitionController extends BaseControllerImpl<Exhibition, ExhibitionDto,Long> {

}
