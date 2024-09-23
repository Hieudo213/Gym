package com.example.gym.entities;

import com.example.gym.entities.enums.UserRole;

public class AccessControl {
    private Integer accessId;
    private UserRole role; // Enum for user role
    private String permissions;
}
