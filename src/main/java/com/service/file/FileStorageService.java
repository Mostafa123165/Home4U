package com.service.file;

import com.service.base.Constant;
import com.service.common.model.PortalConfig;
import com.service.common.service.PortalConfigService;
import com.service.freelancer.model.Project;
import com.service.freelancer.model.ProjectImage;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
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
import java.util.*;

import static java.lang.System.currentTimeMillis;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileStorageService {

    @Value("${application.file.uploads.photos-output-path}")
    private String fileUploadPath;

    private final FileStorageReps fileStorageReps;

    private final PortalConfigService portalConfigService;
    public List<ProjectImage> addProject(@Nonnull List<MultipartFile> sourceFile, @Nonnull Project project,User user) {
        final String fileUploadSubPath = "projects" + "/" + user.getId()+ "/" +project.getId(); // projects/userId/projectId
        List<ProjectImage> paths = new ArrayList<>();
        for (MultipartFile multipartFile : sourceFile) {
            paths.add(new ProjectImage(Objects.requireNonNull(uploadFile(multipartFile, fileUploadSubPath)),project));
        }
        return paths;
    }
    public String addCertificates(@Nonnull MultipartFile sourceFile, @Nonnull User user) {
        final String fileUploadSubPath = "certificate" + "/" + user.getId(); // certificate/userId
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    public String addProjectImage(@Nonnull MultipartFile sourceFile, @Nonnull Project project,User user) {
        final String fileUploadSubPath = "projects" + "/" + user.getId()+ "/" +project.getId(); // projects/userId/projectId
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    public String addPersonalPhoto(MultipartFile sourceFile, Long userId) {
        final String fileUploadSubPath = "personalPhoto" + "/" + userId; // personalPhoto/userId
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    private String uploadFile(
            @Nonnull MultipartFile sourceFile,
            @Nonnull String fileUploadSubPath
    ) {
        final String finalUploadPath = fileUploadPath + "/" + fileUploadSubPath;
        File targetFolder = new File(finalUploadPath);

        if (!targetFolder.exists()) {
            boolean folderCreated = targetFolder.mkdirs();
            if (!folderCreated) {
                log.warn("Failed to create the target folder: " + targetFolder);
                return null;
            }
        }

        final String fileExtension = getFileExtension(sourceFile.getOriginalFilename());
        String targetFilePath = finalUploadPath + "/" + currentTimeMillis() + "." + fileExtension;
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


    public FileResponse cloudUploadFile(MultipartFile file,Long id,	String pathId) throws IOException {

        String fileName = null;

        String pathType = preparePathType(pathId);

        // deleteOldImage(id, pathId);

        if (file.getContentType().contains("image")) {
            fileName = id + "_" + UUID.randomUUID() + ".jpg"  ;
        }else {
            fileName = id + file.getOriginalFilename();
        }
        String targetFolder = this.fileUploadPath + "/" + pathType;
        String uniqueFileName = pathType + fileName ;
        String downloadUri = this.fileUploadPath + "/"+ uniqueFileName;
        uploadObjectFile(targetFolder,downloadUri,file);
        updateImagePath(id, downloadUri, pathId);
        FileResponse fileInfo = new FileResponse(fileName, downloadUri, file.getContentType(), file.getSize(), pathType,
                id , uniqueFileName);

        return fileInfo ;
    }

    private void uploadObjectFile(String targetFolder,String fullPath, MultipartFile file) throws IOException {
        File directory = new File(targetFolder);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            Files.write(Paths.get(fullPath), file.getBytes());
            log.info("File saved to: " + fullPath);
        } catch (IOException e) {
            log.error("File was not saved", e);
        }
    }

    private void updateImagePath(Long id, String downloadUri, String pathId) {
        if (pathId.equalsIgnoreCase(Constant.ConfigKeyEnum.BUSINESS_PRODUCTS)) {
            fileStorageReps.updateImagePath(Constant.ImageTableNameEunm.BUSINESS_PRODUCTS, "image_path" ,downloadUri, id);
        }
        if (pathId.equalsIgnoreCase(Constant.ConfigKeyEnum.COVER_PHOTO)) {
            fileStorageReps.updateImagePath(Constant.ImageTableNameEunm.USER, "cover_photo" ,downloadUri, id);
        }
        if (pathId.equalsIgnoreCase(Constant.ConfigKeyEnum.PERSONAL_CARD)) {
            fileStorageReps.updateImagePath(Constant.ImageTableNameEunm.ENGINEERING_OFFICE, "personal_card_path" ,downloadUri, id);
        }
        if (pathId.equalsIgnoreCase(Constant.ConfigKeyEnum.TAX_CARD)) {
            fileStorageReps.updateImagePath(Constant.ImageTableNameEunm.ENGINEERING_OFFICE, "tax_card_path" ,downloadUri, id);
        }
        if (pathId.equalsIgnoreCase(Constant.ConfigKeyEnum.COMMERCIAL_REGISTER)) {
            fileStorageReps.updateImagePath(Constant.ImageTableNameEunm.ENGINEERING_OFFICE, "commercial_register_path" ,downloadUri, id);
        }
    }

    public String preparePathType(String pathId) {

        Optional<PortalConfig> config = portalConfigService.findByConfigKey(pathId);

        if (config.isPresent()) {
            return config.get().getConfigValue();
        }else {
            return null;
        }
    }

   /* public void deleteOldImage(Long id , String pathId) {

        if (pathId.equalsIgnoreCase(Constants.IMAGE_USER_PROFILE)) { // 1
//				AppUser entity = userService.findById(id);
            String imagePath = fileStorageReps.getImagePath(SEC_USERS, id);
            String faceId = fileStorageReps.getImagePath(SEC_USERS, "face_id", id);
            if (imagePath != null) {
                try {
                    awsDeleteObject(imagePath);
                    deleteFacesFromCollection(faceId, collectionId);
                } catch (Exception e) {
                    log.error("Error deleting image from s3 bucket", e);
                }

            }
//				userService.update(entity);
        } else if (pathId.equalsIgnoreCase(Constants.IMAGE_INV_CATEGORY)) { // 2
//				Category entity = categoryService.findById(id);
            String imagePath = fileStorageReps.getImagePath(INV_CATEGORIES, id);
            if (imagePath != null) {
                try {
                    awsDeleteObject(imagePath);
                } catch (Exception e) {
                    log.error("Error deleting image from s3 bucket", e);
                }
            }

        }
    }*/
}
