package com.example.gym.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GymResponse {
    Integer id;
    String name;
    String description;
    String location;
    Integer roomNumber;
}
