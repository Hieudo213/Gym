package com.example.gym.service;

import com.example.gym.dto.request.EquipmentRequest;
import com.example.gym.dto.response.EquipmentResponse;

import java.util.List;

public interface EquipmentService {
    EquipmentResponse createEquipment(EquipmentRequest request);
    EquipmentResponse updateEquipment(EquipmentRequest request, Integer id);
    void deleteEquipment(Integer id);
    List<EquipmentResponse> getAllEquipment();
    EquipmentResponse getEquipmentById(Integer id);
}
