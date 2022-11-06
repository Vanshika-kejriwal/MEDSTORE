package com.medicalstore.medicalstore.web.dto;

public class Address {
    private String mobile_no;
    private String house_no;
    private String street;
    private String city;
    private int pincode;
    private String state;
    
    public Address(String mobile_no, String house_no, String street, String city, int pincode, String state) {
        this.mobile_no = mobile_no;
        this.house_no = house_no;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }
    
    public Address() {
    }

    public String getMobile_no() {
        return mobile_no;
    }
    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    public String getHouse_no() {
        return house_no;
    }
    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getPincode() {
        return pincode;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
