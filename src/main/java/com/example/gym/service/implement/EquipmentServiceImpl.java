package com.example.gym.service.implement;

import com.example.gym.dto.request.EquipmentRequest;
import com.example.gym.dto.response.EquipmentResponse;
import com.example.gym.entities.Equipment;
import com.example.gym.entities.Gym;
import com.example.gym.exception.ApplicationException;
import com.example.gym.exception.ErrorCode;
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
                .findById(id).orElseThrow(()-> new ApplicationException(ErrorCode.ITEM_NOT_FOUND));
        equipmentMapper.updateEquipment(equipment, request);
        return equipmentMapper.toEquipmentResponse(equipmentRepository.save(equipment));
    }

    @Override
    public void deleteEquipment(Integer id) {
        equipmentRepository
                .findById(id).orElseThrow(()-> new ApplicationException(ErrorCode.ITEM_NOT_FOUND));
        equipmentRepository.deleteById(id);
    }

    @Override
    public List<EquipmentResponse> getAllEquipment() {
        List<Equipment> equipments = equipmentRepository.findAll();

        if (equipments.isEmpty()) {
            throw new ApplicationException(ErrorCode.LIST_EMPTY);
        }

        return equipments.stream()
                .map(equipmentMapper::toEquipmentResponse)
                .toList();
    }

    @Override
    public EquipmentResponse getEquipmentById(Integer id) {
        return equipmentMapper.toEquipmentResponse(equipmentRepository
                .findById(id).orElseThrow(()-> new ApplicationException(ErrorCode.ITEM_NOT_FOUND)));
    }

}
