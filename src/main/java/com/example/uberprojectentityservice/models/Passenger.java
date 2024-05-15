package com.example.uberprojectentityservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger extends BaseModel{

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @DecimalMin(value = "1.00", inclusive = true, message = "rating must be greater then or equal 1.00")
    @DecimalMax(value = "5.00", inclusive = true, message = "rating must be less then or equal 5.00")
    @Column(nullable = false)
    private Double rating;

    @OneToOne
    private ExactLocation homeLocation;

    @OneToOne
    private Booking activeBooking;
}