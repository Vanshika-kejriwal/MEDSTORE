package com.medicalstore.medicalstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.Repository.usersRepository;
import com.medicalstore.medicalstore.Service.myuserdetails;
import com.medicalstore.medicalstore.models.users;

@Service
public class userdetailservice  implements UserDetailsService{

    @Autowired
    usersRepository usersrepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users user = usersrepository.findbyEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new myuserdetails(user);
    }
    
}
