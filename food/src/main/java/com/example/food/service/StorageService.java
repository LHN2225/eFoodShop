package com.example.food.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    public String saveImage(MultipartFile file, String packageName) throws IOException;
}
