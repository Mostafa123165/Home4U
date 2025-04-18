package com.service.common.controller;

import com.service.base.model.SuccessResponse;
import com.service.common.service.PortalConfigService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/portal-config")
@AllArgsConstructor
@Tag(name = "Portal Config")
public class PortalConfigController {

    final PortalConfigService portalConfigService;

    @GetMapping("")
    public ResponseEntity<?> findById() {
        return ResponseEntity.ok(new SuccessResponse<>(portalConfigService.findAll()));
    }
}
