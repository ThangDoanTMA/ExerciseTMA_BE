package com.example.ManagerEmployee.Controller;

import com.example.ManagerEmployee.Model.UploadedFile;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UploadedFileController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public String uploadFileHandlerPOST(HttpServletRequest request, Model model, @ModelAttribute("uploadedFile")UploadedFile uploadedFile) {
        return this.doUpload(request, model, uploadedFile);
    }

    private String doUpload(HttpServletRequest request, Model model, UploadedFile uploadedFile){
        //Thư mục gốc upload file Image
        String uploadImgRootPath = "D://TMA Solution//Training//Excersise//excercise-employee-manager//public//images";
        System.out.println("uploadImgRootPath" + uploadImgRootPath);

        File uploadImgRootDir = new File(uploadImgRootPath);
        //Tạo thư mục gốc upload nếu nó không tồn tại
        if(!uploadImgRootDir.exists()){
            uploadImgRootDir.mkdirs();
        }

        MultipartFile fileData = uploadedFile.getFileData();

        List<File> uploadedFiles = new ArrayList<>();
        List<String> failedFiles = new ArrayList<>();

        //Tên file Image gốc tại Client
        String imageName = fileData.getOriginalFilename();
        System.out.println("Client Image File Name = " + imageName);

        if(imageName != null && imageName.length()>0) {
            try {
                //Tạo file Image tại server
                File serverImgFile = new File(uploadImgRootDir.getAbsolutePath() + File.separator + imageName);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverImgFile));
                stream.write(fileData.getBytes());
                stream.close();

                uploadedFiles.add(serverImgFile);
                System.out.println("Write file: "+ serverImgFile);
            } catch (Exception e) {
                System.out.println("Error Write file: " + imageName);
                failedFiles.add(imageName);
            }
        }

        System.out.print(uploadedFile);
        model.addAttribute("uploadedFiles ", uploadedFiles);
        model.addAttribute("failedFiles ", failedFiles);

        return "uploadResult";
    }
}
