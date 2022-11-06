package com.medicalstore.medicalstore.Repository;

import com.medicalstore.medicalstore.models.Customer;
import com.medicalstore.medicalstore.models.users;

public interface usersRepository {
    users save(users user);
    users findbyEmail(String email);
    int save_customer(Customer customer);
    Customer fetch_by_username(String username);
    void update_customer_address(int id,String mobile_no,String house_no,String street,String city,int pincode,String state );
    boolean username_exists(String username);
    boolean email_exists(String email);
}
