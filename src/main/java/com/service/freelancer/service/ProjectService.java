package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.file.FileStorageService;
import com.service.file.FileUtils;
import com.service.freelancer.dto.ProjectDto;
import com.service.freelancer.dto.ProjectResponseDto;
import com.service.freelancer.mapper.ProjectMapper;
import com.service.freelancer.model.Project;
import com.service.freelancer.model.ProjectImage;
import com.service.freelancer.repository.ProjectReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService  extends BaseServiceImpl<Project, Long> {

    private final FileStorageService fileStorageService;
    private final UserService userService;
    private final ProjectReps projectReps;

    private final ProjectMapper projectMapper;


    public Project insert(ProjectDto dto ,MultipartFile cover ,List<MultipartFile> images) {
        Project p = projectMapper.unMap(dto);
        p.setUser(userService.getCurrentUser());
        Project project = projectReps.save(p);
        project.setImages(fileStorageService.addProject(images,project));
        project.setCoverPath(fileStorageService.addProjectCover(cover,project));
        return super.update(project);
    }

    public ProjectResponseDto getProject (Long projectId) {
        Project project = projectReps.findById(projectId).get();
        ProjectResponseDto dto = projectMapper.mapResponse(project);
        List<byte[]> images = new ArrayList<>();
        for (ProjectImage projectImage : project.getImages()) {
            images.add(FileUtils.readFileFromLocation(projectImage.getPath()));
        }
        dto.setImages(images);
        return dto;
    }

    public List<ProjectDto> getAll(Long userId) {
        if(userId == null)userId = userService.getCurrentUser().getId();
        List<Project> project = projectReps.findProjectsByUser(userId);
        List<ProjectDto> dtos = new ArrayList<>();
        for (Project p : project) {
            ProjectDto projectDto = projectMapper.map(p);
            projectDto.setCoverPath(FileUtils.readFileFromLocation(p.getCoverPath()));
            dtos.add(projectDto);
        }
        return dtos;
    }

}
