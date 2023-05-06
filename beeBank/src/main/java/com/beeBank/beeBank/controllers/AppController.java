package com.beeBank.beeBank.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class AppController {

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session) {
        ModelAndView getDashBoardPage = new ModelAndView("dashboard");

        //this is where you get details of the logged in user

        User user = (User) session.getAttribute("user");

        //get the accounts of the user

        //get balance

        //set objects

        return getDashBoardPage;
    }
    
}
