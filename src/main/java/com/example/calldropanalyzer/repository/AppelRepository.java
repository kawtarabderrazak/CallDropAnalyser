package com.example.calldropanalyzer.repository;

import com.example.calldropanalyzer.beans.Appel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface AppelRepository extends JpaRepository<Appel,Long> {

    @Query(value = "SELECT * FROM appel WHERE call_start BETWEEN :start AND :end AND interrupted = true", nativeQuery = true)
    List<Appel> findByCallStartBetweenAndInterrupted(@Param("start") Date start, @Param("end") Date end);
    List<Appel> findByCallStartBetweenAndInterrupted( Date startDate,  Date endDate,  boolean interrupted ) ;

    @Query(value = "SELECT a.* FROM appel a " +
            "LEFT JOIN zone z ON a.zone_id = z.id " +
            "WHERE a.interrupted = true " +
            "AND a.call_start BETWEEN :start AND :end", nativeQuery = true)
    List<Appel> findInterruptedCallsWithZoneDetails(@Param("start") Timestamp start, @Param("end") Timestamp end);
}