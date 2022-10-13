package com.example.demo.services.impl;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.FixxxDto;
import com.example.demo.models.BugReport;
import com.example.demo.models.Comment;
import com.example.demo.models.Fixxx;
import com.example.demo.repositories.BugRepository;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.FixxxRepository;
import com.example.demo.services.FixxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FixxxServiceImpl implements FixxxService {
    @Autowired
    private FixxxRepository fixxxRepository;
    @Autowired
    private BugRepository bugRepository;


    @Override
    public ApiResponse postFixxx(FixxxDto fixxxDto, Long bugId) {

        BugReport bugReport = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("bugId not found"));

        if (bugReport.getFixAccepted()) throw new RuntimeException("bug fixed");

        Fixxx fixxx = new Fixxx();
        fixxx.setIdeaFix(fixxxDto.getFixxx());
        fixxx.setBugReport(bugReport);
        fixxxRepository.save(fixxx);
        ApiResponse apiResponse = new ApiResponse(
                true,
                "comment has been posted",
                bugReport
        );
        return apiResponse;
    }

    @Override
    public ApiResponse getIdeasFixxxes(Long bugId) {
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
