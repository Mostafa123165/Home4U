package com.service.file;

import com.service.base.model.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/file")
public class FileController {

    private final FileStorageService fileStorageService;

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadPhoto(@RequestParam String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            Path path = Paths.get(file.getAbsolutePath());
            Resource resource = new UrlResource(path.toUri());

            String contentType = Files.probeContentType(path);
            if (contentType == null) {
                contentType = "image/png";
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType)) 
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping
    @Operation(description = "paramters 1-file:- uploaded file ex. image, pdf, word, excel. "
            + " 2- id:- related id ex. branch id, account manager id  3- pathId: 1-user , 2-category , 3-sub category ")
    public ResponseEntity<?> cloudUploadFile(@RequestParam MultipartFile file, @RequestParam Long id,
                                          @RequestParam String pathId) throws IOException {

        FileResponse fileInfo = null;

        fileInfo = fileStorageService.cloudUploadFile(file, id, pathId);

        return ResponseEntity.ok(new SuccessResponse<FileResponse>(fileInfo));
    }
}
