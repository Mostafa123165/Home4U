package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.CertificateDto;
import com.service.freelancer.mapper.CertificateMapper;
import com.service.freelancer.model.Certificate;
import com.service.freelancer.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/certificate")
public class CertificateController extends BaseControllerImpl<Certificate, CertificateDto,Long> {
    private final CertificateService certificateService;

    private final CertificateMapper certificateMapper;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> uploadProject(
            @RequestPart("image") MultipartFile image,
            @RequestPart("certificate") CertificateDto certificate
    ) {
        return ResponseEntity.ok(new SuccessResponse<CertificateDto>(certificateMapper.map(certificateService.insert(certificate,image))));
    }

    @PutMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> updateProject(
            @RequestPart("image") MultipartFile image,
            @RequestPart("certificate") CertificateDto certificate
    ) {
        return ResponseEntity.ok(new SuccessResponse<CertificateDto>(certificateMapper.map(certificateService.insert(certificate,image))));
    }

    @Override
    @GetMapping("/{certificateId}")
    public ResponseEntity<?> findById(@PathVariable Long certificateId) {
        CertificateDto dto = certificateService.getCertificate(certificateId);
        return ResponseEntity.ok(new SuccessResponse<CertificateDto>(dto));
    }

    @GetMapping("/user-certificates")
    public ResponseEntity<?> getCertificates(@RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(new SuccessResponseList<CertificateDto>(certificateService.getcertificates(userId)));
    }

}
