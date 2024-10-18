package com.example.gym.service.implement;

import com.example.gym.dto.request.EquipmentRequest;
import com.example.gym.dto.response.EquipmentResponse;
import com.example.gym.entities.Equipment;
import com.example.gym.mapper.EquipmentMapper;
import com.example.gym.repositories.EquipmentRepository;
import com.example.gym.service.EquipmentService;
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
public class EquipmentServiceImpl implements EquipmentService {
    EquipmentRepository equipmentRepository;
    EquipmentMapper equipmentMapper;

    @Override
    public EquipmentResponse createEquipment(EquipmentRequest request) {
        Equipment equipment = equipmentMapper.toEquipment(request);
        return equipmentMapper.toEquipmentResponse(equipmentRepository.save(equipment));
    }

    @Override
    public EquipmentResponse updateEquipment(EquipmentRequest request, Integer id) {
        Equipment equipment = equipmentRepository
                .findById(id).orElseThrow(()-> new RuntimeException("Equipment not found"));
        equipmentMapper.updateEquipment(equipment, request);
        return equipmentMapper.toEquipmentResponse(equipmentRepository.save(equipment));
    }

    @Override
    public void deleteEquipment(Integer id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public List<EquipmentResponse> getAllEquipment() {
        return equipmentRepository.findAll().stream().map(equipmentMapper::toEquipmentResponse).toList();
    }

    @Override
    public EquipmentResponse getEquipmentById(Integer id) {
        return equipmentMapper.toEquipmentResponse(equipmentRepository
                .findById(id).orElseThrow(()-> new RuntimeException("Equipment not found")));
    }

}
