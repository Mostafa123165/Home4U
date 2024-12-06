package com.service.freelancer.controller;


import com.service.base.controller.BaseLkpControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.EngineerServDto;
import com.service.freelancer.mapper.EngineerServMapper;
import com.service.freelancer.model.EngineerServ;
import com.service.freelancer.service.EngineerServService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineer-services")
@Tag(name = "EngineerService")
public class EngineerServController extends BaseLkpControllerImpl< EngineerServ, EngineerServDto,Integer> {

    private final EngineerServService engineerServService;

    private final EngineerServMapper engineerServMapper;

    @GetMapping("/service/{id}")
    @Operation(summary = "Get engineer service")
    public ResponseEntity<?> service (@PathVariable Long id) {
        List<EngineerServDto> engineerServs =engineerServMapper.map(engineerServService.getService(id));
        return ResponseEntity.ok(new SuccessResponseList<>(engineerServs));
    }

}
