package com.medicalstore.medicalstore.models;

import org.springframework.data.annotation.Id;


public class users {
    @Id
    private String username;
    private int user_id;
    private String email;
    private String password;
    private String role;
    private int enabled;
    
    public users(String username, int user_id, String email, String password, String role, int enabled) {
        this.username = username;
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }
    
    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public users() {
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }

    public int getEnabled(){
        return enabled;
    }
    public void setEnabled(int enabled){
        this.enabled = enabled;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
      
}
