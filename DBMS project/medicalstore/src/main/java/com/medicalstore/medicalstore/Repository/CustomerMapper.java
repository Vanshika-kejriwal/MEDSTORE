package com.medicalstore.medicalstore.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.medicalstore.medicalstore.models.Customer;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    @Nullable
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setIdcustomer(rs.getInt(1));
        customer.setUsername(rs.getString(2));
        customer.setCustomer_sex(rs.getString(3));
        customer.setCustomer_ph_no(rs.getString(4));
        customer.setCustomer_aadhar_no(rs.getString(5));
        customer.setCustomer_state(rs.getString(6));
        customer.setCustomer_street(rs.getString(7));
        customer.setCustomer_city(rs.getString(8));
        customer.setCustomer_pincode(rs.getInt(9));
        customer.setCustomer_house_no(rs.getString(10));
        customer.setCustomer_dob(rs.getDate(11));
        return customer;
    }
    
}
