package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.BugReportDTO;
import com.example.demo.services.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/scara")
public class BugController {

    @Autowired
    private BugService bugService;

    @PostMapping("/scara")
    public ResponseEntity<ApiResponse> newReport(@RequestBody BugReportDTO bugReportDTO){

        ApiResponse apiResponse = bugService.transfer(bugReportDTO);

        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.CREATED);

    }

    @GetMapping("/scara")
    public ResponseEntity<List<BugReportDTO>> getReports(){

        List<BugReportDTO> bugReportList = bugService.getBugReportList();


        return new ResponseEntity<List<BugReportDTO>>(bugReportList,HttpStatus.OK);
    }
}
