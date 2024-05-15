package com.example.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OTP extends BaseModel{

    private Integer code;

    private String sentToNumber;

    public static OTP generateOTP(String phoneNumber){
        // Create an instance of the Random class
        Random random = new Random();

        // Generate a random number between 1000 and 9999
        Integer randomNumber = 1000 + random.nextInt(9000);

        return OTP.builder()
                .code(randomNumber)
                .sentToNumber(phoneNumber)
                .build();
    }
}
