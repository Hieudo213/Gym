package com.example.gym.controllers;

import com.example.gym.dto.request.TrainingPackageRequest;
import com.example.gym.dto.response.ApiResponse;
import com.example.gym.dto.response.TrainingPackageResponse;
import com.example.gym.service.TrainingPackageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training-package")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TrainingPackageController {
    TrainingPackageService trainingPackageService;

    @PostMapping("/create")
    ApiResponse<TrainingPackageResponse> trainingPackage(@RequestBody TrainingPackageRequest request) {
        return ApiResponse.<TrainingPackageResponse>builder()
                .code(200)
                .result(trainingPackageService.createTrainingPackage(request))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<TrainingPackageResponse> updateTrainingPackage(@PathVariable Integer id, @RequestBody TrainingPackageRequest request) {
        return ApiResponse.<TrainingPackageResponse>builder()
                .code(200)
                .result(trainingPackageService.updateTrainingPackage(request, id))
                .build();
    }

    @GetMapping
    ApiResponse<List<TrainingPackageResponse>> getAllTrainingPackages() {
        return ApiResponse.<List<TrainingPackageResponse>>builder()
                .code(200)
                .result(trainingPackageService.getAllTrainingPackages())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<TrainingPackageResponse> getTrainingPackage(@PathVariable Integer id) {
        return ApiResponse.<TrainingPackageResponse>builder()
                .code(200)
                .result(trainingPackageService.getTrainingPackageById(id))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteTrainingPackage(@PathVariable Integer id) {
        trainingPackageService.deleteTrainingPackage(id);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Delete successfully!")
                .build();
    }
}
