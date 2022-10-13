package com.example.demo.services;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.GoFixBaby;

public interface AuthService {
    ApiResponse goFixBaby(GoFixBaby goFixBaby);
}
