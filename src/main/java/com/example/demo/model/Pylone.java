package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Pylone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @jakarta.validation.constraints.NotNull
    private String name;

    private String description;

    private String place;
    
    private Double latitude;
    
    private Double longitude;
    
    private Double rsrp;
    
    private Double rsrq;
    
    private String photo;  // This would be the URL of the uploaded photo

    // Getters and Setters
}
