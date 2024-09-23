package com.example.gym.entities;

import com.example.gym.entities.enums.PackageType;

public class TrainingPackage {
    private Integer packageId;
    private String name;
    private String duration; // E.g., "3 months", "1 year"
    private Double price;
    private PackageType type; // Enum for package type
    private String description;
}
