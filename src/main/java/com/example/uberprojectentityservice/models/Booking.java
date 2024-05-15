package com.example.uberprojectentityservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends BaseModel {

    private Date startTime;

    private Date endTime;

    private Long totalDistance;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToOne(fetch = FetchType.LAZY)
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Driver driver;
}