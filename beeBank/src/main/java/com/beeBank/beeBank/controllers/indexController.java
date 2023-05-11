package com.beeBank.beeBank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        System.out.println("In index Controller");
        return getIndexPage;
    }
    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView getIndexPage = new ModelAndView("login");
        System.out.println("In Login Page Controller");
        getIndexPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }
    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getIndexPage = new ModelAndView("register");
        System.out.println("In Register Page Controller");
        getIndexPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }
    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView getIndexPage = new ModelAndView("error");
        System.out.println("In Register Page Controller");
        getIndexPage.addObject("PageTitle", "Errors");
        return getErrorPage;
    }
    
}
