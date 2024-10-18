package com.example.gym.mapper;

import com.example.gym.dto.request.GymRequest;
import com.example.gym.dto.request.TrainingPackageRequest;
import com.example.gym.dto.response.GymResponse;
import com.example.gym.dto.response.TrainingPackageResponse;
import com.example.gym.entities.Gym;
import com.example.gym.entities.TrainingPackage;
import org.springframework.stereotype.Component;

@Component
public class TrainingPackageMapper {
    public TrainingPackage toTrainingPackage(TrainingPackageRequest request) {
        if (request == null) {
            return null;
        } else {
            TrainingPackage.TrainingPackageBuilder trainingPackage = TrainingPackage.builder();
            trainingPackage.name(request.getName());
            trainingPackage.description(request.getDescription());
            trainingPackage.duration(request.getDuration());
            trainingPackage.price(request.getPrice());
            trainingPackage.type(request.getType());
            trainingPackage.description(request.getDescription());
            return trainingPackage.build();
        }
    }

    public TrainingPackageResponse toTrainingPackageResponse(TrainingPackage trainingPackage) {
        if (trainingPackage == null) {
            return null;
        } else {
            TrainingPackageResponse.TrainingPackageResponseBuilder response = TrainingPackageResponse.builder();
            response.id(trainingPackage.getId());
            response.name(trainingPackage.getName());
            response.description(trainingPackage.getDescription());
            response.duration(trainingPackage.getDuration());
            response.price(trainingPackage.getPrice());
            response.type(trainingPackage.getType());
            return response.build();
        }
    }

    public void updateTrainingPackage(TrainingPackage trainingPackage, TrainingPackageRequest request) {
        if (request != null) {
            trainingPackage.setName(request.getName());
            trainingPackage.setDescription(request.getDescription());
            trainingPackage.setDuration(request.getDuration());
            trainingPackage.setPrice(request.getPrice());
            trainingPackage.setType(request.getType());
            trainingPackage.setDescription(request.getDescription());
        }
    }
}
