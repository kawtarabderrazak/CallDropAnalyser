package com.example.calldropanalyzer.controller;

import com.example.calldropanalyzer.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins ="http://localhost:8080" )
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    ReportService  reportService ;


    @GetMapping("/callreport")
    public String getCallReport(@RequestParam String startDate , @RequestParam String endDate)
    {

        return  reportService.generateCallReport(startDate,endDate) ;
    }



    @GetMapping("/analysis")
    public Map<String,Object> getCallAnalysisByZone(@RequestParam String startDate, @RequestParam String endDate )    {

        return reportService.getCallAnalysisByZone(startDate,endDate);


    }


}