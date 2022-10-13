package com.example.demo.services.impl;

import com.example.demo.models.Admin;
import com.example.demo.models.BugReport;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MailNotificationService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BugRepository bugRepository;
    public void sendEmail(Long id) {

        Optional<BugReport> bugReport = bugRepository.findById(id);

        List<Admin> adminList = adminRepository.findAll();

        for (Admin admin: adminList) {

            SimpleMailMessage sms = new SimpleMailMessage();
            sms.setTo(admin.getMail());
            sms.setFrom("devtestdevtest828117@tiscali.it");
            sms.setReplyTo("devtestdevtest828117@tiscali.it");
            sms.setSubject("FIX");
            sms.setText("Fix:" + bugReport.get() );
            mailSender.send(sms);

        }
    }
}
