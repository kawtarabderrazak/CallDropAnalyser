package com.example.calldropanalyzer.controller;


import com.example.calldropanalyzer.beans.CallDropStats;
import com.example.calldropanalyzer.service.CallDropService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CallDropController {

    @Autowired
    private CallDropService callDropService;
    @GetMapping("/stats/zone")
    public List<CallDropStats> getStatsByZone(@RequestParam String zone) {
        return callDropService.getCallDropStatsByZone(zone);
    }
    @GetMapping("/by-hour")
public List<CallDropStats> getStatsByHour(@RequestParam int hour) {
    return callDropService.getCallDropStatsBySpecificHour(hour);
}
}
