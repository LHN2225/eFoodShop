package com.example.food.service.impl;

import com.example.food.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public String saveImage(MultipartFile file, String packageName) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        String fileExtension, fullFileName = file.getOriginalFilename();

        // Get file extenstion
        int index = fullFileName.lastIndexOf('.');
        if (index == -1) {
            return "";
        } else {
            fileExtension = fullFileName.substring(index, fullFileName.length());
        }

        Resource resource = resourceLoader.getResource("classpath:/static" + packageName);
        String packagePath = resource.getFile().getAbsolutePath();
        fileNames.append(String.valueOf(new Date().getTime()) + fileExtension);
        Path path = Paths.get(packagePath + "/" + fileNames);
        Files.write(path, file.getBytes());

        return fileNames.toString();
    }

}
