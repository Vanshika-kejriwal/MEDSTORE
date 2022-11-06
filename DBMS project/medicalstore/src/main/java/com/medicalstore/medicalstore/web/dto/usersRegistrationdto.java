package com.medicalstore.medicalstore.web.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class usersRegistrationdto {
    private String username;//
    private String password;//
    private String confirm_password;//
    private String role;
    private String Name; ///
    private String mobile_no;//
    private String gender;//
    private String aadhar_no;///
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;//
    private String email;//
    private String house_no;//
    private String street;//
    private String city;//
    private int pincode;//
    private String state;//

    
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAadhar_no(String aadhar_no) {
        this.aadhar_no = aadhar_no;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getMobile_no() {
        return mobile_no;
    }
    public String getGender() {
        return gender;
    }
    public String getAadhar_no() {
        return aadhar_no;
    }
    public Date getDob() {
        return dob;
    }
    public String getEmail() {
        return email;
    }
    public String getHouse_no() {
        return house_no;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public int getPincode() {
        return pincode;
    }
    public String getState() {
        return state;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }

    public usersRegistrationdto() {
    }
    public usersRegistrationdto(String username, String password, String role, String name, String mobile_no,
            String gender, String aadhar_no, Date dob, String email, String house_no, String street, String city,
            int pincode, String state) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.Name = name;
        this.mobile_no = mobile_no;
        this.gender = gender;
        this.aadhar_no = aadhar_no;
        this.dob = dob;
        this.email = email;
        this.house_no = house_no;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }
    public String getConfirm_password() {
        return confirm_password;
    }
    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
    
}
