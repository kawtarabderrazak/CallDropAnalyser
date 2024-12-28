package com.example.calldropanalyzer.repository;

import com.example.calldropanalyzer.beans.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Zone findByName(String name);
}
