package com.example.ManagerEmployee.Model;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {

    private MultipartFile fileData;

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }
}
