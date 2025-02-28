package com.service.file;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FileResponse  {

    private String fileName;
    private String fileDownloadUri;
    private String type ;
    private long size;
    private String relatedTo;
    private Long relatedId ;
    private String imagePath;


    public FileResponse(String fileName, String fileDownloadUri, String type, long size, String relatedTo,
                        Long relatedId , String imagePath) {

        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.type = type;
        this.size = size;
        this.relatedTo = relatedTo;
        this.relatedId = relatedId;
        this.imagePath= imagePath;
    }


}