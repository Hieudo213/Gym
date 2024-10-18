package com.example.gym.dto.response;

import com.example.gym.entities.enums.EquipmentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipmentResponse {
    Integer id;
    String name;
    String serialNumber;
    Integer quantity;
    Date dateOfPurchase;
    Date warrantyDate;
    String origin;
    EquipmentStatus status;
}
