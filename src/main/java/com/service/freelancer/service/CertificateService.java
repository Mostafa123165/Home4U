package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.file.FileStorageService;
import com.service.freelancer.dto.CertificateDto;
import com.service.freelancer.mapper.CertificateMapper;
import com.service.freelancer.model.Certificate;
import com.service.freelancer.repository.CertificateReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateService extends BaseServiceImpl<Certificate, Long> {

    private final CertificateMapper certificateMapper;
    private final CertificateReps certificateReps;
    private final UserService userService;
    private final FileStorageService fileStorageService;

    public Certificate insert(CertificateDto certificateDto, MultipartFile image) {
        Certificate c = certificateMapper.unMap(certificateDto);
        c.setUser(userService.getCurrentUser());
        Certificate certificate = certificateReps.save(c);
        certificate.setPath(fileStorageService.addCertificates(image,userService.getCurrentUser()));
        return super.update(certificate);
    }

    public Certificate getCertificate(Long certificateId) {
        return certificateReps.findById(certificateId).get();

    }

    public List<Certificate> getCertificates(Long userId) {
        if(userId == null)userId = userService.getCurrentUser().getId();
        return certificateReps.findByUserId(userId);

    }
}
