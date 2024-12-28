package com.example.calldropanalyzer.controller;

import com.example.calldropanalyzer.beans.Zone;
import com.example.calldropanalyzer.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:8080" ) // or "*" if required
@RestController
@RequestMapping("/api/zones")
public class ZoneController {
    @Autowired
    ZoneService zoneService;


    @GetMapping("/getallzones")
    public List<Zone> getAllZones(){

        return zoneService.getAllZones();
    }
}