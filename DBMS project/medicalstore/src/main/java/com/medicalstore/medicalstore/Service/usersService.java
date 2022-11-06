package com.medicalstore.medicalstore.Service;


import com.medicalstore.medicalstore.models.Customer;
import com.medicalstore.medicalstore.models.users;
import com.medicalstore.medicalstore.web.dto.Address;
import com.medicalstore.medicalstore.web.dto.usersRegistrationdto;

public interface usersService{
    users save(usersRegistrationdto registrationdto);
    Customer fetch_by_username(String username);
    users fetchbyEmail(String username);
    void update_customer_address(String username, Address address);
    boolean username_exists(String username);
    boolean email_exists(String email);
}
