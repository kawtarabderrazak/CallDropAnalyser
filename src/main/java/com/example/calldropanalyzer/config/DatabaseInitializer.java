package com.example.calldropanalyzer.config;

import com.example.calldropanalyzer.beans.Appel;
import com.example.calldropanalyzer.beans.Zone;
import com.example.calldropanalyzer.repository.AppelRepository;
import com.example.calldropanalyzer.repository.ZoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Autowired
    private AppelRepository appelRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public void run(String... args) {
        logger.info("Initializing database...");
        
        // Create test data if database is empty
        if (zoneRepository.count() == 0) {
            logger.info("Creating test zones...");
            Zone zoneA = new Zone();
            zoneA.setName("Zone A");
            zoneA.setLatitude(33.5731);
            zoneA.setLongitude(-7.5898);
            zoneRepository.save(zoneA);

            Zone zoneB = new Zone();
            zoneB.setName("Zone B");
            zoneB.setLatitude(33.5832);
            zoneB.setLongitude(-7.6032);
            zoneRepository.save(zoneB);

            logger.info("Created {} zones", zoneRepository.count());
        }

        if (appelRepository.count() == 0) {
            logger.info("Creating test calls...");
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Zone zoneA = zoneRepository.findByName("Zone A");
                
                Appel call1 = new Appel();
                call1.setCaller("0612345678");
                call1.setReceiver("0687654321");
                call1.setCallStart(df.parse("2024-12-19 10:00:00"));
                call1.setCallEnd(df.parse("2024-12-19 10:05:00"));
                call1.setDuration(300);
                call1.setInterrupted(true);
                call1.setSignalStrength(65);
                call1.setZone(zoneA);
                appelRepository.save(call1);

                Appel call2 = new Appel();
                call2.setCaller("0623456789");
                call2.setReceiver("0698765432");
                call2.setCallStart(df.parse("2024-12-19 11:00:00"));
                call2.setCallEnd(df.parse("2024-12-19 11:10:00"));
                call2.setDuration(600);
                call2.setInterrupted(false);
                call2.setSignalStrength(85);
                call2.setZone(zoneA);
                appelRepository.save(call2);

                logger.info("Created {} calls", appelRepository.count());
            } catch (Exception e) {
                logger.error("Error creating test data", e);
            }
        }

        // Log database content
        logger.info("Database content:");
        logger.info("Total zones: {}", zoneRepository.count());
        logger.info("Total calls: {}", appelRepository.count());
        
        // Log some sample data
        appelRepository.findAll().forEach(appel -> {
            logger.info("Call: id={}, caller={}, interrupted={}, start={}", 
                appel.getId(), 
                appel.getCaller(), 
                appel.isInterrupted(), 
                appel.getCallStart());
        });
    }
}
