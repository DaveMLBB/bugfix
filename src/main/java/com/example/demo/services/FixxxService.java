package com.example.demo.services;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.FixxxDto;

public interface FixxxService {
    ApiResponse postFixxx(FixxxDto fixxxDto, Long bugId);

    ApiResponse getIdeasFixxxes(Long bugId);
}
