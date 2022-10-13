package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.GoFixBaby;
import com.example.demo.filters.AdminInterceptor;
import com.example.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AdminControl extends AdminInterceptor {

    @Autowired
    private AuthService authService;
    @PostMapping("/go")
    public ResponseEntity<ApiResponse> goFixBaby(@RequestBody GoFixBaby goFixBaby, HttpServletRequest request){
        ApiResponse apiResponse = authService.goFixBaby(goFixBaby);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
