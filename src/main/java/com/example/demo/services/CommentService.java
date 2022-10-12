package com.example.demo.services;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CommentDto;

public interface CommentService {
    ApiResponse postComment(CommentDto commentDto, Long bugId);

    ApiResponse getComments(Long bugId);
}
