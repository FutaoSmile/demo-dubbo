package com.futao.dubbo.web.controller;

import com.futao.api.service.FileService;
import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ft
 * @date 2021/1/13
 */
@SkipUserAuth
@RestController
@RequestMapping("/file")
public class FileController {
    @Reference
    private FileService fileService;

    @PutMapping("/upload")
    public void upload(@RequestParam MultipartFile file) throws IOException {
        uploadIs(file);
    }

    private void uploadIs(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        fileService.uploadIs(inputStream, file.getOriginalFilename());
        inputStream.close();
    }

    private void uploadFile(MultipartFile file) throws IOException {
        File file1 = new File("./" + file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        fileService.upload(file1);
    }
}
