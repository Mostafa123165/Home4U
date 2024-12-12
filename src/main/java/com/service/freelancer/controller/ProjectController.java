package com.service.freelancer.controller;

import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.ProjectDto;
import com.service.freelancer.dto.ProjectResponseDto;
import com.service.freelancer.service.ProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/project")
@Tag(name = "project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> uploadProject(
            @RequestPart("images") List<MultipartFile> images,
            @RequestPart("cover") MultipartFile cover,
            @RequestPart("projectData") ProjectDto projectData
    ) {
        projectService.insert(projectData ,cover,images);
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProject(@PathVariable Long projectId) {
        ProjectResponseDto dto = projectService.getProject(projectId);
        return ResponseEntity.ok(new SuccessResponse<>(dto));
    }

    @GetMapping("/user-projects")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Long userId) {
        List<ProjectDto> dtos = projectService.getAll(userId);
        return ResponseEntity.ok(new SuccessResponseList<>(dtos));
    }

}
