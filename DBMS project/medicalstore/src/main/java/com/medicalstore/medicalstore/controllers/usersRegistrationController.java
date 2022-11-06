package com.medicalstore.medicalstore.controllers;

import java.text.NumberFormat.Style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medicalstore.medicalstore.Service.usersService;
import com.medicalstore.medicalstore.web.dto.usersRegistrationdto;

@Controller
@RequestMapping("/registration")
public class usersRegistrationController {
    
    @Autowired
    private usersService usersservice;

    // public usersRegistrationController(usersService usersservice){
    //     super();
    //     this.usersservice=usersservice;
    // }

    @ModelAttribute("user")
    public usersRegistrationdto usersregistrationdto(){
        return new usersRegistrationdto();
    }

    @GetMapping
    public String showRegistrationForm() {
        // model.addAttribute("user", new usersRegistrationdto());
        System.out.println("in controller get.");
        
        return "signup";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") usersRegistrationdto registrationdto,Model model){
        System.out.println("in controller post before userservice save");
        boolean password_error = true;
        boolean username_error = false;
        boolean email_error  = false;

        if(registrationdto.getPassword().equals(registrationdto.getConfirm_password()))
        {
            password_error=false;
        }
        username_error=usersservice.username_exists(registrationdto.getUsername());
        email_error=usersservice.email_exists(registrationdto.getEmail());
        model.addAttribute("username_error", username_error);
        model.addAttribute("password_error", password_error);
        model.addAttribute("email_error", email_error);
        if(username_error || password_error || email_error)
        {
            System.out.println("error");
            System.out.println(registrationdto.getPassword());
            System.out.println(registrationdto.getConfirm_password());
            System.out.println("password error :"+password_error);
            System.out.println("email error :"+email_error);
            System.out.println("username_error :"+username_error);
            return "signup";
        }
        usersservice.save(registrationdto);
        System.out.println("in controller post.");

        return "redirect:/registration?success";
    }


}
