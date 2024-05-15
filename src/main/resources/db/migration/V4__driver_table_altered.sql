ALTER TABLE driver ADD driver_status ENUM('APPROVED', 'PENDING', 'FAILED') NULL;
ALTER TABLE driver ADD active_city VARCHAR(255) NOT NULL;
ALTER TABLE driver ADD last_known_location_id BIGINT NULL;
ALTER TABLE driver ADD is_available BIT(1) NULL;
ALTER TABLE driver ADD rating DOUBLE NOT NULL;

ALTER TABLE driver ADD CONSTRAINT FK_DRIVER_ON_LAST_KNOWN_LOCATION
    FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);

ALTER TABLE driver
    ADD CONSTRAINT check_rating CHECK ( driver.rating >= 1 AND driver.rating <=5);