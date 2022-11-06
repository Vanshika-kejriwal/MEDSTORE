package com.medicalstore.medicalstore.Service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.medicalstore.medicalstore.models.users;

public class myuserdetails implements UserDetails {

    private String username;
    private String password;
    private int enabled;
    private String role;
    public myuserdetails(users user){
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.enabled=user.getEnabled();
        this.role=user.getRole();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if(enabled!=0)
        return true;
        else
        return false;
    }
    
}
