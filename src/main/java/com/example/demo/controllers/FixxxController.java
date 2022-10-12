package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.FixxxDto;
import com.example.demo.services.CommentService;
import com.example.demo.services.FixxxService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scara/scara")
public class FixxxController {
    @Autowired
    private FixxxService fixxxService;

    @PostMapping("/{bugId}/faggifix")
    public ResponseEntity<ApiResponse> postFixxx(@RequestBody FixxxDto fixxxDto,
                                                   @PathVariable Long bugId){

        ApiResponse apiResponse = fixxxService.postFixxx(fixxxDto, bugId);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{bugId}/faggifix")
    public ResponseEntity<ApiResponse> getFixxxes(@PathVariable Long bugId){
        ApiResponse apiResponse = fixxxService.getIdeasFixxxes(bugId);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
}
