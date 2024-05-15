package com.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car extends BaseModel{
    @Column(unique = true, nullable = false)
    private String plateNumber;

    private String brand;

    private String model;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Color color;

    @OneToOne
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private CarType carType;
}
