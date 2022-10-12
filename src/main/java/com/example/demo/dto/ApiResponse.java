package com.example.demo.dto;

import com.example.demo.models.BugReport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private Boolean state;
    private String message;
    private BugReport bugReport;

}
