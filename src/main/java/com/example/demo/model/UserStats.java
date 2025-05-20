package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStats {
    private Integer missionsTotal;
    private Double couvertureMoyenneRSRP;
    private Integer connexionsAnalysees;
}

