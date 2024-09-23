package com.example.gym.entities;

import com.example.gym.entities.enums.StaffRole;
import com.example.gym.entities.enums.StaffStatus;

import java.util.Date;

public class Staff {
    private Integer staffId;
    private String name;
    private StaffRole role; // Enum for staff role
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private StaffStatus status;
}
