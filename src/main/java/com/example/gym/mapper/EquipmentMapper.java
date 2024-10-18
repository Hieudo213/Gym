package com.example.gym.mapper;

import com.example.gym.dto.request.EquipmentRequest;
import com.example.gym.dto.request.GymRequest;
import com.example.gym.dto.response.EquipmentResponse;
import com.example.gym.dto.response.GymResponse;
import com.example.gym.entities.Equipment;
import com.example.gym.entities.Gym;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class EquipmentMapper {
    public Equipment toEquipment(EquipmentRequest request) {
        if (request == null) {
            return null;
        } else {
            Equipment.EquipmentBuilder equipment = Equipment.builder();
            equipment.name(request.getName());
            equipment.serialNumber(request.getSerialNumber());
            equipment.quantity(request.getQuantity());
            // Ngày mua
            LocalDate purchaseDate = LocalDate.now();
            equipment.dateOfPurchase(Date.from(purchaseDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            // Ngày bảo hành là 6 tháng sau ngày mua
            LocalDate warrantyDate = purchaseDate.plusMonths(6);
            equipment.warrantyDate(Date.from(warrantyDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            equipment.origin(request.getOrigin());
            equipment.status(request.getStatus());
            return equipment.build();
        }
    }

    public EquipmentResponse toEquipmentResponse(Equipment equipment) {
        if (equipment == null) {
            return null;
        } else {
            EquipmentResponse.EquipmentResponseBuilder response = EquipmentResponse.builder();
            response.id(equipment.getId());
            response.name(equipment.getName());
            response.serialNumber(equipment.getSerialNumber());
            response.quantity(equipment.getQuantity());
            response.dateOfPurchase(equipment.getDateOfPurchase());
            response.warrantyDate(equipment.getWarrantyDate());
            response.origin(equipment.getOrigin());
            response.status(equipment.getStatus());
            return response.build();
        }
    }

    public void updateEquipment(Equipment equipment, EquipmentRequest request) {
        if (request != null) {
           equipment.setName(request.getName());
           equipment.setSerialNumber(request.getSerialNumber());
           equipment.setQuantity(request.getQuantity());
           equipment.setOrigin(request.getOrigin());
           equipment.setStatus(request.getStatus());
        }
    }
}
