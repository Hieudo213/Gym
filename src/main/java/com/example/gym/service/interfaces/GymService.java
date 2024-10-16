package com.example.gym.service.interfaces;

import com.example.gym.dto.request.GymRequest;
import com.example.gym.dto.response.ApiResponse;
import com.example.gym.dto.response.GymResponse;

import java.util.List;

public interface GymService {
    GymResponse createGym(GymRequest gymRequest);
    GymResponse updateGym(GymRequest gymRequest, Integer gymId);
    List<GymResponse> getAllGyms();
    GymResponse getGymById(Integer gymId);
    void deleteGymById(Integer gymId);
}
