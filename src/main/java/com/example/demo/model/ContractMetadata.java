package com.example.demo.model;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContractMetadata {
    
    @Column(name = "client_name", nullable = false)
    private String clientName;
    
    @Column(name = "client_email", nullable = false)
    private String clientEmail;
    
    @Column(name = "client_phone", nullable = false)
    private String clientPhone;
    
    @Column(name = "contract_type", nullable = false)
    private String contractType;
    
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String terms;
    
    @Column(name = "special_conditions", columnDefinition = "TEXT")
    private String specialConditions;
    
    @Column(name = "payment_terms", nullable = false)
    private String paymentTerms;
    
    @Column(name = "service_description", columnDefinition = "TEXT", nullable = false)
    private String serviceDescription;
    
    // Getters and setters
}