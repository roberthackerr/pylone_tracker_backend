package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String roleName;
    private String email;
    private String username;
    private String password;
    private String avatar;
    private LocalDate dateNaissance;
    private LocalDate dateEntree;
    private String localisation;
    private Double salaire;
    private String prochainMission;
    private String idAgent;
    @Embedded
    UserStats userStats;    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Token> tokens = new ArrayList<>();
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
