package com.example.calldropanalyzer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.calldropanalyzer.beans.CallDropStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CallDropRepository extends JpaRepository<CallDropStats, Long> {

    // Trouver les statistiques d'appels interrompus par zone
    List<CallDropStats> findCallDropStatsByZone(String zone);

    // Trouver les appels interrompus à une heure précise
    @Query("SELECT c FROM CallDropStats c WHERE HOUR(c.timestamp) = :hour")
    List<CallDropStats> findCallDropStatsByHour(@Param("hour") int hour);

    // Statistiques groupées par heure
    @Query("SELECT HOUR(c.timestamp) as hour, COUNT(c) as count " +
           "FROM CallDropStats c " +
           "WHERE c.callDropped = true " +
           "GROUP BY HOUR(c.timestamp)")
    List<Object[]> findCallDropStatsGroupedByHour();
}
