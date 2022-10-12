package com.example.demo.services.impl;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CommentDto;
import com.example.demo.models.BugReport;
import com.example.demo.models.Comment;
import com.example.demo.repositories.BugRepository;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.services.BugService;
import com.example.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BugRepository bugRepository;


    @Override
    public ApiResponse postComment(CommentDto commentDto, Long bugId) {

        BugReport bugReport = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("bugId not found"));

        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setBugReport(bugReport);

        commentRepository.save(comment);
        ApiResponse apiResponse = new ApiResponse(
                true,
                "comment has been posted",
                commentDto
        );
        return apiResponse;
    }

    @Override
    public ApiResponse getComments(Long bugId) {
        BugReport bugReport = bugRepository.findById(bugId)
                .orElseThrow(()->new RuntimeException("bugId not found"));
        ApiResponse apiResponse = new ApiResponse(
                true,
                "all comments",
                bugReport
        );
        return apiResponse;
    }
}
