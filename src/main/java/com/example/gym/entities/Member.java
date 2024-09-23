package com.example.gym.entities;

import com.example.gym.entities.enums.MembershipType;

import java.util.Date;

public class Member {
    private Integer memberId;
    private String fullName;
    private Integer age;
    private String occupation;
    private Date birthday;
    private MembershipType membershipType; // Enum for membership type
    private String fingerprintId;
    private Date registrationDate;
    private String email;
    private String phoneNumber;
}
