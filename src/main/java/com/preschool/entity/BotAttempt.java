package com.preschool.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BotAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;

    private Double captchaScore;

    @Column(columnDefinition="TEXT")
    private String formData;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }

    public String getIpAddress() { return ipAddress; }

    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public Double getCaptchaScore() { return captchaScore; }

    public void setCaptchaScore(Double captchaScore) { this.captchaScore = captchaScore; }

    public String getFormData() { return formData; }

    public void setFormData(String formData) { this.formData = formData; }

    public LocalDateTime getCreatedAt() { return createdAt; }

}