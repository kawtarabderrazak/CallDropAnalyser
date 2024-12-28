-- Insert test zones
INSERT INTO zone (name, latitude, longitude) VALUES
('Zone A', 33.5731, -7.5898),
('Zone B', 33.5832, -7.6032),
('Zone C', 33.5933, -7.6166);

-- Insert test calls (some interrupted, some not)
INSERT INTO appel (caller, receiver, call_start, call_end, duration, interrupted, signal_strength, zone_id) VALUES
('0612345678', '0687654321', '2024-12-19 10:00:00', '2024-12-19 10:05:00', 300, true, 65, 1),
('0623456789', '0698765432', '2024-12-19 11:00:00', '2024-12-19 11:10:00', 600, false, 85, 2),
('0634567890', '0609876543', '2024-12-19 12:00:00', '2024-12-19 12:02:00', 120, true, 45, 1),
('0645678901', '0610987654', '2024-12-19 13:00:00', '2024-12-19 13:15:00', 900, false, 90, 3),
('0656789012', '0621098765', '2024-12-19 14:00:00', '2024-12-19 14:01:00', 60, true, 35, 2);
