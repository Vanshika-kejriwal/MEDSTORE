package com.medicalstore.medicalstore.Service;

 
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.medicalstore.medicalstore.Repository.usersRepository;
import com.medicalstore.medicalstore.models.Customer;
import com.medicalstore.medicalstore.models.users;
import com.medicalstore.medicalstore.web.dto.Address;
import com.medicalstore.medicalstore.web.dto.usersRegistrationdto;

@Service
public class usersServiceImpl implements usersService,UserDetailsService{

    private usersRepository usersrepository;

    public usersServiceImpl(usersRepository usersrepository){
        super();
        this.usersrepository = usersrepository;
    }

    // @Autowired
    // private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public users save(usersRegistrationdto registrationdto) {
        // users user = new users(registrationdto.getUsername(),registrationdto.getPassword(),"ROLE_USER",1);
        Customer customer = new Customer(registrationdto.getName(),registrationdto.getGender(),registrationdto.getMobile_no(),registrationdto.getAadhar_no(),registrationdto.getState(),registrationdto.getStreet(),registrationdto.getCity(),registrationdto.getPincode(),registrationdto.getHouse_no(),registrationdto.getDob());
        int id = usersrepository.save_customer(customer);
        users user = new users(registrationdto.getUsername(),id,registrationdto.getEmail(),passwordEncoder.encode(registrationdto.getPassword()),"ROLE_USER",1);
        return usersrepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        users user = usersrepository.findbyEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new myuserdetails(user);
    }

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     users user = usersrepository.findbyEmail(username);
    //     if(user == null){
    //         throw new UsernameNotFoundException("invalid username or password");
    //     }

    //     return new User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRole()));
    // }
    // private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String r){
    //     Collection<String> roles = Arrays.asList(r);
	// 	return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	// }


    public Customer fetch_by_username(String username){

        Customer customer = usersrepository.fetch_by_username(username);
        return customer;
    }

    public users fetchbyEmail(String username){
        users user = usersrepository.findbyEmail(username);
        return user;
    }

    public void update_customer_address(String username, Address address){
        users user = usersrepository.findbyEmail(username);
        usersrepository.update_customer_address(user.getUser_id(), address.getMobile_no(), address.getHouse_no(), address.getStreet(), address.getCity(), address.getPincode(), address.getState());
        
    }

    @Override
    public boolean username_exists(String username) {
        return usersrepository.username_exists(username);
    }

    @Override
    public boolean email_exists(String email) {
        return usersrepository.email_exists(email);
    }
    
}
