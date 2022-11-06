package com.medicalstore.medicalstore.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
    private int idcustomer;
    private String username;
    private String customer_sex;
    private String customer_ph_no;
    private String customer_aadhar_no;
    private String customer_state;
    private String customer_street;
    private String customer_city;
    private int customer_pincode;
    private String customer_house_no;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customer_dob;
    
    public Customer(String username, String customer_sex, String customer_ph_no,
            String customer_aadhar_no, String customer_state, String customer_street, String customer_city,
            int customer_pincode, String customer_house_no, Date customer_dob) {
        this.username = username;
        this.customer_sex = customer_sex;
        this.customer_ph_no = customer_ph_no;
        this.customer_aadhar_no = customer_aadhar_no;
        this.customer_state = customer_state;
        this.customer_street = customer_street;
        this.customer_city = customer_city;
        this.customer_pincode = customer_pincode;
        this.customer_house_no = customer_house_no;
        this.customer_dob = customer_dob;
    }

    public Customer() {
    }

    public Date getCustomer_dob() {
        return customer_dob;
    }
    public void setCustomer_dob(Date customer_dob) {
        this.customer_dob = customer_dob;
    }

    public int getIdcustomer() {
        return idcustomer;
    }
    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getCustomer_sex() {
        return customer_sex;
    }
    public void setCustomer_sex(String customer_sex) {
        this.customer_sex = customer_sex;
    }
    public String getCustomer_ph_no() {
        return customer_ph_no;
    }
    public void setCustomer_ph_no(String customer_ph_no) {
        this.customer_ph_no = customer_ph_no;
    }
    public String getCustomer_aadhar_no() {
        return customer_aadhar_no;
    }
    public void setCustomer_aadhar_no(String customer_aadhar_no) {
        this.customer_aadhar_no = customer_aadhar_no;
    }
    public String getCustomer_state() {
        return customer_state;
    }
    public void setCustomer_state(String customer_state) {
        this.customer_state = customer_state;
    }
    public String getCustomer_street() {
        return customer_street;
    }
    public void setCustomer_street(String customer_street) {
        this.customer_street = customer_street;
    }
    public String getCustomer_city() {
        return customer_city;
    }
    public void setCustomer_city(String customer_city) {
        this.customer_city = customer_city;
    }
    public int getCustomer_pincode() {
        return customer_pincode;
    }
    public void setCustomer_pincode(int customer_pincode) {
        this.customer_pincode = customer_pincode;
    }
    public String getCustomer_house_no() {
        return customer_house_no;
    }
    public void setCustomer_house_no(String customer_house_no) {
        this.customer_house_no = customer_house_no;
    }
    
}
