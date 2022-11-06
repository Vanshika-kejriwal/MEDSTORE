package com.medicalstore.medicalstore.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.authentication.AnonymousAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

import com.medicalstore.medicalstore.Service.myuserdetails;

@Controller 
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Boolean auth = false;
        if(user instanceof myuserdetails)
        {
            auth=true;
            myuserdetails user1 = (myuserdetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("username", user1.getUsername());
            
        }
        model.addAttribute("auth", auth);
        return "index";
    }


    @GetMapping("/empty_cart")
    public String empty_cart(){
        return "emptycart";
    }
    @GetMapping("/orders")
    public String orders(){
        return "orders";
    }
    @GetMapping("/product_detail")
    public String product_detail(){
        return "productdetail";
    }
    // @GetMapping("/signup")
    // public String signup(){
    //     return "signup";
    // }
    // @GetMapping("/profile/editaddress")
    // public String edit_address(){
    //     return "editaddress";
    // }
}

