package com.example.companyapp.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;
    private String owner;

    @Column(updatable = false)
    private Instant createdAt = Instant.now();

    // Getters and Setters
    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public Instant getCreatedAt() { return createdAt; }
}

