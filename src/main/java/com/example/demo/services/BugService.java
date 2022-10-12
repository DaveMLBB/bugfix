package com.example.demo.services;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.BugReportDTO;

import java.util.List;

public interface BugService {
    ApiResponse transfer(BugReportDTO bugReportDTO);

    List<BugReportDTO> getBugReportList();
}
