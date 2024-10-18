package com.example.gym.dto.request;

import com.example.gym.entities.enums.EquipmentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipmentRequest {
    String name;
    String serialNumber;
    Integer quantity;
    String origin;
    EquipmentStatus status;
}
