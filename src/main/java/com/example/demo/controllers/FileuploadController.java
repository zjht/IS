package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("file")
public class FileuploadController {
    @PostMapping("/upload")
    public Map<String,Object> up(@RequestParam("f")MultipartFile f, HttpServletRequest request) throws IOException{
        System.out.println(f.getOriginalFilename());
        System.out.println(f.getContentType());
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(f,path);
        String url="192.168.3.44:8080/"+f.getOriginalFilename();
        Map<String, Object>result=new HashMap<>();
        result.put("url",url);
        Date id = new Date();
        result.put("id",id);
        return result;
    }

    private void saveFile(MultipartFile f, String path) throws IOException{
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }

        File file = new File( path+f.getOriginalFilename());
        f.transferTo(file);
    }


}