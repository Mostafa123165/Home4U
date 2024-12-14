package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.ProjectDto;
import com.service.freelancer.dto.ProjectResponseDto;
import com.service.freelancer.mapper.ProjectMapper;
import com.service.freelancer.model.Project;
import com.service.freelancer.service.ProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/project")
@Tag(name = "project")
public class ProjectController extends BaseControllerImpl<Project, ProjectDto,Long> {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadProject(
            @RequestPart("images") List<MultipartFile> images,
            @RequestPart(value = "cover",required = false) MultipartFile cover,
            @RequestPart("projectData") ProjectDto projectData
    ) {

        return ResponseEntity.ok(new SuccessResponse<ProjectResponseDto>
                (projectMapper.mapResponse(projectService.insert(projectData ,cover,images))));
    }

    @Override
    @GetMapping("/{projectId}")
    public ResponseEntity<?> findById(@PathVariable Long projectId) {
        ProjectResponseDto dto = projectService.getProject(projectId);
        return ResponseEntity.ok(new SuccessResponse<>(dto));
    }

    @GetMapping("/user-projects")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Long userId) {
        List<ProjectDto> dtos = projectService.getAll(userId);
        return ResponseEntity.ok(new SuccessResponseList<>(dtos));
    }



    @PutMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> updateProject(
            @RequestPart("images") List<MultipartFile> images,
            @RequestPart(value = "cover" , required = false) MultipartFile cover,
            @RequestPart("projectData") ProjectDto projectData
    ) {
        return ResponseEntity.ok(new SuccessResponse<ProjectResponseDto>
                (projectMapper.mapResponse(projectService.update(projectData ,cover,images))));
    }

}
