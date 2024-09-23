package com.example.gym.entities;

import com.example.gym.entities.enums.EquipmentStatus;

import java.util.Date;

public class Equipment {
    private Integer equipmentId;
    private String name;
    private String serialNumber;
    private Integer quantity;
    private Date dateOfPurchase;
    private Date warrantyDate;
    private String origin;
    private EquipmentStatus status;
}
