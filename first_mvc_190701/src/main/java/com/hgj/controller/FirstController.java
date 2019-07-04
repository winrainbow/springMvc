package com.hgj.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class FirstController {
    @RequestMapping(path = "/hello", method = {RequestMethod.POST, RequestMethod.GET})
    public String first() {
        return "success";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }


    @RequestMapping(value = "/upload1", method = RequestMethod.POST)
    public String uploadFileOld(HttpServletRequest request) throws Exception {

        String filePath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        System.out.println("fileItems:"+fileItems.size());
        for(FileItem fileItem:fileItems){
            if(!fileItem.isFormField()){
                String fileName = fileItem.getName();
                System.out.println("fileName:"+fileName);
                String uuid = UUID.randomUUID().toString().replace("-","");
                fileItem.write(new File(filePath,uuid+"_"+fileName));
                fileItem.delete();
            }
        }


        return "success";
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request, MultipartFile upload) throws IOException {
        String filePath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(filePath);
        if(!file.exists()){
           file.mkdirs();
        }
        String originalFilename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileName =  uuid+"_"+originalFilename;
        upload.transferTo(new File(filePath,fileName));
        return "success";
    }

}
