package com.hgj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
