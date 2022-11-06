package com.medicalstore.medicalstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.medicalstore.medicalstore.Repository.usersRepository;
import com.medicalstore.medicalstore.Service.myuserdetails;
import com.medicalstore.medicalstore.Service.usersService;
import com.medicalstore.medicalstore.Service.usersServiceImpl;
import com.medicalstore.medicalstore.models.Customer;
import com.medicalstore.medicalstore.models.users;
import com.medicalstore.medicalstore.web.dto.Address;

@Controller
public class userController {
    
    @Autowired
    usersServiceImpl usersservice;

    @GetMapping("/login")
    public String login(Model model){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user instanceof myuserdetails)
        {   
            myuserdetails user1 =  (myuserdetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = user1.getUsername();
            System.out.println(username);
            model.addAttribute("username",username);
            return "/success";
        }
        return "login";
    }

    @GetMapping("/success")
    public String home(){
        return "success";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        myuserdetails user1 = (myuserdetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = usersservice.fetch_by_username(user1.getUsername());
        users user = usersservice.fetchbyEmail(user1.getUsername());
        model.addAttribute("name", customer.getUsername());
        model.addAttribute("state", customer.getCustomer_state());
        model.addAttribute("mobile_no", customer.getCustomer_ph_no());
        model.addAttribute("gender", customer.getCustomer_sex());
        model.addAttribute("aadhar_no", customer.getCustomer_aadhar_no());
        model.addAttribute("house_no", customer.getCustomer_house_no());
        model.addAttribute("street",customer.getCustomer_street());
        model.addAttribute("pincode", customer.getCustomer_pincode());
        model.addAttribute("city", customer.getCustomer_city());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("username", user1.getUsername());
        return "profile"; 
    }

    @GetMapping("/profile/editaddress")
    public String editaddress(Model model)
    {
        model.addAttribute("address", new Address());
        return "editaddress";
    }

    @PostMapping("/profile/editaddress")
    public String addaddress(@ModelAttribute Address address)
    {
        myuserdetails user = (myuserdetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usersservice.update_customer_address(user.getUsername(), address);

        return "redirect:/profile";
    }



}
