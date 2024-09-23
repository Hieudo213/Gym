package com.example.gym.entities;

import com.example.gym.entities.enums.MembershipPlan;
import com.example.gym.entities.enums.MembershipStatus;

import java.util.Date;

public class Membership {
    private Integer membershipId;
    private Date registrationDate;
    private MembershipPlan membershipPlan; // Enum for membership plan
    private MembershipStatus status; // Enum for membership status
    private String history;
}
