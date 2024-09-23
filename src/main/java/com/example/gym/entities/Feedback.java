package com.example.gym.entities;

import com.example.gym.entities.enums.FeedbackType;

import java.util.Date;

public class Feedback {
    private int feedbackId;
    private FeedbackType feedbackType; // Enum for feedback type
    private String content;
    private Date date;
}
