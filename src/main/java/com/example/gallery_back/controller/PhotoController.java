package com.example.gallery_back.controller;

import com.example.gallery_back.dto.request.PhotoRequest;
import com.example.gallery_back.dto.response.PhotoResponse;
import com.example.gallery_back.service.FileStorageService;
import com.example.gallery_back.service.PhotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping
    public List<PhotoResponse> list() {
        return photoService.findAll();
    }

    @GetMapping("/{id}")
    public PhotoResponse get(@PathVariable Long id) {
        return photoService.findById(id);
    }

    @PostMapping
    public PhotoResponse upload(
            @Valid @ModelAttribute  PhotoRequest request,
            @RequestParam MultipartFile file
    ) {
        return photoService.save(request, file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        photoService.delete(id);
    }
}
