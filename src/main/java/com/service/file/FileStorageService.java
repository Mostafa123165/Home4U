package com.service.file;

import com.service.freelancer.model.Certificate;
import com.service.freelancer.model.Project;
import com.service.freelancer.model.ProjectImage;
import com.service.userManagement.model.User;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.io.File.separator;
import static java.lang.System.currentTimeMillis;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileStorageService {

    @Value("${application.file.uploads.photos-output-path}")
    private String fileUploadPath;

    public List<ProjectImage> addProject(@Nonnull List<MultipartFile> sourceFile, @Nonnull Project project) {
        final String fileUploadSubPath = "projects" + separator + project.getId(); // projects/projectId
        List<ProjectImage> paths = new ArrayList<>();
        for (MultipartFile multipartFile : sourceFile) {
            paths.add(new ProjectImage(uploadFile(multipartFile, fileUploadSubPath),project));
        }
        return paths;
    }
    public String addCertificates(@Nonnull MultipartFile sourceFile, @Nonnull User user) {
        final String fileUploadSubPath = "certificate" + separator + user.getId(); // certificate/user
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    public String addProjectCover (@Nonnull MultipartFile sourceFile, @Nonnull Project project) {
        final String fileUploadSubPath = "projects" + separator + project.getId(); // projects/projectId
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    private String uploadFile(
            @Nonnull MultipartFile sourceFile,
            @Nonnull String fileUploadSubPath
    ) {
        final String finalUploadPath = fileUploadPath + separator + fileUploadSubPath; //   ./uploads/projects/projectId
        File targetFolder = new File(finalUploadPath);

        if (!targetFolder.exists()) {
            boolean folderCreated = targetFolder.mkdirs();
            if (!folderCreated) {
                log.warn("Failed to create the target folder: " + targetFolder);
                return null;
            }
        }

        final String fileExtension = getFileExtension(sourceFile.getOriginalFilename());
        String targetFilePath = finalUploadPath + separator + currentTimeMillis() + "." + fileExtension;
        Path targetPath = Paths.get(targetFilePath);

        try {
            Files.write(targetPath, sourceFile.getBytes());
            log.info("File saved to: " + targetFilePath);
            return targetFilePath;
        } catch (IOException e) {
            log.error("File was not saved", e);
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }
}
