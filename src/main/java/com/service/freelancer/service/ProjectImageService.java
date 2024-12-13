package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.file.FileStorageService;
import com.service.freelancer.model.Project;
import com.service.freelancer.model.ProjectImage;
import com.service.freelancer.repository.ProjectImageReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProjectImageService extends BaseServiceImpl<ProjectImage, Long> {

    private final ProjectService projectService;
    private final FileStorageService fileStorageService;
//    private final ProjectImageReps projectImageReps;


    public void insert(Long projectId, MultipartFile image) {
        Project project = projectService.findById(projectId);
        ProjectImage projectImage = new ProjectImage(fileStorageService.addProjectImage(image, project),project);
        project.getImages().add(projectImage);
        projectService.insert(project);
    }
}
