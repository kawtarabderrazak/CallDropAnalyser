package com.example.calldropanalyzer.controller;

import com.example.calldropanalyzer.beans.Appel;
import com.example.calldropanalyzer.service.AppelService;
import com.example.calldropanalyzer.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins ="http://localhost:8080" )
@RestController
@RequestMapping("/api/appels")
public class AppelController {

    @Autowired
    private AppelService appelService;
    @Autowired
    private ReportService reportService;
    @GetMapping("/interrupted")
    public List<Appel> getAppelsInterrompus(@RequestParam String startDate,
                                            @RequestParam String endDate)  {
        return appelService.getAppelsInterrompus(startDate, endDate);
    }

    @GetMapping("/getallcalls")
    public List<Appel> getAllAppels() {
        return appelService.getAllCalls();
    }


    @GetMapping("/getallinterruptedcalls") // using for tests
    public  List<Appel> getAllInterruptedCalls()  {
        return appelService.getAppelsInterrompus(new Date(124,1,1).toString(), new Date().toString());
    }

    @GetMapping("/noninterrupted")
    public   List<Appel>   getAppelsNonInterrompus(@RequestParam String startDate,@RequestParam String endDate){

        return  appelService.getAppelsNonInterrompus(startDate,endDate);
    }

    @GetMapping("/analysis")  // test to a new implemented types
    public  Map<String, Object> getCallAnalysisByZone( @RequestParam String startDate, @RequestParam String endDate  ){ return reportService.getCallAnalysisByZone(startDate,endDate); }

}