package com.example.gym.service.implement;

import com.example.gym.dto.request.TrainingPackageRequest;
import com.example.gym.dto.response.TrainingPackageResponse;
import com.example.gym.entities.TrainingPackage;
import com.example.gym.mapper.TrainingPackageMapper;
import com.example.gym.repositories.TrainingPackageRepository;
import com.example.gym.service.TrainingPackageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TrainingPackageServiceImpl implements TrainingPackageService {
    TrainingPackageRepository trainingPackageRepository;
    TrainingPackageMapper trainingPackageMapper;


    @Override
    public TrainingPackageResponse createTrainingPackage(TrainingPackageRequest request) {
        TrainingPackage trainingPackage = trainingPackageMapper.toTrainingPackage(request);
        return trainingPackageMapper.toTrainingPackageResponse(trainingPackageRepository.save(trainingPackage));
    }

    @Override
    public TrainingPackageResponse updateTrainingPackage(TrainingPackageRequest request, Integer id) {
        TrainingPackage trainingPackage = trainingPackageRepository
                .findById(id).orElseThrow(()-> new RuntimeException("Training Package Not Found"));
        trainingPackageMapper.updateTrainingPackage(trainingPackage, request);
        return trainingPackageMapper.toTrainingPackageResponse(trainingPackageRepository.save(trainingPackage));
    }

    @Override
    public void deleteTrainingPackage(Integer id) {
        trainingPackageRepository.deleteById(id);
    }

    @Override
    public List<TrainingPackageResponse> getAllTrainingPackages() {
        return trainingPackageRepository.findAll()
                .stream()
                .map(trainingPackageMapper::toTrainingPackageResponse)
                .toList();
    }

    @Override
    public TrainingPackageResponse getTrainingPackageById(Integer id) {
        return trainingPackageMapper.toTrainingPackageResponse(trainingPackageRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Training Package Not Found")));
    }
}
