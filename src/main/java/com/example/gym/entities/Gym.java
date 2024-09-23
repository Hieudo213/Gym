package com.example.gym.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gym {
    private Integer gymId;
    private String name;
    private String location;
    private String description;
    private Integer roomNumber;

}
