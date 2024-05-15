CREATE TABLE booking (
  id BIGINT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime NOT NULL,
   start_time datetime NULL,
   end_time datetime NULL,
   total_distance BIGINT NULL,
   booking_status ENUM ('pending','cancelled','successes','arrived')  NULL,
   review_id BIGINT NULL,
   passenger_id BIGINT NULL,
   driver_id BIGINT NULL,
   CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE driver (
  id BIGINT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime NOT NULL,
   name VARCHAR(255) NULL,
   phone_number VARCHAR(255) NULL,
   license_number VARCHAR(255) NOT NULL,
   CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE passenger (
  id BIGINT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime NOT NULL,
   name VARCHAR(255) NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NULL,
   phone_number VARCHAR(255) NOT NULL,
   CONSTRAINT pk_passenger PRIMARY KEY (id)
);

CREATE TABLE passenger_review (
  id BIGINT NOT NULL,
   passenger_review_content VARCHAR(255) NOT NULL,
   passenger_rating DOUBLE NOT NULL,
   CONSTRAINT pk_passengerreview PRIMARY KEY (id)
);

CREATE TABLE booking_review (
  id BIGINT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime NOT NULL,
   content VARCHAR(255) NOT NULL,
   rating DOUBLE NOT NULL,
   CONSTRAINT pk_booking_review PRIMARY KEY (id)
);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_REVIEW FOREIGN KEY (review_id) REFERENCES booking_review (id);

ALTER TABLE passenger_review ADD CONSTRAINT FK_PASSENGERREVIEW_ON_ID FOREIGN KEY (id) REFERENCES booking_review (id);

ALTER TABLE driver ADD CONSTRAINT uc_driver_license_number UNIQUE (license_number);

ALTER TABLE passenger ADD CONSTRAINT uc_passenger_email UNIQUE (email);

ALTER TABLE passenger ADD CONSTRAINT uc_passenger_phone_number UNIQUE (phone_number);