package com.example.calldropanalyzer.service;

import com.example.calldropanalyzer.beans.CallDropStats;
import com.example.calldropanalyzer.repository.CallDropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallDropService {

    @Autowired
    private CallDropRepository callDropRepository;

    /**
     * Récupère les statistiques d'appels interrompus pour une zone donnée.
     * 
     * @param zone Nom de la zone.
     * @return Liste des statistiques d'appels pour la zone.
     */
    public List<CallDropStats> getCallDropStatsByZone(String zone) {
        return callDropRepository.findCallDropStatsByZone(zone);
    }

    /**
     * Récupère les statistiques des appels groupées par heure.
     * 
     * @return Liste des statistiques groupées par heure.
     */
    public List<CallDropStats> getCallDropStatsBySpecificHour(int hour) {
        return callDropRepository.findCallDropStatsByHour(hour);
    }
    
}
