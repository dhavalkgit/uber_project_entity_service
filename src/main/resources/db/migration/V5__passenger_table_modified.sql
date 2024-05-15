ALTER TABLE passenger ADD last_known_location_id BIGINT NULL,
    ADD rating DOUBLE NOT NULL,
    ADD home_location_id BIGINT NULL,
    ADD active_booking_id BIGINT NULL;

ALTER TABLE passenger ADD CONSTRAINT FK_PASSENGER_ON_ACTIVE_BOOKING
    FOREIGN KEY (active_booking_id) REFERENCES booking (id);

ALTER TABLE passenger ADD CONSTRAINT FK_PASSENGER_ON_HOME_LOCATION
    FOREIGN KEY (home_location_id) REFERENCES exact_location (id);

ALTER TABLE passenger ADD CONSTRAINT FK_PASSENGER_ON_LAST_KNOWN_LOCATION
    FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);