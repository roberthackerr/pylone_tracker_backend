package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.User;

public class UserDTO {
    private String idAgent;
    public String getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(String idAgent) {
        this.idAgent = idAgent;
    }

    private Integer id;
    private String nom;
    private String email;
    private String avatar;
    private String roleName;
    private String localisation;
    private LocalDate dateNaissance;
    private LocalDate dateEntree;
    private Double salaire;
    private String prochainMission;
    private UserStats userStats;
    public UserStats getUserStats() {
        return userStats;
    }

    public void setUserStats(UserStats userStats) {
        this.userStats = userStats;
    }

    public List<Token> getToken() {
        return token;
    }

    public void setToken(List<Token> token) {
        this.token = token;
    }

    private List<Token> token;

    // You can add stats or nested fields as needed

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public LocalDate getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(LocalDate dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public String getProchainMission() {
        return prochainMission;
    }

    public void setProchainMission(String prochainMission) {
        this.prochainMission = prochainMission;
    }

    public UserDTO(User user) {
        this.idAgent=user.getIdAgent();
        this.id = user.getId();
        this.nom = user.getNom();
        this.email = user.getEmail();
        this.avatar = user.getAvatar();
        this.roleName = user.getRoleName();
        this.localisation = user.getLocalisation();
        this.dateNaissance = user.getDateNaissance();
        this.dateEntree = user.getDateEntree();
        this.salaire = user.getSalaire();
        this.prochainMission = user.getProchainMission();
        this.token=user.getTokens();
        this.userStats=user.getUserStats();
        // Add any additional fields here (except password)
    }

    // Getters and setters
}
