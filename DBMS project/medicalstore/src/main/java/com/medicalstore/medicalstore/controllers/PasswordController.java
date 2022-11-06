package com.medicalstore.medicalstore.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {
    Random random = new Random(1000);

   @GetMapping("/forgotpassword") 
   public String forgot_password()
   {
    return "forgotpassword";
   }

   @PostMapping("/confirm_otp")
   public String send_otp(@RequestParam("email") String email){
        System.out.println("Email "+email);

        
        int otp = random.nextInt(999999999);
        System.out.println("OTP: "+otp);
        return "confirmforgetpassword";
   }
}
