package com.example.demo.dto;

import com.example.demo.models.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

    private Boolean state;
    private Boolean message;
    private Comment comment;
}
