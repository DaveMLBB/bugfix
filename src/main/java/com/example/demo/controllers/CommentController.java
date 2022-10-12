package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CommentDto;
import com.example.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scara/scara")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{bugId}/faggi")
    public ResponseEntity<ApiResponse> postComment(@RequestBody CommentDto commentDto,
                                                   @PathVariable Long bugId){

        ApiResponse apiResponse = commentService.postComment(commentDto, bugId);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{bugId}/faggi")
    public ResponseEntity<ApiResponse> getComments(@PathVariable Long bugId){
        ApiResponse apiResponse = commentService.getComments(bugId);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
}
