package com.example.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NamedLocation extends BaseModel{

    private String city;

    private String state;

    private String country;

    private Long zipcode;

    private String area;

    @OneToOne
    private ExactLocation exactLocation;
}
