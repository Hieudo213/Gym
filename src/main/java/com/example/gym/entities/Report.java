package com.example.gym.entities;

import com.example.gym.entities.enums.ReportType;

public class Report {
    private Integer reportId;
    private ReportType reportType; // Enum for report type
    private String dateRange; // E.g., "01/01/2024 - 31/12/2024"
    private String content;
}
