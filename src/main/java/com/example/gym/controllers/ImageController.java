package com.example.gym.controllers;

import com.example.gym.dto.response.ApiResponse;
import com.example.gym.entities.Image;
import com.example.gym.service.ImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ImageController {
    ImageService imageService;

    @PostMapping("/create")
    public ApiResponse<Image> create(@RequestParam("file") MultipartFile file) throws IOException {
        return ApiResponse.<Image>builder()
                .code(200)
                .result(imageService.addImage(file))
                .message("Thêm ảnh thành công.")
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getImageById(@PathVariable("id") Integer id) throws MalformedURLException, FileNotFoundException {
        Resource resource = imageService.getImageResourceById(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImageById(@PathVariable("id") Integer id) {
        try {
            imageService.deleteImageById(id);
            return ResponseEntity.ok("Image deleted successfully");
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
