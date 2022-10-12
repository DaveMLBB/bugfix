package com.example.demo.services.impl;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.BugReportDTO;
import com.example.demo.models.BugReport;
import com.example.demo.repositories.BugRepository;
import com.example.demo.services.BugService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugRepository bugRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ApiResponse transfer(BugReportDTO bugReportDTO) {

        BugReport bugReport = new BugReport();
        bugReport.setReportContent(bugReportDTO.getReportContent());
        bugRepository.save(bugReport);

        ApiResponse apiResponse = new ApiResponse(
                true,
                "bug has been posted",
                bugReport
        );

        return apiResponse;
    }

    @Override
    public List<BugReportDTO> getBugReportList() {

        List<BugReport> bugReportList = bugRepository.findAll();
        List<BugReportDTO> bugReportDTOList = modelMapper.map(
                bugReportList, new TypeToken<List<BugReportDTO>>() {}.getType()
        );

        return bugReportDTOList;

    }
}
