package com.example.gym.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GymRequest {
    String name;
    String description;
    String location;
    Integer roomNumber;
}
