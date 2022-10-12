package com.example.demo.dto;

import com.example.demo.models.BugReport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiResponse {

    private Boolean state;
    private String message;
    private Object bugReport;


    public ApiResponse(Boolean state, String message, Object bugReport) {
        this.state = state;
        this.message = message;
        this.bugReport = bugReport;
    }
}
