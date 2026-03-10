package com.preschool.entity;

import jakarta.persistence.*;

@Entity
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String pinCode;
    private String country;
    private String stateDistrict;
    private String city;
    private String location;

    // getters setters

    public Long getId() { return id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getPinCode() { return pinCode; }

    public void setPinCode(String pinCode) { this.pinCode = pinCode; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getStateDistrict() { return stateDistrict; }

    public void setStateDistrict(String stateDistrict) { this.stateDistrict = stateDistrict; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }
}