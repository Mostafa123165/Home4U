package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.EngineerDto;
import com.service.freelancer.model.Engineer;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineers")
@Tag(name = "Engineer")
public class EngineerController extends BaseControllerImpl<Engineer, EngineerDto,Long> {

}
