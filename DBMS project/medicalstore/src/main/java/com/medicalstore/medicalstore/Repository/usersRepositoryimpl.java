package com.medicalstore.medicalstore.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.medicalstore.medicalstore.models.Customer;
import com.medicalstore.medicalstore.models.users;

@Repository
public class usersRepositoryimpl implements usersRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_USER_QUERY="INSERT INTO USERS VALUES(?,?,?,?,?,?)";
    private static final String GET_USER_BY_ID_QUERY="SELECT * FROM USERS WHERE USERNAME=?";
    private static final String GET_CUSTOMER_BY_USERNAME_QUERY="SELECT * FROM MEDICALSTORE.CUSTOMER WHERE IDCUSTOMER = (SELECT user_id FROM MEDICALSTORE.USERS WHERE USERNAME=?)";
    private static final String UPDATE_CUSTOMER_ADDRESS_QUERY="UPDATE MEDICALSTORE.CUSTOMER SET CUSTOMER_PHN_NO=?,CUSTOMER_HOUSE_NO=?,CUSTOMER_STREET=?,CUSTOMER_CITY=?,CUSTOMER_PINCODE=?,CUSTOMER_STATE=? WHERE IDCUSTOMER=?";
    private static final String USERNAME_EXISTS="SELECT EXISTS(SELECT * FROM USERS WHERE USERNAME=?)";
    private static final String EMAIL_EXTSTS="SELECT EXISTS(SELECT * FROM USERS WHERE EMAIL=?)";
    // private static final String INSERT_CUSTOMER_QUERY="INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_CUSTOMER_QUERY="INSERT INTO CUSTOMER(customer_name,customer_sex,customer_phn_no,customer_aadhar_no,customer_state,customer_street,customer_city,customer_pincode,customer_house_no,customer_dob) VALUES(?,?,?,?,?,?,?,?,?,?)";
    @Override
    public users save(users user) {
        jdbcTemplate.update(INSERT_USER_QUERY,user.getUser_id(),user.getUsername(),user.getPassword(),user.getRole(),user.getEnabled(),user.getEmail());
        return user;
    }

    @Override
    public int save_customer(Customer customer){
        
        // jdbcTemplate.update(INSERT_CUSTOMER_QUERY,customer.getIdcustomer(),customer.getUsername(),customer.getCustomer_sex(),customer.getCustomer_ph_no(),customer.getCustomer_aadhar_no(),customer.getCustomer_state(),customer.getCustomer_street(),customer.getCustomer_city(),customer.getCustomer_pincode(),customer.getCustomer_house_no());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER_QUERY, new String[] { "ID" });
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getCustomer_sex());
            ps.setString(3, customer.getCustomer_ph_no());
            ps.setString(4,customer.getCustomer_aadhar_no());
            ps.setString(5,customer.getCustomer_state());
            ps.setString(6, customer.getCustomer_street());
            ps.setString(7, customer.getCustomer_city());
            ps.setInt(8, customer.getCustomer_pincode());
            ps.setString(9, customer.getCustomer_house_no());
            ps.setDate(10, (new java.sql.Date(customer.getCustomer_dob().getTime())));
            return ps;
          }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public users findbyEmail(String email) {
        RowMapper<users> rowMapper=new RowMapperImpl();
        users user = this.jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, rowMapper,email);
        return user;
    }

    @Override
    public Customer fetch_by_username(String username) {
        RowMapper<Customer> rowMapper = new CustomerMapper();
        Customer customer = this.jdbcTemplate.queryForObject(GET_CUSTOMER_BY_USERNAME_QUERY, rowMapper,username);
        return customer;
    }

    @Override
    public void update_customer_address(int id,String mobile_no,String house_no,String street,String city,int pincode,String state ){
        jdbcTemplate.update(UPDATE_CUSTOMER_ADDRESS_QUERY,mobile_no,house_no,street,city,pincode,state,id);
    }

    @Override
    public boolean username_exists(String username){

        return jdbcTemplate.queryForObject(USERNAME_EXISTS,Boolean.class, username);
    }

    @Override
    public boolean email_exists(String email){
        return jdbcTemplate.queryForObject(EMAIL_EXTSTS, Boolean.class,email);
    }

}
