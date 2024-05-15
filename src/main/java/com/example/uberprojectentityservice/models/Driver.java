package com.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver extends BaseModel{

    private String name;

    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    @Fetch(FetchMode.SUBSELECT)
    List<Booking>bookings;

    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "driver")
    private Car car;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @Column(nullable = false)
    private String activeCity;

    private Boolean isAvailable;

    @DecimalMin(value = "1.00", inclusive = true, message = "rating must be greater then or equal 1.00")
    @DecimalMax(value = "5.00", inclusive = true, message = "rating must be less then or equal 5.00")
    @Column(nullable = false)
    private Double rating;
}
