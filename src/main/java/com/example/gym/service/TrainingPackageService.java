package com.example.gym.service;

import com.example.gym.dto.request.TrainingPackageRequest;
import com.example.gym.dto.response.TrainingPackageResponse;

import java.util.List;

public interface TrainingPackageService {
    TrainingPackageResponse createTrainingPackage(TrainingPackageRequest request);
    TrainingPackageResponse updateTrainingPackage(TrainingPackageRequest request, Integer id);
    void deleteTrainingPackage(Integer id);
    List<TrainingPackageResponse> getAllTrainingPackages();
    TrainingPackageResponse getTrainingPackageById(Integer id);
}
