package com.beeBank.beeBank.controller_adviser;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.beeBank.beeBank.models.User;

@ControllerAdvice
public class AdvisorController {
    
    @ModelAttribute("registerUser")
    public User getUserDefaults(){
        return new User();
    }
}
