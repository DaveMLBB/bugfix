package com.example.demo.services.impl;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.GoFixBaby;
import com.example.demo.models.BugReport;
import com.example.demo.models.Fixxx;
import com.example.demo.repositories.BugRepository;
import com.example.demo.repositories.FixxxRepository;
import com.example.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceimpl implements AuthService {
    @Autowired
    private FixxxRepository fixxxRepository;
    @Autowired
    private BugRepository bugRepository;
    @Autowired
    private MailNotificationService mailNotificationService;

    @Override
    public ApiResponse goFixBaby(GoFixBaby goFixBaby) {

        Fixxx fixxx = fixxxRepository.findById(goFixBaby.getFixId())
                .orElseThrow(()->new RuntimeException("fix id not found"));

        BugReport bugReportIfAccepted = bugRepository.findById(goFixBaby.getBugId())
                .orElseThrow(()->new RuntimeException("bug id not found"));

        if (bugReportIfAccepted.getFixAccepted()) throw new RuntimeException("bug fixed");

        BugReport bugReport = bugRepository.findById(goFixBaby.getBugId())
                .orElseThrow(()-> new RuntimeException("bug id not found"));
        Integer fixUp = fixxx.getGoFix();
        fixxx.setGoFix(++fixUp);

        if (fixxx.getGoFix() == 3) {
            mailNotificationService.sendEmail(goFixBaby.getBugId());
            fixxx.setAccepted(true);
        }

        fixxxRepository.save(fixxx);

        if (fixxx.getAccepted()) {
            bugReport.setFixAccepted(true);
            bugRepository.save(bugReport);
        }
        ApiResponse apiResponse = new ApiResponse(
                true,
                "fix updated",
                bugReport
        );
        return apiResponse;
    }
}
