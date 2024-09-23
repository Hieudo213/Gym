package com.example.gym.entities;

import com.example.gym.entities.enums.TransactionType;

import java.util.Date;

public class Transaction {
    private Integer transactionId;
    private Date date;
    private Double amount;
    private TransactionType type; // Enum for transaction type
    private String receiptNumber;
}
