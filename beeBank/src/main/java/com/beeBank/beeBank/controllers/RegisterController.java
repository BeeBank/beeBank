package com.beeBank.beeBank.controllers;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beeBank.beeBank.helpers.HTML;
import com.beeBank.beeBank.helpers.Token;
import com.beeBank.beeBank.models.User;

@Controller
public class RegisterController {
    
    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("In Register Page Controller");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("regiserUser")User user, 
                                BindingResult result,
                                @RequestParam("first_name") String first_name,
                                @RequestParam("last_name") String last_name,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password,
                                @RequestParam("confirm_password") String confirm_passord)
                                {
        ModelAndView registrationPage = new ModelAndView("register");

        //Check for errors:
        if(result.hasErrors() && confirm_passord.isEmpty()){
            registrationPage.addObject("confirm_pass", "The confirm field is required");
            return registrationPage;
        }
        
        // TODO: CHECK FOR PASSWORD MATCH
        if(!password.equals(confirm_passord)){
            registrationPage.addObject("passwprdMisMatch", "passwords do not match");
            return registrationPage;
        }
        // TODO: GET TOKEN STRING:
        String token = Token.generateToken();
        // TODO: GENERATE RANDOM CODE
        Random rand = new Random();
        int bound = 123;
        int code = bound * rand.nextInt(bound);
        

        // TODO: GET EMAIL HTML BODY:
        String emailBody = HTML.htmlEmailTemplate(token,Integer.toString(code)); 
        // TODO: HASH PASSWORD:
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());
        // TODO: REGISTER USER:
        
        // TODO: SEND EMAIL NOTIFICATION:

        // TODO: RETURN TO REGISTER PAGE:



        return registrationPage;
    }
}
