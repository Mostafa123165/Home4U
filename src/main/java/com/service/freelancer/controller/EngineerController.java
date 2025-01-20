package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.freelancer.dto.EngineerDto;
import com.service.freelancer.mapper.EngineerMapper;
import com.service.freelancer.model.Engineer;
import com.service.freelancer.service.EngineerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineers")
@Tag(name = "Engineer")
public class EngineerController extends BaseControllerImpl<Engineer, EngineerDto,Long> {

    private final EngineerService engineerService;
    private final EngineerMapper engineerMapper;

    @GetMapping("/user")
    public ResponseEntity<?> getByUserId(@RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(new SuccessResponse<>(engineerMapper.map(engineerService.findByUserId(userId))));
    }


}
