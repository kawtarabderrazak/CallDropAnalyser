package com.example.calldropanalyzer.service;

import com.example.calldropanalyzer.beans.Zone;
import com.example.calldropanalyzer.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {
    @Autowired
    private ZoneRepository zoneRepository;

    public List<Zone> getAllZones() {

        return zoneRepository.findAll();
    }
}