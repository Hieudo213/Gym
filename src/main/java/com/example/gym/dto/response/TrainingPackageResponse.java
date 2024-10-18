package com.example.gym.dto.response;

import com.example.gym.entities.enums.PackageType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrainingPackageResponse {
    Integer id;
    String name;
    String duration;
    String price;
    PackageType type;
    String description;
}
