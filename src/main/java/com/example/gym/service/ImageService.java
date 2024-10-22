package com.example.gym.service;

import com.example.gym.entities.Image;
import com.example.gym.exception.ApplicationException;
import com.example.gym.exception.ErrorCode;
import com.example.gym.repositories.ImageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ImageService {
    ImageRepository imageRepository;

    public Image addImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File must not be empty");
        }

        String relativePath = System.getProperty("user.dir") + "/Images/";
        File directory = new File(relativePath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it does not exist
        }

        String savedImagePath = relativePath + file.getOriginalFilename();
        File savedFile = new File(savedImagePath);
        file.transferTo(savedFile); // Save the file to the specified path

        // Create a new Image entity
        Image image = Image.builder()
                .title(file.getOriginalFilename())
                .url(savedImagePath)
                .alt(getFileNameWithoutExtension(file.getOriginalFilename()))
                .uploadDate(new Date())
                .build();

        // Save the Image entity to the repository and return it
        return imageRepository.save(image); // Do not set the id field manually
    }


    public Resource getImageResourceById(Integer id) throws MalformedURLException, FileNotFoundException {
        var imageFromDatabase = imageRepository.findById(id);

        if (imageFromDatabase.isPresent()) {
            var realImage = imageFromDatabase.get();
            Path pathToImage = Path.of(realImage.getUrl());

            File file = new File(realImage.getUrl());
            InputStream inputStream = new FileInputStream(file);
            InputStreamSource inputStreamSource = new InputStreamResource(inputStream);
            Resource resource = new UrlResource(pathToImage.toUri());

            if (resource.exists()) {
                return resource;  // return Resource directly
            } else {
                throw new ApplicationException(ErrorCode.ITEM_NOT_FOUND);
            }
        } else {
            throw new FileNotFoundException("Image with ID " + id + " not found in the database");
        }
    }

    public void deleteImageById(Integer id) throws FileNotFoundException {
        var imageFromDatabase = imageRepository.findById(id);

        if (imageFromDatabase.isPresent()) {
            imageRepository.deleteById(id);  // xoá bản ghi
        } else {
            throw new FileNotFoundException("Image with ID " + id + " not found");
        }
    }


    // Phương thức để lấy tên tệp mà không có đuôi
    private String getFileNameWithoutExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return filename; // Nếu tên tệp rỗng, trả về rỗng
        }
        int lastIndexOfDot = filename.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return filename; // Nếu không có dấu chấm, trả về toàn bộ tên tệp
        }
        return filename.substring(0, lastIndexOfDot); // Lấy phần tên tệp trước dấu chấm cuối cùng
    }
}
