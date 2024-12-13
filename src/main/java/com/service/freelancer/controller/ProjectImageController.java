package com.service.freelancer.controller;

import com.service.base.model.SuccessResponse;
import com.service.freelancer.service.ProjectImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/project-image")
public class ProjectImageController {
    protected final ProjectImageService projectImageService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        projectImageService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }

    @PostMapping(path = "/{projectId}",consumes = "multipart/form-data")
    public ResponseEntity<?> insert(@PathVariable Long projectId,
                                    @RequestPart("image") MultipartFile image) {
        projectImageService.insert(projectId,image);
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }
}
