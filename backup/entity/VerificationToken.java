package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String token;  // Jeton de vérification
    
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;  // Utilisateur lié à ce jeton

    private LocalDateTime expiryDate;  // Date d'expiration du token
    
    // Méthode pour calculer la date d'expiration
    public void setExpiryDate(int minutes) {
        this.expiryDate = LocalDateTime.now().plusMinutes(minutes);
    }
    
    // Getters et Setters
}