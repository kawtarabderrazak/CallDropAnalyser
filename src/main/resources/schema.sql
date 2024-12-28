-- Drop tables if they exist
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS appel;
DROP TABLE IF EXISTS zone;
SET FOREIGN_KEY_CHECKS = 1;

-- Create tables
CREATE TABLE zone (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    latitude DOUBLE,
    longitude DOUBLE
);

CREATE TABLE appel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    caller VARCHAR(255),
    receiver VARCHAR(255),
    call_start TIMESTAMP,
    call_end TIMESTAMP,
    duration INT,
    interrupted BOOLEAN,
    signal_strength INT,
    zone_id BIGINT,
    FOREIGN KEY (zone_id) REFERENCES zone(id)
);
