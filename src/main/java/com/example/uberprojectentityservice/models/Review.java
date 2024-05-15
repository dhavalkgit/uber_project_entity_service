package com.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "booking_review")
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private double rating;

    @OneToOne(mappedBy = "review")
    private Booking booking;
}
