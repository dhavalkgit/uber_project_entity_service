CREATE TABLE otp (
  id BIGINT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime NOT NULL,
   code INT NULL,
   sent_to_number VARCHAR(255) NULL,
   CONSTRAINT pk_otp PRIMARY KEY (id)
);

CREATE TABLE exact_location (
  id BIGINT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime NOT NULL,
   longitude DOUBLE NULL,
   latitude DOUBLE NULL,
   CONSTRAINT pk_exactlocation PRIMARY KEY (id)
);

CREATE TABLE named_location (
  id BIGINT NOT NULL,
   created_at datetime NOT NULL,
   updated_at datetime NOT NULL,
   city VARCHAR(255) NULL,
   state VARCHAR(255) NULL,
   country VARCHAR(255) NULL,
   zipcode BIGINT NULL,
   area VARCHAR(255) NULL,
   exact_location_id BIGINT NULL,
   CONSTRAINT pk_namedlocation PRIMARY KEY (id)
);

ALTER TABLE named_location ADD CONSTRAINT FK_NAMEDLOCATION_ON_EXACT_LOCATION FOREIGN KEY (exact_location_id) REFERENCES exact_location (id);
