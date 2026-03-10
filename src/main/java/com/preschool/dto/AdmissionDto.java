package com.preschool.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AdmissionDto {

    @NotBlank(message="First Name is required")
    private String firstName;

    @NotBlank(message="Last Name is required")
    private String lastName;

    @Email(message="Enter valid email")
    @NotBlank(message="Email is required")
    private String email;

    @NotBlank(message="Mobile is required")
    private String mobile;

    @NotBlank(message="Pin Code is required")
    private String pinCode;

    @NotBlank(message="Country is required")
    private String country;

    @NotBlank(message="State/District is required")
    private String stateDistrict;

    @NotBlank(message="City is required")
    private String city;

    @NotBlank(message="Location is required")
    private String location;

    private String captcha;
    
    private String preschooloratricskidzz;

    // getters setters

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

    public String getCaptcha() { return captcha; }

    public void setCaptcha(String captcha) { this.captcha = captcha; }

	public String getPreschooloratricskidzz() {
		return preschooloratricskidzz;
	}

	public void setPreschooloratricskidzz(String preschooloratricskidzz) {
		this.preschooloratricskidzz = preschooloratricskidzz;
	}

	
    
    
}