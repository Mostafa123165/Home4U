package com.service.freelancer.controller;

import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.CertificateDto;
import com.service.freelancer.dto.ProjectDto;
import com.service.freelancer.dto.ProjectResponseDto;
import com.service.freelancer.model.Certificate;
import com.service.freelancer.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/certificate")
public class CertificateController {
    private final CertificateService certificateService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> uploadProject(
            @RequestPart("image") MultipartFile image,
            @RequestPart("certificate") CertificateDto certificate
    ) {
        certificateService.insert(certificate,image);
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }

    @GetMapping("/{certificateId}")
    public ResponseEntity<?> getCertificate(@PathVariable Long certificateId) {
        CertificateDto dto = certificateService.getCertificate(certificateId);
        return ResponseEntity.ok(new SuccessResponse<>(dto));
    }

    @GetMapping("/user-certificates")
    public ResponseEntity<?> getCertificates(@RequestParam(required = false) Long userId) {
        List<CertificateDto> dtos = certificateService.getcertificates(userId);
        return ResponseEntity.ok(new SuccessResponseList<>(dtos));
    }
}
