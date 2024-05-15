package com.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    protected Long id;

    @Column(nullable = false)
    @CreationTimestamp
    protected Date createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    protected Date updatedAt;
}
