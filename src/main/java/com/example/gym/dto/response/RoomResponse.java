package com.example.gym.dto.response;

import com.example.gym.entities.enums.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomResponse {
    Integer id;
    String name;
    Integer capacity;
    RoomType roomType;
    String description;
}
