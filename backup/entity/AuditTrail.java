package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AuditTrail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String action;  // Ex: "User Registered", "Password Changed", etc.
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Utilisateur ayant effectué l'action

    private LocalDateTime actionTime;  // Date et heure de l'action

    public AuditTrail(String action, User user, LocalDateTime actionTime) {
        this.action = action;
        this.user = user;
        this.actionTime = actionTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }
    
    // Getters et Setters
}
